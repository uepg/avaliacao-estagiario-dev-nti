<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;


/* Imports das Models necessárias para este Controller */
use App\Models\Produto;

/* Dependências*/

class ProdutoController extends Controller {
 /* #####################################
    #######     1. Index (Listagem)
    ##################################### */
    public function index () {
        // 1.1. Select do banco
        $produtos = Produto::all()->sortBy('codigo');
        
        // 1.2. Retorna a view
        return view('produto/index', compact('produtos'));
    }   

    /* #####################################
    #######     2. Create
    ##################################### */
    public function create () {
        // 2.1. Retorna a view para criação do produto
        return view('produto/create');        
    }

    /* #####################################
    #######     3. Edit
    ##################################### */
    public function edit ($id) {
        // 3.1. Encontra o produto
        $produto = Produto::find($id);
        
        // 3.2. Retorna a View para editar
        return view('produto/edit', compact('produto'));      
    }

    /* #####################################
    #######     4. Show
    ##################################### */
    public function show ($id) {
        // 4.1. Encontra o registro do produto
        $produto = Produto::find($id);
        
        // 4.2. Retorna a view com info do produto
        return view('produto/show', compact('produto'));        
    }

    /* #####################################
    #######     5. Store
    ##################################### */
    public function store (Request $request) {
        // Verifica se os dados estão preenchidos
        if ($request['codigo']=='' || $request['nome']=='' || $request['valorUnitario']=='' || $request['desc10']=='' || $request['desc20']=='' || $request['desc30']=='') {
            return redirect()->back()->withErrors('Verifique novamente os campos')->withInput(); 
        }

        // 5.1. Checa se já existe algum produto com este código
        $produtoExiste = Produto::where('codigo', '=', $request['codigo'])->first();

        // 5.2. Se o produto já existe, trata retornando mensagem de erro
        if ( $produtoExiste ) { 
            return redirect()->back()->withInput()->withErrors('Código de produto já existente'); 
        }

        // 5.3. Cria um objeto do model Produto
        $produto = new Produto;
        
        // 5.4. Alimenta o objeto com os dados do form
        $produto->codigo = $request['codigo'];
        $produto->nome = $request['nome'];
        $produto->valorUnitario = $request['valorUnitario'];
        $produto->desc10 = $request['desc10'];
        $produto->desc20 = $request['desc20'];
        $produto->desc30 = $request['desc30'];
        
        // 5.5. Salva o Produto
        $produto->save();
        
        // 5.6. Retorna para o Index
        return redirect()->route('produto.index');   
    }
    
    /* #####################################
    #######     6. Update
    ##################################### */
    public function update (Request $request, $id) {
        // Verifica se os dados estão preenchidos
        if ($request['codigo']=='' || $request['nome']=='' || $request['valorUnitario']=='' || $request['desc10']=='' || $request['desc20']=='' || $request['desc30']=='') {
            return redirect()->back()->withErrors('Verifique novamente os campos')->withInput(); 
        }
      
        // 5.1. Checa se já existe algum produto com este código
        $produtoExiste = Produto::where('codigo', '=', $request['codigo'])->where('id', '!=', $id)->first();

        // 5.2. Se o produto já existe, trata retornando mensagem de erro
        if ( $produtoExiste ) { 
            return redirect()->back()->withInput()->withErrors('Código de produto já existente'); 
        }

        // 5.3. Pega o produto
        $produto = Produto::find($id);
        
        // 5.4. Alimenta o objeto com os dados do form
        $produto->codigo = $request['codigo'];
        $produto->nome = $request['nome'];
        $produto->valorUnitario = $request['valorUnitario'];
        $produto->desc10 = $request['desc10'];
        $produto->desc20 = $request['desc20'];
        $produto->desc30 = $request['desc30'];
        
        // 5.5. Salva o Produto
        $produto->save();
        
        // 5.6. Retorna para o Index
        return redirect()->route('produto.index');   
    }

    /* #####################################
    #######     7. Delete
    ##################################### */
    public function delete (Request $request, $id) {
        // 7.1. Procura pelo Produto
        $produto = Produto::find($id);
        
        // 7.2. Se existir, remove, senão retorna mensagem de erro
        if( $produto ) {
            $produto->delete();
            return response(200);
        } else {
            return response()->json(['pemsg' => 'Produto não existente'], 404);
        }
    }
}