<?php
require_once "Mamifero.php";
class Cao extends Mamifero{

    public function atacar(){
        $sorteio = rand(1,7);
        if($sorteio == 1){
            return "Invés disso, o cão  tenta atacar outro cão, mas recebe um contra ataque como resposta.";
        }
        elseif($sorteio == 2){
            return "Invés disso, o cão tenta atacar o elefante, mas é simplesmente ignorado.";
        }
        elseif($sorteio == 3){
            return "Invés disso, o cão tenta atacar a andorinha, mas ela sai voando.";
        }
        elseif($sorteio == 4){
            return "Invés disso, o cão tenta atacar o pato, mas teve problemas com a água.";
        }
        elseif($sorteio == 5){
            return "Invés disso, o cão tenta atacar a galinha. Ele obtém sucesso e consegue mais comida para seu almoço.";
        }
        elseif($sorteio == 6){
            return "Invés disso, o cão tenta atacar o cavalo e quase leva um coice.";
        }
        elseif($sorteio == 7){
            return "Invés disso, o cão tenta atacar o gato. Porém, o gato foi mais ágil.";
        }
        
    }

}

?>