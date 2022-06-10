<?php
//require_once 'conexao.php';

class Venda{
    public $numero;
    public $data;
    public $produto;
    public $quantidade;
    public $valorTotal;
    public $conexao;

    public function __construct($numero, $data, $produto, $quantidade, $valorTotal){
        $this->numero = $numero;
        $this->data = $data;
        $this->produto = $produto;
        $this->quantidade = $quantidade;
        $this->valorTotal=$valorTotal;
    }

    public function  getData(){
        return $this->data;
    }

    public function  getNumero(){
        return $this->numero;
    }

    public function  getProduto(){
        return $this->produto;
    }

    public function  getQuantidade(){
        return $this->quantidade;
    }
    
    public function  getValorTotal(){
        return $this->valorTotal;
    }    
    
    public function registrar($banco){

        $data = $this->getData();
        $produto = $this->getProduto();
        $quantidade=$this->getQuantidade();
        $valorVenda = $this->getValorTotal();
        $sql_venda = "INSERT INTO venda (numero, dataVenda, nome_produto, quantidade, total) VALUES (null, '$data', '$produto', '$quantidade', '$valorVenda')";
        $query_venda = mysqli_query($banco, $sql_venda);
        
    }
}


?>