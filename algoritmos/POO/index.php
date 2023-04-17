<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>POO</title>
</head>

<body>
    <?php
        require_once 'Cao.php';
        require_once 'Cavalo.php';
        require_once 'Gato.php';
        require_once 'Pato.php';
        require_once 'Andorinha.php';
        require_once 'Galinha.php';
        require_once 'Elefante.php';
        
        $cachorro = new Cao('Cachorro', 45, 4);
        $gato = new Gato('Gato', 4, 4);
        $cavalo = new Cavalo('Cavalo', 250, 4);
        $pato = new Pato('Pato', 3, 2);
        $andorinha = new Andorinha('Andorinha', 0.270,2);
        $galinha = new Galinha('Galinha', 2, 2);
        $elefante = new Elefante('Elefante', 4200, 4);

        $cachorro->andar();
        $cachorro->comer();
        $cachorro->atacar();
        $elefante->comer();
        $elefante->andar();
        $pato->comer();
        $pato->voar();
        $andorinha->comer();
        $andorinha->voar();
        $galinha->andar();
        $galinha->comer();

    ?>
</body>

</html>