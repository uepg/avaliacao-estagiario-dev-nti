@extends('layouts.template')

@section('content')
  <h1 class="mt-4">
    Produto {{$produto['nome']}} 
    <a href="{{route('produto.index')}}"> <button type="button" class="btn btn-default">Voltar</button></a>
  </h1>
    
  <hr>

  <div class="form-group">
    <label>Código</label>
    <a>{{ $produto['codigo'] }}</a>
  </div>

  <div class="form-group">
    <label>Nome</label>
    <a>{{ $produto['nome'] }}</a>
  </div>

  <div class="form-group">
    <label>Valor Unitário</label>
    <a>{{ $produto['valorUnitario'] }}</a>
  </div>

  <div class="form-group">
    <label>Desconto por mais de 10 produtos na Venda</label>
    <a>{{ $produto['desc10'] }}</a>
  </div>

  <div class="form-group">
    <label>Desconto por mais de 20 produtos na Venda</label>
    <a>{{ $produto['desc20'] }}</a>
  </div>

  <div class="form-group">
    <label>Desconto por mais de 30 produtos na Venda</label>
    <a>{{ $produto['desc30'] }}</a>
  </div>


@stop