<?php

require_once 'Mamifero.php';

class Elefante extends Mamifero{


    public function comer(){
        echo nl2br("Sou um Elefante e estou comendo diferente\n");
    }
}