<?php
    abstract class Animal{
        private $peso;
        private $n_patas;

        function __construct($peso,$n_patas){
            $this->peso = $peso;
            $this->n_patas = $n_patas;
        }
        function getPeso(){
            return  $this->peso;
        }
        function setPeso($peso){
            $this->peso = $peso;
        }
        function getN_patas(){
            return $this->n_patas;
        }
        function setN_patas($n_patas){
            $this->n_patas = $n_patas;
        }

        function andar(){
            echo "Estou andando\n";
        }
        function comer(){
            echo "Estou comendo\n";
        }   
    }

    interface Voo {
        public function voar();
    }

    abstract class Ave extends Animal{
        function __construct($peso,$n_patas){
            parent::__construct($peso,$n_patas);
        }
    }

    abstract class Mamifero extends Animal{
        function __construct($peso,$n_patas){
            parent::__construct($peso,$n_patas);
        }
    }

    class Cao extends Mamifero{
        function __construct($peso,$n_patas){
            parent::__construct($peso,$n_patas);
        }

        function seApresentar(){
            echo "Eu sou um cão, tenho " . parent::getN_patas() . " patas e peso " . parent::getPeso() ."Kg\n";
        }

        function atacar(){
            echo "Eu sou um cão e estou atacando\n";
        }
    }

    class Gato extends Mamifero{
        function __construct($peso,$n_patas){
            parent::__construct($peso,$n_patas);
        }
        function seApresentar(){
            echo "Eu sou um gato, tenho " . parent::getN_patas() . " patas e peso " . parent::getPeso() ."Kg\n";
        }
    }

    class Elefante extends Mamifero{
        function __construct($peso,$n_patas){
            parent::__construct($peso,$n_patas);
        }
        function seApresentar(){
            echo "Eu sou um elefante, tenho " . parent::getN_patas() . " patas e peso " . parent::getPeso() ."Kg\n";
        }
        function comer(){
            echo "Estou comendo como um elefante\n";
        } 

    }

    class Cavalo extends Mamifero{
        function __construct($peso,$n_patas){
            parent::__construct($peso,$n_patas);
        }
        function seApresentar(){
            echo "Eu sou um cavalo, tenho " . parent::getN_patas() . " patas e peso " . parent::getPeso() ."Kg\n";
        }
    }

    class Andorinha extends Ave implements Voo{
        function seApresentar(){
            echo "Eu sou uma andorinha, tenho " . parent::getN_patas() . " patas e peso " . parent::getPeso() ."Kg\n";
        }
        function voar()
        {
            echo "Estou voando\n";
        }
    }

    class Pato extends Ave implements Voo{
        function seApresentar(){
            echo "Eu sou um pato, tenho " . parent::getN_patas() . " patas e peso " . parent::getPeso() ."Kg\n";
        }
        function voar()
        {
            echo "Estou voando\n";
        }
    }

    class Galinha extends Ave {
        function seApresentar(){
            echo "Eu sou uma galinha, tenho " . parent::getN_patas() . " patas e peso " . parent::getPeso() ."Kg\n";
        }
    }

    $cao = new Cao(15,4);
    $cao->seApresentar();
    $cao->comer();
    $cao->andar();
    $cao->atacar();
    echo "\n";
    $gato = new Gato(8,4);
    $gato->seApresentar();
    $gato->comer();
    $gato->andar();
    echo "\n";
    $elefante = new Elefante(4000,4);
    $elefante->seApresentar();
    $elefante->comer();
    $elefante->andar();
    echo "\n";
    $calavo = new Cavalo (800,4);
    $calavo->seApresentar();
    $calavo->comer();
    $calavo->andar();
    echo "\n";
    $andorinha = new Andorinha (0.1,2);
    $andorinha->seApresentar();
    $andorinha->comer();
    $andorinha->andar();
    $andorinha->voar();
    echo "\n";
    $pato = new Pato(2,2);
    $pato->seApresentar();
    $pato->comer();
    $pato->andar();
    $pato->voar();
    echo "\n";
    $galinha = new Galinha(3,2);
    $galinha->seApresentar();
    $galinha->comer();
    $galinha->andar();
    





?>