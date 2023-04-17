package desafiopoo;

import desafiopoo.model.ave.Andorinha;
import desafiopoo.model.ave.Galinha;
import desafiopoo.model.ave.Pato;
import desafiopoo.model.mamifero.Cao;
import desafiopoo.model.mamifero.Cavalo;
import desafiopoo.model.mamifero.Elefante;
import desafiopoo.model.mamifero.Gato;

public class DesafioPOO {
    public static void main(String[] args) {
        Cao cao = new Cao((float) 7.5, 4);
        System.out.println("Cão: ");
        System.out.println("Sou um cão e tenho " + cao.getPeso() + " kg.");
        System.out.println("Sou um cão e tenho " + cao.getQntPatas() + " patas.");
        System.out.println("Sou um cão e " + cao.andar());
        System.out.println("Sou um cão e " + cao.comer());
        System.out.println(cao.atacar());
        
        Gato gato = new Gato((float) 3.5, 4);
        System.out.println("\nGato: ");
        System.out.println("Sou um gato e tenho " + gato.getPeso() + " kg.");
        System.out.println("Sou um gato e tenho " + gato.getQntPatas() + " patas.");
        System.out.println("Sou um gato e " + gato.andar());
        System.out.println("Sou um cão e " + gato.comer());
        
        Elefante elefante = new Elefante((float) 5961, 4);
        System.out.println("\nElefante: ");
        System.out.println("Sou um elefante e tenho " + elefante.getPeso() + " kg.");
        System.out.println("Sou um elefante e tenho " + elefante.getQntPatas() + " patas.");
        System.out.println("Sou um elefante e " + elefante.andar());
        System.out.println("Sou um elefante e " + elefante.comer());
        
        Cavalo cavalo = new Cavalo((float) 852.5, 4);
        System.out.println("\nCavalo: ");
        System.out.println("Sou um cavalo e tenho " + cavalo.getPeso() + " kg.");
        System.out.println("Sou um cavalo e tenho " + cavalo.getQntPatas() + " patas.");
        System.out.println("Sou um cavalo e " + cavalo.andar());
        System.out.println("Sou um cavalo e " + cavalo.comer());
        
        Andorinha andorinha = new Andorinha((float) 0.025, 2);
        System.out.println("\nAndorinha: ");
        System.out.println("Sou uma andorinha e tenho " + andorinha.getPeso() + " kg.");
        System.out.println("Sou uma andorinha e tenho " + andorinha.getQntPatas() + " patas");
        System.out.println("Sou uma andorinha e " + andorinha.andar());
        System.out.println("Sou uma andorinha e " + andorinha.comer());
        System.out.println(andorinha.voar());
        System.out.println(andorinha.voar());
        System.out.println(andorinha.pousar());
        System.out.println(andorinha.pousar());
        
        Pato pato = new Pato((float) 1, 2);
        System.out.println("\nPato: ");
        System.out.println("Sou um pato e tenho " + andorinha.getPeso() + " kg.");
        System.out.println("Sou um pato e tenho " + andorinha.getQntPatas() + " patas.");
        System.out.println("Sou um pato e " + andorinha.andar());
        System.out.println("Sou um pato e " + andorinha.comer());
        System.out.println(pato.voar());
        System.out.println(pato.voar());
        System.out.println(pato.pousar());
        System.out.println(pato.pousar());
        
        Galinha galinha = new Galinha((float) 2.0, 2);
        System.out.println("\nGalinha: ");
        System.out.println("Sou uma galinha e tenho " + galinha.getPeso() + " kg.");
        System.out.println("Sou uma galinha e tenho " + galinha.getQntPatas() + " patas.");
        System.out.println("Sou uma galinha e " + galinha.andar());
        System.out.println("Sou uma galinha e " + galinha.comer());
        
    }    
}
