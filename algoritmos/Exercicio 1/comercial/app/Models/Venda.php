<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Carbon\Carbon;\Carbon\Carbon::setLocale('pt_BR');

class Venda extends Model{
  protected $fillable = [];
  protected $table = 'Venda';
  protected $primaryKey = 'id';
  public $timestamps = false;

  public function Produtos(){
    return $this->belongsToMany('App\Models\Produto', 'App\Models\Venda_Produto', 'Venda_id', 'Produto_id')->withPivot('quantidade', 'valorTotal');
  }
}
