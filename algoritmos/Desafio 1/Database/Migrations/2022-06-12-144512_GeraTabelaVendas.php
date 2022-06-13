<?php

namespace App\Database\Migrations;

use CodeIgniter\Database\Migration;

class GeraTabelaVendas extends Migration
{
    public function up()
    {
        $this->forge->addField([
            'id'          => [
                'type'           => 'INT',
                'constraint'     => 5,
                'unsigned'       => true,
                'auto_increment' => true,
            ],
            'nome' => [
                'type'          => 'VARCHAR',
                'constraint' => '240',
                'unique'     => true,
            ],
            'itens'       => [
                'type'       => 'TEXT', //serializa os itens da venda
                'null'       => true,
            ],
            'situacao'       => [
                'type'       => 'ENUM',
                'constraint' => ['aberta', 'encerrada'],
                'default'    => 'aberta',
            ],
            'valor_produtos'       => [
                'type'       => 'DECIMAL',
                'constraint' => '10,2',
                'null'       => true,
            ],
            'valor_desconto'       => [
                'type'       => 'DECIMAL',
                'constraint' => '10,2',
                'null'       => true,
            ],
            'valor_venda'       => [
                'type'       => 'DECIMAL',
                'constraint' => '10,2',
                'null'       => true,
            ],
            'criado_em'       => [
                'type'       => 'DATETIME',
                'null'       => true,
                'default'    => null,
            ],
            'atualizado_em'       => [
                'type'       => 'DATETIME',
                'null'       => true,
                'default'    => null,
            ],
            'deletado_em'       => [
                'type'       => 'DATETIME',
                'null'       => true,
                'default'    => null,
            ],
        ]);
        $this->forge->addKey('id', true);

        $this->forge->createTable('vendas');
    }

    public function down()
    {
        $this->forge->dropTable('vendas');
    }
}
