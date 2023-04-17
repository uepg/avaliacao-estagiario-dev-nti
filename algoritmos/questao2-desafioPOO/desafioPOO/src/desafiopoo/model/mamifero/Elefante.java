package desafiopoo.model.mamifero;

public class Elefante extends Mamifero{
    // construtor
    public Elefante(float peso, int qntPatas) {
        super(peso, qntPatas);
    }
    
    // metodo override
    @Override
    public String comer() {
        return " estou comendo utilizando a minha tromba.";
    }
    
}
