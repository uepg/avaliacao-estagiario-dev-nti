<?php
include 'conexao.php';
$sql_produtos= "SELECT * FROM produto";
$resultado_produtos = mysqli_query($conexao, $sql_produtos);
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>Exercício 1 - Loja</title>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.0/jquery.js"></script>
<script>
$(function(){
$(document).on("click", "#botao", function(e) {
e.preventDefault();
{       
var infom = $("#form").serialize();
        $("#resultado").addClass('loader');                
        $.ajax({            
            beforeSend: function() { },         
            type: "POST",
            url: "processa.php",
            data:infom,          
            success: function(result){      
            $("#resultado").removeClass('loader');
            $('#resultado').html(result);
            }
        });     
        e.preventDefault(); 
}
}); 
});
</script>
    <style>
    .loader{
        height:100px;
        background-size: 30px;
    }
    </style>
  <body>
      <div class="container">
        <br>
                 
          <p class="h1 text-center">Escolha o produto e a quantidade.</p>
          <br>
            <form id="form">
            <p class="h5 text-center">Produto:</p>
            <select name="produtos"class="form-select text-center">
       <?php
       
       $resultado_produtos = mysqli_query($conexao, $sql_produtos);
         while ($produtos = mysqli_fetch_assoc($resultado_produtos)) { ?>
            <option value="<?php echo $produtos['codigo']; ?>"><?php echo $produtos['nome']; ?>
            </option><?php } ?>
            </select>
            <br/>
            <p class="h5 text-center">Quantidade:</p>
            <select name="quantidade"class="form-select text-center">
              <option value="10">10 Unidades</option>
              <option value="20">20 Unidades</option>
              <option value="30">30 Unidades</option>
            </select>
            <br/>
            <div class="text-center">
            <button id = "botao" class="btn btn-success">Registrar venda</button>
            </div>
            </form>
            <br>
            <p class="h4 text-center">Log de venda:</p>
            <div class="text-center alert alert-secondary" role="alert" id="resultado"></div>
      </div>
  </body>
  
</html>