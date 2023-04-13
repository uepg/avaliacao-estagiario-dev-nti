package com.fabio.algoritmo2;

/**
 *
 * @author fabio
 */

public class Elefante extends Mamifero {
    
    public Elefante(double peso, int n_patas){
        super(peso, n_patas);
    }
    
    @Override
    public void comer(){
        System.out.println("estou comendo como um elefante.\n");
    }
}