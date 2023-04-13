<?php

namespace App\Database\Migrations;

use CodeIgniter\Database\Migration;

class GeraTabelaItens extends Migration
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
            'nome'       => [
                'type'       => 'VARCHAR',
                'constraint' => '240',
                'unique'     => true,
            ],
            'valor_unitario'       => [
                'type'       => 'DECIMAL',
                'constraint' => '10,2',
                'null'     => false,
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

        $this->forge->createTable('itens');
    }

    public function down()
    {
        $this->forge->dropTable('itens');
    }
}
