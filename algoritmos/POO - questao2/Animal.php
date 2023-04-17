<?php


class Animal{

    private $peso;
    private $qtd_patas;
    private $animal;


    function __construct($animal, $peso, $qtd_patas){
        $this->animal = $animal;
        $this->peso = $peso;
        $this->qtd_patas = $qtd_patas;
    }

    public function setPeso($peso){
        $this->peso = $peso;
    }
    public function setPatas($qtd_patas){
        $this->peso = $qtd_patas;
    }

    public function getPeso(){
        return $this->peso;
    }
    public function getPatas(){
        return $this->qtd_patas;
    }


    public function setAnimal($animal){
        $this->peso = $animal;
    }

    public function getAnimal(){
        return $this->animal;
    }
    
    public function andar(){
        echo nl2br("Sou um(a) " . $this->animal . " e estou andando \n");
    }
    public function comer(){
        echo nl2br("O(a) " . $this->animal . " está comendo\n");
    }




}