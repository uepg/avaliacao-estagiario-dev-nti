<?php
require_once("Ave.php");
require_once("Voar.php");
class Pato extends Ave implements Voar{
    public function voar(){
        return "Mas, invés disso, o pato abre suas asas e, em seguida, levanta voo.";
    }
}

?>