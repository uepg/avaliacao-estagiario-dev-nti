/*Elefante possui uma maneira de comer diferente dos demais.*/
class Elefante extends Mamifero{
    constructor(peso, patas) {
        super(peso, patas);
    }

    comer(){
        let mensagem = "Sou um elefante estou jogando comida dentro da boca";
        alert(mensagem);
        return mensagem
    }
}