<?php
require_once 'Venda.php';
require_once 'conexao.php';
date_default_timezone_set('America/Sao_Paulo');//Força a usar o horario de são paulo (Brasilia)
$codProduto = $_POST['produtos'];
$quantidade = $_POST['quantidade'];

$sql_produto = "SELECT * FROM produto WHERE codigo LIKE '$codProduto'";
$query_produto = mysqli_query($conexao, $sql_produto);
$produto = mysqli_fetch_array($query_produto);

$nome=$produto['nome'];
$agora = date('d/m/Y H:i', time());
$valor=$produto['valor'];
$total = $produto['valor']*$quantidade;
//Aplica os descontos no valor total
if($quantidade == 10){
    $totalDesc = $total*0.95;
}
if($quantidade == 20){
    $totalDesc = $total*0.9;
}
if($quantidade == 30){
    $totalDesc = $total*0.8;
}
$venda = new Venda(null, $agora,$nome,$quantidade,$totalDesc);
$venda->registrar($conexao);

echo "Venda registrada!<br/><br/>";
echo "----informações da venda----<br/>";
echo "Produto: ".$produto['nome']."<br/>";
echo "valor unitário: R$".$produto['valor']."<br/>";
echo "Quantidade: ".$quantidade."<br/>";
echo "Total: R$".$total."<br/>";
echo "Total com desconto: R$".$totalDesc."<br/>";

?>