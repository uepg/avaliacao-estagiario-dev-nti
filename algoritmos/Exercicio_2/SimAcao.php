<?php

require_once("Andorinha.php");
require_once("Cao.php");
require_once("Cavalo.php");
require_once("Elefante.php");
require_once("Galinha.php");
require_once("Gato.php");
require_once("Pato.php");

class SimAcao{
    public function acoes(){
        $andorinha = new Andorinha(0.025, 2); // Peso de uma andorinha: 25g
        $cao = new Cao(15,4); // Peso de um Cão médio porte: 15kg
        $cavalo = new Cavalo(300, 4); //peso de um cavalo: 300kg
        $elefante = new Elefante(7000, 4); // Peso de um elefante adulto: 7 toneladas
        $galinha = new Galinha(2, 2); // peso de uma galinha: 2kg
        $gato = new Gato(5, 4); //peso de um gato: 5kg
        $pato = new Pato(2,2); // peso de um pato: 2kg
        $animal = $_POST['animal'];

        if($animal == "Andorinha"){
            echo "-Sou uma andorinha, ".$andorinha->comer()." ".$andorinha->andar()." ".$andorinha->voar();
        }
        elseif($animal == "Cão"){
            echo "-Sou um cão, ".$cao->comer()." ".$cao->andar()." ".$cao->atacar();
        }
        elseif($animal == "Cavalo"){
            echo "-Sou um cavalo, ".$cavalo->comer()." ".$cavalo->andar();
        }
        elseif($animal == "Elefante"){
            echo "-Sou um elefante, ".$elefante->comer()." ".$elefante->andar();
        }
        elseif($animal == "Galinha"){
            echo "-Sou uma galinha, ".$galinha->comer()." ".$galinha->andar();
        }
        elseif($animal == "Gato"){
            echo "-Sou um Gato, ".$gato->comer()." ".$gato->andar();
        }
        elseif($animal == "Pato"){
            echo "-Sou um Pato, ".$pato->comer()." ".$pato->andar()." ".$pato->voar();
        }
        
    }

    
}
$acao = new SimAcao();
echo $acao->acoes();

?>