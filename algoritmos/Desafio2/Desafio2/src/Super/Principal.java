/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Super;

/**
 *
 * @author luan0
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //TESTE CAO
        Cao cao = new Cao(20, 4,"azul");
        System.out.println(cao);
        cao.Andar();
        cao.Atacar();
        cao.Comer();
        
        //TESTE CAVALO
        Cavalo cavalo = new Cavalo(200, 4,"amarelo");
        System.out.println(cavalo);
        cavalo.Andar();
        cavalo.Comer();
        
         //TESTE GATO
        Gato gato = new Gato(5, 4,"vermelho");
        System.out.println(gato);
        gato.Andar();
        gato.Comer();
        
         //TESTE ELEFANTE
        Elefante elefante = new Elefante(5000, 4,"azul com bolinhas brancas");
        System.out.println(elefante);
        elefante.Andar();
        elefante.Comer();
        
        //TESTE ANDORINHA
        Andorinha andorinha = new Andorinha(2, 2,"cinza");
        System.out.println(andorinha);
        andorinha.Andar();
        andorinha.Comer();
        andorinha.Voar();
        
        //TESTE PATO
        Pato pato = new Pato(4, 2,"preto");
        System.out.println(pato);
        pato.Andar();
        pato.Comer();
        pato.Voar();
        
        //TESTE GALINHA
        Galinha galinha = new Galinha(3, 2,"branca");
        System.out.println(galinha);
        galinha.Andar();
        galinha.Comer();
       
    }
    
}
