<?php

namespace App\Models;

use CodeIgniter\Model;

class VendaItemModel extends Model
{
    protected $table            = 'vendas_itens';

    protected $returnType       = 'object';

    protected $allowedFields    = [
        'venda_id',
        'item_id',
        'item_quantidade',
    ];

    public function recuperaItensDaVenda(int $venda_id){

        $atributos = [
            'itens.id',
            'itens.nome',
            'itens.valor_unitario',
            'vendas_itens.id AS id_principal',
            'vendas_itens.item_quantidade',
        ];

        return $this->select($atributos)
                    ->join('itens', 'itens.id = vendas_itens.item_id')
                    ->where('vendas_itens.venda_id', $venda_id)
                    ->groupBy('itens.nome')
                    ->findAll();
    }

    public function atualizaQuantidadeItem(object $vendaItem){

        return $this->set('item_quantidade', $vendaItem->item_quantidade)
        ->where('id', $vendaItem->id)
        ->update();
    }
}
