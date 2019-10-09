<?php
include("animal.php");
include("mamifero.php");
include("ave.php");
include("cao.php");
include("gato.php");
include("elefante.php");
include("cavalo.php");
include("andorinha.php");
include("pato.php");
include("galinha.php");

class acoes{
	public function executar(){
		$animal_escolha = $_POST['animais'];

		$animal_Cao = new Cao(6, 4);
		$animal_Gato = new Gato(3, 4);
		$animal_Elefante = new Elefante(2700, 4);
		$animal_Cavalo = new Cavalo(380, 4);
		$animal_Andorinha = new Andorinha(0.05, 2);
		$animal_Pato = new Pato(1, 2);
		$animal_Galinha = new Galinha(0.8, 2);
		
		switch ($animal_escolha) {
			case 'Cao':
				$animal_escolha = $animal_Cao;
				echo "" . $animal_Cao->intro(); "" . $animal_Cao->atacar();
				echo "<br>";
				break;
			case 'Gato':
				$animal_escolha = $animal_Gato;
				break;
			case 'Elefante':
				$animal_escolha = $animal_Elefante;
				break;
			case 'Cavalo':
				$animal_escolha = $animal_Cavalo;
				break;
			case 'Andorinha':
				$animal_escolha = $animal_Andorinha;
				echo "" . $animal_Andorinha->intro(); "" . $animal_Andorinha->voar();
				echo "<br>";
				break;
			case 'Pato':
				$animal_escolha = $animal_Pato;
				echo "" . $animal_Pato->intro(); "" . $animal_Pato->voar();
				echo "<br>";
				break;
			case 'Galinha':
				$animal_escolha = $animal_Galinha;
				break;
		}

		echo "" . $animal_escolha->intro(); "" . $animal_escolha->andar();
		echo "<br>";
		echo "" . $animal_escolha->intro(); "" . $animal_escolha->comer();
		echo "<br>";
	}
}

$act = new acoes();
$act->executar();
?>