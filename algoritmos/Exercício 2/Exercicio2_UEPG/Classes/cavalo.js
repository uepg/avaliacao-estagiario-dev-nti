class Cavalo extends Mamifero{
    constructor(peso, patas){
        super(peso, patas);
    }

    galopar() {
        let mensagem = "Sou um cavalo e estou Galopando"
        alert(mensagem);
        return mensagem;
    }
}