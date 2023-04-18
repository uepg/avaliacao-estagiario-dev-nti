@extends('layouts.template')

@section('content')
  <h1 class="mt-4">
    Novo Produto 
    <a href="{{route('produto.index')}}"> <button type="button" class="btn btn-default">Voltar</button></a>
  </h1>
  
  {!! Form::open(['route' => ['produto.update', $produto->id]]) !!}
    <div class="form-group">
      <label>Código</label>
      {!! Form::number('codigo', $produto['codigo'], ['class'=>'form-control', 'placeholder'=>"Código do Produto"]) !!}
    </div>

    <div class="form-group">
      <label>Nome</label>
      {!! Form::text('nome', $produto['nome'], ['class'=>'form-control', 'placeholder'=>"Nome do Produto"]) !!}
    </div>

    <div class="form-group">
      <label>Valor Unitário</label>
      {!! Form::number('valorUnitario', $produto['valorUnitario'], ['class'=>'form-control', 'placeholder'=>"Valor unitario do Produto"]) !!}
    </div>

    <div class="form-group">
      <label>Desconto por mais de 10 produtos na Venda</label>
      {!! Form::number('desc10', $produto['desc10'], ['class'=>'form-control', 'placeholder'=>'Desconto']) !!}
      <small class="form-text text-muted">Valor em porcentagem.</small>
    </div>

    <div class="form-group">
      <label>Desconto por mais de 20 produtos na Venda</label>
      {!! Form::number('desc20', $produto['desc20'], ['class'=>'form-control', 'placeholder'=>'Desconto']) !!}
      <small class="form-text text-muted">Valor em porcentagem.</small>
    </div>
    <div class="form-group">
      <label>Desconto por mais de 30 produtos na Venda</label>
      {!! Form::number('desc30', $produto['desc30'], ['class'=>'form-control', 'placeholder'=>'Desconto']) !!}
      <small class="form-text text-muted">Valor em porcentagem.</small>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
  {!! Form::close() !!}

@stop