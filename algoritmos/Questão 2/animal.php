<?php

class Animal{
	public $peso;
	public $qtde_patas;
	public function __construct($peso, $qtde_patas){
		$this->peso = $peso;
		$this->qtde_patas = $qtde_patas;
	}
	public function andar(){
		echo " e estou andando.";
	}
	public function comer(){
		echo " e estou comendo.";
	}
}
?>