@extends('layouts.template')

@section('content')
  <h1 class="mt-4">
    Venda {{$venda['numVenda']}} 
    <a href="{{route('venda.index')}}"> <button type="button" class="btn btn-default">Voltar</button></a>
  </h1>
    
  <hr>

  <div class="form-group">
    <label>Nuúmero da Venda</label>
    <a>{{ $venda['numVenda'] }}</a>
  </div>

  <table class="table">
  <thead>
    <tr>
      <th scope="col">Produto</th> 
      <th scope="col">Quantidade</th> 
      <th scope="col">Valor total</th>   
    </tr>
  </thead>
  <tbody>
    @foreach ($venda['produtos'] as $produtoVendido)
    <tr>
      <td>{{$produtoVendido['nome']}}</td>
      <td>{{$produtoVendido->pivot['quantidade']}}</td>
      <td>{{$produtoVendido->pivot['valorTotal']}}</td>
    </tr>
    @endforeach
  </tbody>


@stop