<?php
require('Voo.php');
     class Animal{
       
        private $peso;
        private $patas;

        function __construct($peso, $patas){
            $this->$peso = $peso;
            $this->$patas = $patas;
        }

        

        public function getPeso(){
            return $this->peso;
        }

        public function setPeso($peso){
            return $this->peso = $peso;
        }

        public function getPatas(){
            return $this->patas;
        }

        public function setPatas($patas){
            return $this->patas = $patas;
        }

        
    }

    abstract class Ave extends Animal{
        private $nome;

        function __construct($nome, $peso, $patas){
            $this->nome = $nome;
            parent::__construct($peso, $patas);
        }

        public function getNome(){
            return $this->nome;
        }

        public function setNome($nome){
            $this->nome = $nome;
        }

        abstract function Comer();
        abstract function Andar();
    }

    abstract class Mamifero extends Animal{
        private $nome;

        function __construct($nome, $peso, $patas){
            $this->nome = $nome;
            parent::__construct($peso, $patas);
        }

        public function getNome(){
            return $this->nome;
        }

        public function setNome($nome){
            $this->nome = $nome;
        }

        abstract function Comer();
        abstract function Andar();
    }

    class Andorinha extends Ave implements Voo{
        private $cor;
        function __construct($nome,$peso, $patas,$cor){
            parent::__construct($nome,$peso,$patas);
            $this->cor = $cor;
        }
        function Comer(){
            echo "Andorinha ".parent::getNome()." está comendo";
        }

        function Andar(){
            echo "A andorinha ".parent::getNome()."está andando";
        }
        function LevantarVoo(){
            echo "A andorinha ".parent::getNome()." está voando";
        }

        function getCor(){
            return $this->cor;
        }
        function setCor($cor){
            return $this->cor = $cor;
        }
    }

    class Pato extends Ave implements Voo{
        private $cor;
        function __construct($nome,$peso, $patas,$cor){
            parent::__construct($nome,$peso,$patas);
            $this->cor = $cor;
        }
        function Comer(){
            echo "Andorinha ".parent::getNome()." está comendo";
        }

        function Andar(){
            echo "A andorinha ".parent::getNome()."está andando";
        }
        function LevantarVoo(){
            echo "A andorinha ".parent::getNome()." está voando";
        }

        function getCor(){
            return $this->cor;
        }
        function setCor($cor){
            return $this->cor = $cor;
        }
    }

    class Galinha extends Ave{
        private $cor;
        function __construct($nome,$peso, $patas,$cor){
            parent::__construct($nome,$peso,$patas);
            $this->cor = $cor;
        }
        function Comer(){
            echo "Galinha ".parent::getNome()." está comendo";
        }

        function Andar(){
            echo "A Galinha ".parent::getNome()." está andando";
        }

        function getCor(){
            return $this->cor;
        }
        function setCor($cor){
            return $this->cor = $cor;
        }
    }

    class Cao extends Mamifero{
        private $cor;
        function __construct($nome,$peso, $patas,$cor){
            parent::__construct($nome,$peso,$patas);
            $this->cor = $cor;
        }
        function Comer(){
            echo "O Cão ".parent::getNome()." está comendo";
        }

        function Andar(){
            echo "O Cão ".parent::getNome()." está andando";
        }
        function Atacar(){
            echo "O Cão ".parent::getNome()." está atacando";
        }

        function getCor(){
            return $this->cor;
        }
        function setCor($cor){
            return $this->cor = $cor;
        }
    }

    class Cavalo extends Mamifero{
        private $cor;
        function __construct($nome,$peso, $patas){
            parent::__construct($nome,$peso,$patas);
        }
        function Comer(){
            echo "O Cavalo ".parent::getNome()." está comendo";
        }

        function Andar(){
            echo "O Cavalo ".parent::getNome()." está andando";
        }
        function getCor(){
            return $this->cor;
        }
        function setCor($cor){
            return $this->cor = $cor;
        }
    }

    class Elefante extends Mamifero{
        private $cor;
        function __construct($nome,$peso, $patas){
            parent::__construct($nome,$peso,$patas);
        }
        function Comer(){
            echo "O elefante ".parent::getNome()." está comendo com sua tromba";
        }

        function Andar(){
            echo "O gato ".parent::getNome()." está andando";
        }

        function getCor(){
            return $this->cor;
        }
        function setCor($cor){
            return $this->cor = $cor;
        }
    }

    class Gato extends Mamifero{
        private $cor;
        function __construct($nome,$peso, $patas,$cor){
            parent::__construct($nome,$peso,$patas);
            $this->cor = $cor;
        }
        function Comer(){
            echo "O gato".parent::getNome()." está comendo";
        }

        function Andar(){
            echo "O gato ".parent::getNome()." está andando";
        }

        function getCor(){
            return $this->cor;
        }
        function setCor($cor){
            return $this->cor = $cor;
        }
    }

    $cachorro = new Cao("João",20,4,"Branco");
    $galinha  = new Galinha ("Jurema",10,2,"Marrom");
    $Andorinha = new Andorinha("Julia",16,2,"Mar");
    $Pato = new Pato("Julia",16,2,"Mar");
    $Cavalo = new Cavalo ("Paulo",80,4,"Preto");
    $Elenfante = new Elefante ("João",220,4,"Preto");
    $Gato = new Gato ("Bruce",20,4,"Amarelo");

    
    $cachorro->Atacar();
    echo '<br/>';
     $Andorinha->LevantarVoo();
    echo '<br/>';
    $galinha->Comer();
    echo '<br/>';
    $galinha->Andar();
    echo '<br/>';
    $Cavalo->Comer();
    echo '<br/>';
     $Cavalo->Andar();
    echo '<br/>';
    $Pato->Comer();
    echo '<br/>';
     $Pato->Andar();
     '<br/>';
     $Pato->LevantarVoo();
    echo '<br/>';
     $Gato->Andar();
    echo '<br/>';
     $Gato->Comer();
?>