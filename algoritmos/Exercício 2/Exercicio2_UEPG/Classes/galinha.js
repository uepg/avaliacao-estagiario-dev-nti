class Galinha extends Ave{
    constructor(peso, patas){
        super(peso, patas);
    }

    cacarejar() {
        let mensagem = "Sou uma galinha e estou cacarejando";
        alert(mensagem);
        return mensagem
    }
}