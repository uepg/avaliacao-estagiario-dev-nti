package algoritmos.Questao2;

public class Animal {
    protected int qtdPatas;
    protected Double peso;
    protected String nome;

    public Animal(int qtdPatas, Double peso, String nome) {
        this.qtdPatas = qtdPatas;
        this.peso = peso;
        this.nome = nome;
    }

    public void andar() {
        System.out.printf("Sou o animal: %s, e estou andando!\n", nome);
    }

    public void comer() {
        System.out.printf("Sou o animal: %s, e estou comendo!\n", nome);
    }
}

class Mamifero extends Animal {
    Mamifero(int qtdPatas, Double peso, String nome) {
        super(qtdPatas, peso, nome);
    }
}

class Ave extends Animal {
    Ave(int qtdPatas, Double peso, String nome) {
        super(qtdPatas, peso, nome);
    }

    public void voar() {
        System.out.printf("Sou o animal: %s, e estou voando!\n", nome);
    }
}

class Cao extends Mamifero {
    Cao() {
        super(4, 15.0, "Cao");
        atacar();
    }

    private void atacar() {
        System.out.println("Sou o animal: Cao, e estou atacando!");
    }
}

class Gato extends Mamifero {
    Gato() {
        super(4, 5.0, "Gato");
    }
}

class Elefante extends Mamifero {
    Elefante() {
        super(4, 4000.0, "Elefante");
    }

    @Override
    public void comer() {
        System.out.println("Sou o animal: Elefante, e estou comendo gramineas!");
    }
}

class Cavalo extends Mamifero {
    Cavalo() {
        super(4, 850.0, "Cavalo");
    }
}

class Andorinha extends Ave {
    Andorinha() {
        super(2, 0.025, "Andorinha");
        voar();
    }
}

class Pato extends Ave {
    Pato() {
        super(2, 1.16, "Pato");
        voar();
    }
}

class Galinha extends Ave {
    Galinha() {
        super(2, 2.75, "Galinha");
    }
}

class Main {
    public static void main(String[] args) {
        Animal cao = new Cao();
        cao.andar();
        cao.comer();
        System.out.println("======================================");

    }
}