/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade2;

import atividade2.Animais.Andorinha;
import atividade2.Animais.Elefante;
import atividade2.Animais.Cao;
import atividade2.Animais.Cavalo;
import atividade2.Animais.Galinha;
import atividade2.Animais.Gato;
import atividade2.Animais.Pato;

/**
 *
 * @author pedro
 */
public class Atividade2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cao cao = new Cao();
        cao.andar();
        cao.atacar();
        cao.comer();
        System.out.println("");
        
        Gato gato = new Gato();
        gato.andar();
        gato.comer();
        System.out.println("");
        
        Elefante elefante = new Elefante();
        elefante.andar();
        elefante.comer();
        System.out.println("");
        
        Cavalo cavalo = new Cavalo();
        cavalo.andar();
        cavalo.comer();
        System.out.println("");
        
        Andorinha andorinha = new Andorinha();
        andorinha.andar();
        andorinha.comer();
        andorinha.voar();
        System.out.println("");
        
        Pato pato = new Pato();
        pato.andar();
        pato.comer();
        pato.voar();
        System.out.println("");
        
        Galinha galinha = new Galinha();
        galinha.andar();
        galinha.comer();
        System.out.println("");
    }
    
}
