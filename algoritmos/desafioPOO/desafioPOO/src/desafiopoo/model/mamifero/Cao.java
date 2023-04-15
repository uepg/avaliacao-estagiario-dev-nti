package desafiopoo.model.mamifero;

public class Cao extends Mamifero {
    // construtor
    public Cao(float peso, int qntPatas) {
        super(peso, qntPatas);
    }
    
    // metodos
    public String atacar() {
        return "Mordida! Mordida!";
    }
}
