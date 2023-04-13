package com.fabio.algoritmo2;

/**
 *
 * @author fabio
 */

public class Cao extends Mamifero {
    
    public Cao(double peso, int n_patas){
        super(peso, n_patas);
    }
    
    public void atacar(){
        System.out.println("estou atacando.\n");
    }
}