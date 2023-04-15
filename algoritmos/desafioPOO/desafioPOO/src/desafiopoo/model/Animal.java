package desafiopoo.model;

public abstract class Animal {
    // atributos
    private float peso;
    private int qntPatas;
    
    // construtor
    public Animal(float peso, int qntPatas) {
        this.peso = peso;
        this.qntPatas = qntPatas;
    }

    // getters e setters
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getQntPatas() {
        return qntPatas;
    }

    public void setQntPatas(int qntPatas) {
        this.qntPatas = qntPatas;
    }
    
    // demais metodos
    public String andar() {
        return "estou andando.";
    }
    public String comer() {
        return "estou comendo.";
    }
}

