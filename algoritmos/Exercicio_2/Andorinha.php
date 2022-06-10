<?php
require_once "Ave.php";
require_once "Voar.php";
class Andorinha extends Ave implements Voar{
    public function voar(){
        return "Mas, invés disso, a andorinha começa a levantar voo. Seria possível uma andorinha pegar um coco e transportá-lo para a Europa?";
    }
}

?>

