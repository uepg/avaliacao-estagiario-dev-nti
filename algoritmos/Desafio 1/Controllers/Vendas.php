<?php

namespace App\Controllers;

use App\Controllers\BaseController;

use App\Entities\Venda;

use App\Traits\VendaTrait;

class Vendas extends BaseController
{
    use VendaTrait;

    private $vendaModel;

    public function __construct()
    {
    
        $this->vendaModel = new \App\Models\VendaModel();
    }

    public function index()
    {
        $data = [
            'titulo' => 'Listando as vendas',
        ];

        return view('Vendas/index', $data);
    }

    public function recuperaVendas()
    {

        if (!$this->request->isAJAX()) {
            return redirect()->back();
        }

        $vendas = $this->vendaModel->recuperaVendas();

        //receberá o array de objetos de vendas
        $data = [];

        foreach ($vendas as $venda) {

            $data[] = [
                'codigo' => anchor("Vendas/detalhes/$venda->id", esc($venda->id), 'title="Exibir ' . esc($venda->id) . '"'),
                'nome' => esc($venda->nome),
                'criado_em' => date('d/m/Y',strtotime($venda->criado_em)),
            ];
        }

        $retorno = [
            'data' => $data,
        ];
        
        //echo '<pre>';
        //print_r($retorno);
        //exit;

        return $this->response->setJSON($retorno);
    }

    public function criar()
    {
        helper(['form', 'url']);

        $venda = new Venda();

        $data = [
            'titulo' => 'Cadastrando nova venda',
            'venda' => $venda,
        ];

        return view('Vendas/criar', $data);
    }

    public function cadastrar()
    {
        helper(['form', 'url']);

        if (!$this->request->isAJAX()) {
            return redirect()->back();
        }

        //envio o hash do token do form
        $retorno['token'] = csrf_hash();

        //recupera o post da requisição
        $post = $this->request->getPost();

        $venda = new Venda($post);

        if ($this->vendaModel->save($venda)) {

            session()->setFlashdata('sucesso', 'Dados salvos com sucesso!');

            $retorno['id'] = $this->vendaModel->getInsertID();
            //flash data
            return $this->response->setJSON($retorno);
        }

        //retornamos os erros de validação
        $retorno['erro'] = 'Por favor verifique os erros de validação e tente novamente!';
        $retorno['erros_model'] = $this->vendaModel->errors();

        //retorno para o ajax request
        return $this->response->setJSON($retorno);
    }

    public function detalhes(string $id = null)
    {
        helper(['form', 'url']);

        $venda = $this->vendaModel->buscaVendaOu404($id);

        $this->preparaItensDaVenda($venda);

        $data = [
            'titulo' => "Detalhando a venda código: $venda->id",
            'venda' => $venda,
        ];

        return view('Vendas/detalhes', $data);
    }

    public function editar(string $id = null)
    {
        helper(['form', 'url']);

        $venda = $this->vendaModel->buscaVendaOu404($id);

        $data = [
            'titulo' => "Editando a venda código: $venda->id",
            'venda' => $venda,
        ];

        return view('Vendas/editar', $data);
    }

    public function atualizar()
    {
        helper(['form', 'url']);

        if (!$this->request->isAJAX()) {
            return redirect()->back();
        }

        //envio o hash do token do form
        $retorno['token'] = csrf_hash();

        //recupera o post da requisição
        $post = $this->request->getPost();

        //validamos a existência da venda
        $venda = $this->vendaModel->buscaVendaOu404($post['id']);
        
        $venda->fill($post);

        if ($venda->hasChanged() === false) {

            $retorno['info'] = 'Não há dados para serem atualizados';
            return $this->response->setJSON($retorno);
        }

        if ($this->vendaModel->save($venda)) {

            session()->setFlashdata('sucesso', 'Dados salvos!');

            $retorno['redirect'] = "Vendas/index";

            //flash data
            return $this->response->setJSON($retorno);
        }

        //retornamos os erros de validação
        $retorno['erro'] = 'Por favor verifique os erros de validação e tente novamente!';
        $retorno['erros_model'] = $this->vendaModel->errors();

        //retorno para o ajax request
        return $this->response->setJSON($retorno);
    }

    public function excluir(string $codigo = null)
    {
        helper(['form', 'url']);

        $venda = $this->vendaModel->buscaVendaOu404($codigo);

        if ($venda->deletado_em != null) {

            return redirect()->back()->with("info", "A venda código: $venda->id já encontra-se excluída");
        }

        if ($this->request->getMethod() === 'post') {

            $this->vendaModel->delete($venda->id);

            return redirect()->to(site_url("vendas"))->with("sucesso", "venda código: $venda->id, excluída com sucesso!");
        }

        $data = [
            'titulo' => "Excluíndo a venda código: $venda->id",
            'venda' => $venda,
        ];

        return view('Vendas/excluir', $data);
    }

    public function encerrar(string $codigo = null)
    {
        helper(['form', 'url']);

        $venda = $this->vendaModel->buscavendaOu404($codigo);

        if ($venda->situacao !== 'aberta') {

            return redirect()->back()->with('atencao', 'Apenas vendas em aberto podem ser encerradas.');
        }

        $this->preparaItensDavenda($venda);

        $data = [
            'titulo' => "Encerrar a venda código: $venda->id",
            'venda' => $venda,
        ];

        return view("vendas/encerrar", $data);
    }

    public function processaEncerramento(string $id = null)
    {
        helper(['form', 'url']);

        //envio o hash do token do form
        $retorno['token'] = csrf_hash();

        $venda = $this->vendaModel->buscavendaOu404($id);

        $this->preparaItensDavenda($venda);

        //outros pagamentos
        $this->preparavendaParaEncerrar($venda);

        $venda->situacao = 'encerrada';

        if ($this->vendaModel->save($venda)) {

            session()->setFlashdata('sucesso', 'A venda foi encerrada!');

            //descerializa, pois a view envia serializada
            if ($venda->itens !== null) {

                $venda->itens = unserialize($venda->itens);
            }

            $retorno['redirect'] = "Vendas/index";

            return $this->response->setJSON($retorno);
        }

        //retornamos os erros de validação
        $retorno['erro'] = 'Por favor verifique os erros de validação e tente novamente!';
        $retorno['erros_model'] = $this->vendaModel->errors();

        //retorno para o ajax request
        return $this->response->setJSON($retorno);
    }
}
