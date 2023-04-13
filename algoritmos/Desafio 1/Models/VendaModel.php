<?php

namespace App\Models;

use CodeIgniter\Model;

class VendaModel extends Model
{
    protected $table            = 'vendas';
    protected $returnType       = 'App\Entities\Venda';
    protected $useSoftDeletes   = true;
    protected $allowedFields    = [
        'nome',
        'itens',
        'situacao',
        'valor_produtos',
        'valor_desconto',
        'valor_venda',
    ];

    // Dates
    protected $useTimestamps = true;
    protected $createdField  = 'criado_em';
    protected $updatedField  = 'atualizado_em';
    protected $deletedField  = 'deletado_em';

    // Validation
    protected $validationRules      = [
        'nome'  => 'required',
    ];
    protected $validationMessages   = [
        'nome'        => [
            'required' => 'O campo Nome é obrigatório',
        ],
    ];

    public function recuperaVendas(){

        $atributos = [
            'id',
            'nome',
            'situacao',
            'valor_venda',
            'criado_em',
            'deletado_em'
        ];

        return $this->select($atributos)->orderBy('id', 'DESC')->withDeleted(true)->findAll();
    }
    
    public function buscaVendaOu404(string $codigo = null){

        if($codigo === null){

            throw \CodeIgniter\Exceptions\PageNotFoundException::forPageNotFound("Não encontramos a venda $codigo");
        }

        $atributos = [
            'vendas.*',
        ];

        $venda = $this->select($atributos)
                      ->where('id', $codigo)
                      ->withDeleted(true)
                      ->first();
        
        if($venda === null){

            throw \CodeIgniter\Exceptions\PageNotFoundException::forPageNotFound("Não encontramos a venda $codigo");
        }

        return $venda;

    }
}
