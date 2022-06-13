<?php

namespace App\Controllers;

use App\Controllers\BaseController;

use App\Traits\VendaTrait;

class VendasItens extends BaseController
{
    use VendaTrait;

    private $vendaModel;
    private $vendaItemModel;
    private $itemModel;

    public function __construct()
    {
        $this->vendaModel = new \App\Models\VendaModel();
        $this->vendaItemModel = new \App\Models\VendaItemModel();
        $this->itemModel = new \App\Models\ItemModel();
    }

    public function itens(string $id = null)
    {

        $venda = $this->vendaModel->buscaVendaOu404($id);

        $this->preparaItensDaVenda($venda);

        $data = [
            'titulo' => "Gerenciando os itens da venda $venda->id",
            'venda' => $venda,
        ];

        return view('Vendas/itens', $data);
    }

    public function pesquisaItens()
    {

        if (!$this->request->isAJAX()) {
            return redirect()->back();
        }

        $term = $this->request->getGet('term');

        $itens = $this->itemModel->pesquisaItens($term);

        $retorno = [];

        foreach ($itens as $item) {

            $data['id'] = $item->id;
            $data['item_preco'] = number_format($item->valor_unitario, 2);

            $data['value'] = "[ Código $item->id ] $item->nome ";

            $data['label'] = '<span>'. $data['value'] . '</span>';

            $retorno[] = $data;
        }

        return $this->response->setJSON($retorno);
    }

    public function adicionarItem()
    {

        if (!$this->request->isAJAX()) {
            return redirect()->back();
        }

        //envio o hash do token do form
        $retorno['token'] = csrf_hash();

        $validacao = service('validation');

        $regras = [
            'item_id' => 'required',
            'item_quantidade' => 'required|greater_than[0]',
        ];

        $mensagens = [   // Errors
            'item_id' => [
                'required' => 'É necessario escolher um item válido!',
            ],
            'item_quantidade' => [
                'required' => 'É necessario escolher uma quantidade!',
                'greater_than' => 'A quantidade precisa ser maior que 0!',
            ],
        ];

        $validacao->setRules($regras, $mensagens);

        if ($validacao->withRequest($this->request)->run() === false) {

            //retornamos os erros de validação
            $retorno['erro'] = 'Por favor verifique os erros de validação e tente novamente!';
            $retorno['erros_model'] = $validacao->getErrors();

            //retorno para o ajax request
            return $this->response->setJSON($retorno);
        }

        //recupera o post da requisição
        $post = $this->request->getPost();

        //echo '<pre>';
        //print_r($post);
        //exit;

        //se venda existe
        $venda = $this->vendaModel->buscaVendaOu404($post['id']);

        //se item existe
        $item = $this->buscaItemOu404($post['item_id']);

        if ($this->verificaSeVendaPossuiItem($venda->id, $item->id)) {

            $retorno['erro'] = 'Por favor verifique os erros de validação e tente novamente!';
            $retorno['erros_model'] = ['estoque' => 'Essa venda já possui este produto, não é possível inserir!'];

            //retorno para o ajax request
            return $this->response->setJSON($retorno);
        }

        $vendaItem = [
            'venda_id' => (int) $venda->id,
            'item_id' => (int) $item->id,
            'item_quantidade' => (int) $post['item_quantidade'],
        ];

        if ($this->vendaItemModel->insert($vendaItem)) {

            session()->setFlashdata('sucesso', "$item->nome adicionado à venda com sucesso!");

            return $this->response->setJSON($retorno);
        }

        $retorno['erro'] = 'Por favor verifique os erros de validação e tente novamente!';
        $retorno['erros_model'] = $this->vendaItemModel->errors();

        //retorno para o ajax request
        return $this->response->setJSON($retorno);
    }

    public function atualizarQuantidade(string $codigo = null)
    {

        if ($this->request->getMethod() !== 'post') {
            
            return redirect()->back();
        }

        //envio o hash do token do form
        $retorno['token'] = csrf_hash();

        $validacao = service('validation');

        $regras = [
            'item_id' => 'required',
            'item_quantidade' => 'required|greater_than[0]',
            'id_principal' => 'required|greater_than[0]', //pk table ordens-itens
        ];

        $mensagens = [   // Errors
            'item_id' => [
                'required' => 'É necessario escolher um item válido!',
            ],
            'item_quantidade' => [
                'required' => 'É necessario escolher uma quantidade!',
                'greater_than' => 'A quantidade precisa ser maior que 0!',
            ],
            'id_principal' => [
                'required' => 'Não foi possível atualizar o item!',
                'greater_than' => 'O id do item precisa ser maior que 0!',
            ],
        ];

        $validacao->setRules($regras, $mensagens);

        if ($validacao->withRequest($this->request)->run() === false) {


            return redirect()->back()->with('atencao', 'Por favor verifique os erros de validação e tente novamente!')
            ->with('erros_model', $validacao->getErrors());
        }

        //recupera o post da requisição
        $post = $this->request->getPost();

        //echo '<pre>';
        //print_r($post);
        //exit;

        //se venda existe
        $venda = $this->vendaModel->buscaVendaOu404($codigo);

        //se item existe
        $item = $this->buscaItemOu404($post['item_id']);

        $vendaItem = $this->buscaVendaItemOu404($post['id_principal'], $venda->id);

        if ($item->tipo === 'produto' && $post['item_quantidade'] > $item->estoque) {

            return redirect()->back()->with('atencao', 'Por favor verifique os erros de validação e tente novamente!')
            ->with('erros_model', ['estoque' => 'Quantidade é maior que a disponível em estoque, não é possível adicionar!']);
        }

        if($post['item_quantidade'] === $vendaItem->item_quantidade){

            return redirect()->back()->with('info', 'Informe uma quantidade diferente da atual!');

        }

        //aqui já passou por todas as verificações, então pode alterar na tabela
        $vendaItem->item_quantidade = $post['item_quantidade'];

        if($this->vendaItemModel->atualizaQuantidadeItem($vendaItem)){

            return redirect()->back()->with('sucesso', 'Quantidade atualizada com sucesso!');

        }

        return redirect()->back()->with('atencao', 'Por favor verifique os erros de validação e tente novamente!')
        ->with('erros_model', $this->vendaItemModel->errors());

    }

    public function removerItem(string $codigo = null)
    {

        if ($this->request->getMethod() !== 'post') {
            
            return redirect()->back();
        }

        //envio o hash do token do form
        $retorno['token'] = csrf_hash();

        $validacao = service('validation');

        $regras = [
            'item_id' => 'required',
            'id_principal' => 'required|greater_than[0]', //pk table ordens-itens
        ];

        $mensagens = [   // Errors
            'item_id' => [
                'required' => 'É necessario escolher um item válido para exclusão!',
            ],
            'id_principal' => [
                'required' => 'Não foi possível remover o item!',
                'greater_than' => 'Não foi possível remover o item!',
            ],
        ];

        $validacao->setRules($regras, $mensagens);

        if ($validacao->withRequest($this->request)->run() === false) {


            return redirect()->back()->with('atencao', 'Por favor verifique os erros de validação e tente novamente!')
            ->with('erros_model', $validacao->getErrors());
        }

        //recupera o post da requisição
        $post = $this->request->getPost();

        //echo '<pre>';
        //print_r($post);
        //exit;

        //se venda existe
        $venda = $this->vendaModel->buscaVendaOu404($codigo);

        //se item existe
        $item = $this->buscaItemOu404($post['item_id']);

        $vendaItem = $this->buscaVendaItemOu404($post['id_principal'], $venda->id);

        //aqui já passou por todas as verificações, então pode alterar na tabela

        if($this->vendaItemModel->delete($vendaItem->id)){

            return redirect()->back()->with('sucesso', 'Item removido com sucesso!');

        }

        return redirect()->back()->with('atencao', 'Por favor verifique os erros de validação e tente novamente!')
        ->with('erros_model', $this->vendaItemModel->errors());

    }

    private function buscaItemOu404(int $id = null)
    {

        if (!$id || !$item = $this->itemModel->withDeleted(true)->find($id)) {

            throw \CodeIgniter\Exceptions\PageNotFoundException::forPageNotFound("Não encontramos o item $id");
        }

        return $item;
    }

    //id principal do item
    private function buscaVendaItemOu404(int $id_principal = null, int $venda_id)
    {

        if (!$id_principal || !$vendaItem = $this->vendaItemModel
        ->where('id', $id_principal)
        ->where('venda_id', $venda_id)
        ->first()) {

            throw \CodeIgniter\Exceptions\PageNotFoundException::forPageNotFound("Não encontramos o registro principal $id_principal");
        }

        return $vendaItem;
    }

    private function verificaSeVendaPossuiItem(int $venda_id, int $item_id): bool
    {

        $possuiItem = $this->vendaItemModel->where('venda_id', $venda_id)->where('item_id', $item_id)->first();

        if ($possuiItem === null) {

            return false;
        }

        return true;
    }
}
