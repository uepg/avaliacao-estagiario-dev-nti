<?php

require_once 'Ave.php';
require_once 'Voo.php';

class Andorinha extends Ave implements Voo{

    function voar(){
        echo nl2br("A andorinha está voando\n");
    }
}