<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Carbon\Carbon;\Carbon\Carbon::setLocale('pt_BR');

class Produto extends Model{
  protected $fillable = [];
  protected $table = 'Produto';
  protected $primaryKey = 'id';
  public $timestamps = false;

  public function Vendas(){
    return $this->belongsToMany('App\Models\Venda', 'App\Models\Venda_Produto', 'Produto_id', 'Venda_id');
  }
}
