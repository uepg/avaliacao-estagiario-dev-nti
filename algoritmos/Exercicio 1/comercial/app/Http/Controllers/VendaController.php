<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;


/* Imports das Models necessárias para este Controller */
use App\Models\Venda;
use App\Models\Produto;
use App\Models\Venda_Produto;

/* Dependências*/
class VendaController extends Controller {
 /* #####################################
    #######     1. Index (Listagem)
    ##################################### */
    public function index () {        
        // 1.1. Select do banco
        $vendas = Venda::all();

        // 1.2. Retorna a view
        return view('venda/index', compact('vendas'));
    }   

    /* #####################################
    #######     2. Create
    ##################################### */
    public function create () {
        //PLUCK faz ligação do nome com o id
        $produtos = Produto::All()->pluck('nome', 'id');
        // 2.1. Retorna a view para criação da venda
        return view('venda/create', compact('produtos'));      
    }

    /* #####################################
    #######     3. Show
    ##################################### */
    public function show ($id) {
        // 3.1. Encontra o registro da venda com os produto
        $venda = Venda::with('produtos')->find($id);
        
        // 3.2. Retorna a view com info da venda
        return view('venda/show', compact('venda'));        
    }

    /* #####################################
    #######     4. Store
    ##################################### */
    public function store (Request $request) {
        // Verifica se os dados estão preenchidos
        if ($request['numVenda']=='') {
            return redirect()->back()->withErrors('Verifique novamente os campos')->withInput(); 
        }

        // 4.1. Checa se já existe alguma Venda com este número
        $vendaExiste = Venda::where('numVenda', '=', $request['numVenda'])->first();

        // 4.2. Se já existe, trata retornando mensagem de erro
        if ( $vendaExiste) { 
            return redirect()->back()->withInput()->withErrors('Número de venda já existente'); 
        }

        // 4.3. Cria um objeto do model venda
        $venda = new Venda;
        
        // 4.4. Alimenta o objeto com os dados do form
        $venda->numVenda = $request['numVenda'];
        
        // 4.5. Salva 
        $venda->save();
        //4.6. Cadastra cada produto com o respectivo desconto aplicado
        if ($request['produto']){
            foreach ($request['produto'] as $key=>$produto_id) {                
                $quantidade = $request['quantidade'][$key];
                $produto = Produto::find($produto_id);

                $Venda_produto = new Venda_produto;
                $Venda_produto->Venda_id = $venda['id'];
                $Venda_produto->Produto_id = $produto_id;
                $Venda_produto->quantidade = $quantidade;
                if ($quantidade < 10) {
                    $Venda_produto->valorTotal = $request['quantidade'][$key]*$produto['valorUnitario'];
                } elseif ($quantidade < 20) {
                    $Venda_produto->valorTotal = $request['quantidade'][$key]*$produto['valorUnitario']*($produto['desc10']/100);
                } elseif ($quantidade < 30) {
                    $Venda_produto->valorTotal = $request['quantidade'][$key]*$produto['valorUnitario']*($produto['desc20']/100);
                } elseif ($quantidade < 40) {
                    $Venda_produto->valorTotal = $request['quantidade'][$key]*$produto['valorUnitario']*($produto['desc30']/100);
                }
                $Venda_produto->save();                
            }
        }
        
        
        // 4.7. Retorna para o Index
        return redirect()->route('venda.index');   
    }

    /* #####################################
    #######     5. Delete
    ##################################### */
    public function delete (Request $request, $id) {
        // 5.1. Procura pela venda
        $venda = Venda::with('produtos')->find($id);
        
        // 5.2. Se existir, remove, senão retorna mensagem de erro
        if( $venda ) {
            if ($venda->produtos->count() > 0) {
                $venda->produtos()->detach();
                $venda->produtos()->delete();
            }
            $venda->delete();
            return response(200);
        } else {
            return response()->json(['pemsg' => 'Produto não existente'], 404);
        }
    }
}