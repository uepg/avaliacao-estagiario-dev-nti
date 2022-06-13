<?php

namespace App\Controllers;

use App\Controllers\BaseController;

use App\Entities\Item;

class Itens extends BaseController
{
    private $itemModel;

    public function __construct()
    {
        $this->itemModel = new \App\Models\ItemModel();
    }

    public function index()
    {
        $data = [

            'titulo' => 'Listando os itens do sistema',
        ];

        return view("Itens/index", $data);
    }

    public function exibir(int $id = null)
    {

        $item = $this->buscaItemOu404($id);

        $data = [

            'titulo' => 'Detalhando o item ' . $item->nome,
            'item' => $item,
        ];

        return view("Itens/exibir", $data);
    }

    public function criar(int $id = null)
    {
        helper(['form', 'url']);

        $item = new Item();

        $data = [

            'titulo' => 'Cadastrando novo produto ',
            'item' => $item,
        ];

        return view("Itens/criar", $data);
    }

    public function cadastrar()
    {
    
        if (!$this->request->isAJAX()) {
            return redirect()->back();
        }

        //envio o hash do token do form
        $retorno['token'] = csrf_hash();

        //recupera o post da requisição
        $post = $this->request->getPost();

        $item = new Item($post);

        $item->fill($post);

        $precoVenda = str_replace([',', '.'], '', $item->valor_unitario);

        if ($precoVenda < 0) {

            $retorno['erro'] = 'Verifique os erros abaixo e tente novamente!';
            $retorno['erros_model'] = ['itens' => 'O preço de venda <b class="text-white">não pode ser menor</b> que o zero!'];

            return $this->response->setJSON($retorno);
        }

        if ($this->itemModel->save($item)) {

            $btnCriar = anchor("Itens/criar", 'Cadastrar novo item', ['class' => 'btn btn-danger mt-2']);

            session()->setFlashdata('sucesso', "Dados salvos com sucesso!<br> $btnCriar");

            $retorno['id'] = $this->itemModel->getInsertID();
            //flash data
            return $this->response->setJSON($retorno);
        }

        //retornamos os erros de validação
        $retorno['erro'] = 'Por favor verifique os erros de validação e tente novamente!';
        $retorno['erros_model'] = $this->itemModel->errors();

        //retorno para o ajax request
        return $this->response->setJSON($retorno);
    }

    public function editar(int $id = null)
    {
        helper(['form', 'url']);

        $item = $this->buscaItemOu404($id);

        $data = [

            'titulo' => 'Editando o item ' . $item->nome,
            'item' => $item,
        ];

        return view("Itens/editar", $data);
    }

    public function atualizar()
    {

        if (!$this->request->isAJAX()) {
            return redirect()->back();
        }

        //envio o hash do token do form
        $retorno['token'] = csrf_hash();

        //recupera o post da requisição
        $post = $this->request->getPost();

        $item = $this->buscaItemOu404($post['id']);

        $item->fill($post);

        if ($item->hasChanged() === false) {

            $retorno['info'] = 'Não há dados para atualizar';

            return $this->response->setJSON($retorno);
        }

        $precoVenda = str_replace([',', '.'], '', $item->valor_unitario);

        if ($precoVenda < 0) {

            $retorno['erro'] = 'Verifique os erros abaixo e tente novamente!';
            $retorno['erros_model'] = ['itens' => 'O preço de venda <b class="text-white">não pode ser menor</b> que o zero!'];

            return $this->response->setJSON($retorno);
        }

        if ($this->itemModel->save($item)) {

            session()->setFlashdata('sucesso', 'Dados salvos com sucesso!');

            //flash data
            return $this->response->setJSON($retorno);
        }

        //retornamos os erros de validação
        $retorno['erro'] = 'Por favor verifique os erros de validação e tente novamente!';
        $retorno['erros_model'] = $this->itemModel->errors();

        //retorno para o ajax request
        return $this->response->setJSON($retorno);
    }

    public function recuperaItens()
    {

        if (!$this->request->isAJAX()) {
            return redirect()->back();
        }

        $atributos = [
            'id',
            'nome',
            'valor_unitario',
            'deletado_em',
        ];

        $itens = $this->itemModel->select($atributos)
            ->orderBy('id', 'DESC')
            ->findAll();

        $data = [];

        foreach ($itens as $item) {

            $nomeItem = esc($item->nome);

            $data[] = [

                'nome' => anchor("Itens/exibir/$item->id", esc($item->nome), 'title="Exibir ' . $nomeItem . '"'),
                'valor_unitario' => 'R$&nbsp;' . $item->valor_unitario,
            ];
        }

        $retorno = [

            'data' => $data,
        ];

        return $this->response->setJSON($retorno);
    }

    public function excluir(int $id = null)
    {
        helper(['form', 'url']);

        $item = $this->buscaItemOu404($id);

        if ($item->deletado_em != null) {

            return redirect()->back()->with('info', "Item $item->nome já encotra-se excluido.");
        }

        if ($this->request->getMethod() === 'post') {

            $this->itemModel->delete($item->id);

            return redirect()->to(site_url("itens"))->with('sucesso', "Item $item->nome excluido com sucesso.");
        }

        $data = [

            'titulo' => 'Excluindo item ' . $item->nome,
            'item' => $item,
        ];

        return view('Itens/excluir', $data);
    }

    public function restauraritem(int $id = null)
    {

        $item = $this->buscaitemOu404($id);

        if ($item->deletado_em == null) {
            return redirect()->back()->with('info', "Esse item encontra-se ativo, impossivel restaura-lo");
        }

        $item->deletado_em = null;
        $this->itemModel->protect(false)->save($item);

        return redirect()->back()->with('sucesso', "item $item->nome restaurado com sucesso!");
    }

//  ----------------------------------- buscas ---------------------------

    private function buscaItemOu404(int $id = null)
    {

        if (!$id || !$item = $this->itemModel->withDeleted(true)->find($id)) {

            throw \CodeIgniter\Exceptions\PageNotFoundException::forPageNotFound("Não encontramos o item $id");
        }

        return $item;
    }
}
