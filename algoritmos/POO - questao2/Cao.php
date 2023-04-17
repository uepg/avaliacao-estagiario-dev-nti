<?php

require_once 'Mamifero.php';
class Cao extends Mamifero{

    public function atacar(){
        echo nl2br("O Cachorro atacou\n");
    }
}