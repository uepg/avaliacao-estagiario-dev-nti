<?php

class Animal{

    public $peso;
    public $patas;

    public function __construct($peso, $patas){

        $this->peso = $peso;
        $this->patas=$patas;
        
    }

    public function comer(){
        return "estou comendo";
    }

    public function andar(){

        return "e logo vou andar!";

    }

}

?>