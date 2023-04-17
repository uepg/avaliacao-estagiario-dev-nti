<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('products', function (Blueprint $table) {
            $table->id();
            $table->integer('cod_produto');//CÓDIGO DO PRODUTO - NORMALMENTE REGISTRADO AO CADASTRAR UM PRODUTO
            $table->string('name', 100);//VARCHAR MÁX 100 CARACTERES - NOME DO PRODUTO
            $table->float('valor_unitario',10,2);//VALOR DO PRODUTO
            $table->string('image');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('products');
    }
};
