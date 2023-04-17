@extends('layout.main')

@section('title', 'Site Comercial')

@section('content')


<div id="search-container" class="col-md-12">
    <h1>Pesquise um produto</h1>
    <form action="">
        <input type="text" id="search" name="search" class="form-control" placeholder="Procurar...">
    </form>
</div>


<div id="initial-container" class="col-md-12">
    <h2>Produtos</h2>
    <div id="cards-container" class="row">
        @foreach($product as $event)
        <div class="card col-md-3">
            <img src="/img/{{$event -> image}}" alt="">
            <div class="card-body">
                <h5 class="card-title">{{$event -> name}}</h5>
                <p class="card-participants">Cod: {{$event->cod_produto}}</p>
                <p class="card-participants">Valor: R$ {{$event -> valor_unitario}}</p>
                <a href="/products/{{$event->id}}" class="btn btn-primary">Ver</a>
            </div>
        </div>
        @endforeach
    </div>
    
</div>

@endsection
