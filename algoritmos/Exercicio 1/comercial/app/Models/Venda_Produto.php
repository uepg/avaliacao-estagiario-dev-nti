<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Carbon\Carbon;\Carbon\Carbon::setLocale('pt_BR');

class Venda_Produto extends Model{
  protected $fillable = [];
  protected $table = 'Venda_produto';
  protected $primaryKey = 'id';
  public $timestamps = false;
}
