@extends('layouts.template')

@section('scripts')
<script>
   $(document).on('click', '#adicionaProduto', function () {
    let htmlProduto = '{!! Form::select("produto[]", $produtos, null, ["class"=>"form-control", "placeholder"=>"Produto", "required"=>"required"]) !!}';
    let htmlQuantidade = '{!! Form::number("quantidade[]", null, ["class"=>"form-control", "placeholder"=>"Número de Produtos", "required"=>"required"]) !!}';
    $('#produtosVendidos').append(`
      <div class="row" style="margin: 10px 30px 0 10px;">
        <div class="col-md-6 col-xs-6">`+htmlProduto+`</div>
        <div class="col-md-6 col-xs-6">`+htmlQuantidade+`</div>
      </div>
    `);
   });
</script> 
@stop

@section('content')
  <h1 class="mt-4">
    Nova Venda 
    <a href="{{route('venda.index')}}"> <button type="button" class="btn btn-default">Voltar</button></a>
  </h1>
  
  {!! Form::open(['route' => 'venda.store']) !!}
    <div class="form-group">
      <label>Número da Venda</label>
      {!! Form::number('numVenda', null, ['class'=>'form-control', 'placeholder'=>"Código do Produto", "required"=>"required"]) !!}
    </div>

    <hr style="margin-top: 30px">
    <h3 >Produtos Vendidos</h2>
    <div id="produtosVendidos"></div>

    <button style="margin-top: 15px" type="button" class="btn btn-info" id="adicionaProduto">Adicionar produto vendidos</button>

    <hr>
    
    <button type="submit" class="btn btn-success">Salvar</button>
  {!! Form::close() !!}

@stop