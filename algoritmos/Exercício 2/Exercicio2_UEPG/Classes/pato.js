/*Andorinhas e patos implementam uma interface para o vôo.*/
class Pato extends Ave{
    constructor(peso, patas){
        super(peso, patas);
    }

    nadar() {
        let mensagem = "Sou um pato e estou nadando";
        alert(mensagem);
        return mensagem;
    }
}