class Gato extends Mamifero{
    constructor(peso, patas){
        super(peso, patas);
    }

    miar() {
        let mensagem = "Sou um gato e estou miando";
        alert(mensagem);
        return mensagem;
    }
}