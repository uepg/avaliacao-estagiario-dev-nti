<?php

namespace App\Models;

use CodeIgniter\Model;

class ItemModel extends Model
{
    protected $table            = 'itens';
    protected $useAutoIncrement = true;
    protected $returnType       = 'App\Entities\Item';
    protected $useSoftDeletes   = true;
    protected $allowedFields    = [
        'nome',
        'valor_unitario',
    ];

    // Dates
    protected $useTimestamps = true;
    protected $createdField  = 'criado_em';
    protected $updatedField  = 'atualizado_em';
    protected $deletedField  = 'deletado_em';

    // Validation
    protected $validationRules      = [
        'nome'         => 'required|max_length[120]',
        'valor_unitario'        => 'required',
    ];
    protected $validationMessages   = [
        'nome'        => [
            'required' => 'O campo nome é obrigatório',
            'max_length' => 'O campo nome é muito longo, máximo de 120 caracteres',
        ],
        'valor_unitario'        => [
            'required' => 'O campo Preço de venda é obrigatório',
        ],
    ];

    // Callbacks
    protected $beforeInsert = ['removeVirgulaValores'];
    protected $beforeUpdate = ['removeVirgulaValores'];

    protected function removeVirgulaValores(array $data)
    {
        if (isset($data['data']['valor_unitario'])) {

            $data['data']['valor_unitario'] = str_replace(',', '', $data['data']['valor_unitario']);
        }

        return $data;
    }

    public function pesquisaItens(string $term = null): array
    {

        if ($term === null) {

            return [];
        }

        $atributos = [
            'itens.*'
        ];

        $itens = $this->select($atributos)
            ->like('nome', $term)
            ->where('deletado_em', null)
            ->groupBy('nome') 
            ->findAll();

        if ($itens === null) {

            return [];
        }

        return $itens;
    }
}
