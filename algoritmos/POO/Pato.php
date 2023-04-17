<?php

require_once 'Ave.php';
require_once 'Voo.php';

class Pato extends Ave implements Voo{

    function voar(){
        echo nl2br("O Pato está voando\n");
    }
}