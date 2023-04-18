/*Andorinhas e patos implementam uma interface para o vôo.*/
class Andorinha extends Ave{
    constructor(peso, patas){
        super(peso, patas);
    }

    voar() {
        let mensagem = "Sou uma andorinha e estou voando";
        alert(mensagem);
        return mensagem;
    }    
}