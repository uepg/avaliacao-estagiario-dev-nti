@extends('layout.main')

@section('title', '{{$product->name}}')

@section('content')

<!--
<div id="search-container" class="col-md-12">
    <h1>Busque um evento</h1>
    <form action="">
        <input type="text" id="search" name="search" class="form-control" placeholder="Procurar...">
    </form>
</div>
--->

<div id="purchase-container" class="col-md-12">

    <img src="/img/{{$product -> image}}" alt="">
    <form action="/products" method="POST">
    @csrf
        <div class="purchase-box">
            <h3>Produto</h3>
            <input type="text" class="form-qtd" id="name" name="name" value ="{{$product->name}}" readonly>
            <h3>Cod. Produto</h3>
            <input type="text" class="form-qtd" id="cod" name="cod" value="{{$product->cod_produto}}" readonly>
            <h3>Quantidade</h3>
            <input type="text" class="form-qtd" id="qtd" name="qtd" placeholder="Quantidade">
            <h3>Valor Unitário</h3>
            <input type="text" class="form-qtd" id="valor" name="valor" value="{{$product->valor_unitario}}" readonly>
        </div>
        <input type="submit" class="btn btn-primary" value="Cadastrar venda">
    </form>
    <div class="regras-desconto">
        <h3>Regras de desconto</h3>
        <p><strong>Desconto de 5%</strong> para compras acima de 10 itens, <strong>Desconto de 10%</strong> para compras acima de 20 itens e <strong>Desconto de 20%</strong> 
        para compras acima de 30 itens.</p>
        <p><strong>O desconto é feito automaticamente ao cadastrar a venda</strong></p>
    </div>
    
</div>

@endsection