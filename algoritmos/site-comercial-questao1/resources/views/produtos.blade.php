@extends('layout.main')

@section('title', 'Site Comercial')

@section('content')



<div id="initial-container" class="col-md-12">
    <h2>Vendas realizadas</h2>
    @foreach($product as $event)
    <div class="vendas-container">
        <p><strong>Num. Venda: </strong>{{$event->id}}</p>
        <p><strong>Data/Horário: </strong>{{$event->data_registro}}</p>
        <p><strong>Produto: </strong>{{$event->item}}</p>
        <p><strong>Quantidade: </strong>{{$event->qtd}}</p>
        <p><strong>Valor total: </strong>{{$event->valor_total}}</p>
    </div>
    @endforeach
    
</div>

@endsection
