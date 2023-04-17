<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Models\Product;
use App\Models\Venda;

class EventController extends Controller
{
    public function index(){
        //comando do ORM "all" -> enviar todos os dados do banco para a view
        $products = Product::all();

        return view('welcome',['product'=>$products]);
    }

    public function products(){

        $products = Venda::all();

        return view('produtos', ['product'=>$products]);
    }

    public function info(){
        return view('info');
    }

    public function purchase($id){
        $products = Product::findOrFail($id);

        return view('products.purchase',['product'=>$products]);
    }

    public function store(Request $request){
        $venda = new Venda;


        //$data = date('Y/m/d H:i');
        $timezone = new \DateTimeZone('America/Sao_Paulo');
        $data = new \DateTime('now', $timezone);

        $desconto1 = 0.05;
        $desconto2 = 0.10;
        $desconto3 = 0.20;
        $resultado = 0;


        
        if($request->qtd <= 10){
            $resultado = ($request->valor * $request->qtd) - ((($request->valor)*($request->qtd))*0);
        }
        if($request->qtd > 10 && $request->qtd < 20){
            $resultado = ($request->valor * $request->qtd) - ((($request->valor)*($request->qtd))*($desconto1));
        }
        if($request->qtd > 20 && $request->qtd < 30){
            $resultado = ($request->valor * $request->qtd) - ((($request->valor)*($request->qtd))*($desconto2));
        }
        if($request->qtd > 30){
            $resultado = ($request->valor * $request->qtd) - ((($request->valor)*($request->qtd))*($desconto3));
        }
        

        



        $venda->item = $request->name;
        $venda->qtd = $request->qtd;
        $venda->valor_total = $resultado;
        $venda->data_registro = $data;

        $venda->save();

        return redirect("/")->with('msg', 'Venda cadastrada com sucesso!');
    }
}
