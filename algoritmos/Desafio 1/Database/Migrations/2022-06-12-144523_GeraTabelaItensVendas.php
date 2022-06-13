<?php

namespace App\Database\Migrations;

use CodeIgniter\Database\Migration;

class GeraTabelaItensVendas extends Migration
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
            'venda_id'       => [
                'type'           => 'INT',
                'constraint'     => 5,
                'unsigned'       => true,
                'null'       => true,
            ],
            'item_id'       => [ 
                'type'           => 'INT',
                'constraint'     => 5,
                'unsigned'       => true,
            ],
            'item_quantidade'       => [
                'type'           => 'INT',
                'constraint'     => 5,
            ],
            
        ]);
        $this->forge->addKey('id', true);

        $this->forge->addForeignKey('venda_id', 'vendas', 'id', 'CASCADE', 'CASCADE');
        $this->forge->addForeignKey('item_id', 'itens', 'id', 'CASCADE', 'CASCADE');

        $this->forge->createTable('vendas_itens');
    }

    public function down()
    {
        $this->forge->dropTable('vendas_itens');
    }
}
