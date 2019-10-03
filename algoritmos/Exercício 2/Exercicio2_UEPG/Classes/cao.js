/*Os cães possuem a ação de atacar.*/
class Cao extends Mamifero{
    constructor(peso, patas){
        super(peso, patas);
    }

    atacar(){
        let mensagem = "Sou um cão e estou atacando";
        alert(mensagem);
        return mensagem;
    }
}