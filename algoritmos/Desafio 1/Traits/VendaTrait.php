<?php

namespace App\Traits;

trait VendaTrait{

    public function preparaItensDavenda(object $venda): object {

        $vendaItemModel = new \App\Models\VendaItemModel();

        $vendaItens = $vendaItemModel->recuperaItensDaVenda($venda->id);

        $venda->itens = (!empty($vendaItens) ? $vendaItens : null);

        return $venda;

        //aqui a venda não está em aberto, encerrada com pagamento
        if($venda->itens !== null){

            $venda->itens = unserialize($venda->itens);
        }

        //retorna venda
        return $venda;
    }

    public function preparaVendaParaEncerrar(object $venda): object {

        $venda->situacao = 'encerrada';

        if($venda->itens === null){

            //venda vazia

            $venda->valor_produtos = null;
            $venda->valor_desconto = null;
            $venda->valor_venda = null;

            return $venda;
        }

        $valorProdutos = null;
        $auxquantidade = 0;
        $auxvalor = 0;

        $produtos = [];

        foreach($venda->itens as $item){

            $valorProdutos += $item->valor_unitario * $item->item_quantidade;

            $auxquantidade++;

            array_push($produtos, [
                'id' => $item->id,
                'quantidade' => (int) $item->item_quantidade,
            ]);
        }

        if($auxquantidade >= 10 && $auxquantidade < 20){
            $auxvalor = $valorProdutos * 0.05;

        }else if($auxquantidade >=20 && $auxquantidade < 30){
            $auxvalor = $valorProdutos * 0.1;
            
        }else if($auxquantidade >= 30){
            $auxvalor = $valorProdutos * 0.2;
        }

        $venda->valor_desconto = $auxvalor;

        if(!empty($produtos)){

            $venda->produtos = $produtos;
        }

        $venda->valor_produtos = str_replace(',', '', number_format($valorProdutos, 2));

        $valorFinalvenda = number_format(($valorProdutos) - $venda->valor_desconto, 2);

        //valor final da venda, formatado e unido com desconto
        $venda->valor_venda = str_replace(',', '', $valorFinalvenda);

        //serializamos os itens
        $venda->itens = serialize($venda->itens);

        return $venda;
    }
}