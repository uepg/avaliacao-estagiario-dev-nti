@extends('layouts.template')

@section('scripts')
  <script>
    $(document).on('click', '.btnDel', function() {
      var route = $(this).data('route');
      var ele = $(this).parent().parent();
      
      console.log(route);
      $.ajax({
        type: "DELETE",
        url: route,
        data: {
          _token: "{{ csrf_token() }}",
          _method: "delete"
        },
        dataType: 'json', /* Tipo de transmissão */
        success: function(data){
          alert('Registro deletado!');
          setTimeout(function(){
            ele.parent().fadeOut(1000, function() { $(this).remove(); });
          }, 1000);
        },
        error: function(error){
          alert('Não foi possível realizar a operação!');
        }
      });
    });
  </script>
@stop

@section('content')
  <h1 class="mt-4">
    Vendas 
    <a href="{{route('venda.create')}}"><button type="button" class="btn btn-success">Novo</button></a>
  </h1>
  
  <hr>

  <table class="table">
  <thead>
    <tr>
      <th scope="col">Número da Venda</th> 
      <th scope="col" width="50px">Opções</th>      
    </tr>
  </thead>
  <tbody>
    @foreach ($vendas as $venda)
    <tr>
      <td>{{$venda['numVenda']}}</td>
      <td>
        <div class="btn-group" role="group" aria-label="Basic example">
          <a href="{{route('venda.show', [$venda['id']])}}"><button type="button" class="btn btn-primary">Visualizar</button></a>
          <a class="btnDel" data-route="{{route('venda.delete', [$venda['id']])}}"><button type="button" class="btn btn-danger">Remover</button></a>
        </div>
      </td>
    </tr>
    @endforeach
  </tbody>
</table>
@stop