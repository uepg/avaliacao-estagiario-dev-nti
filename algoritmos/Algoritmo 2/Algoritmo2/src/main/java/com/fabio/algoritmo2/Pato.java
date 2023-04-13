package com.fabio.algoritmo2;

/**
 *
 * @author fabio
 */

public class Pato extends Ave implements AveVoo {
    
    public Pato(double peso, int n_patas){
        super(peso, n_patas);
    }
    
    @Override
    public void voar(){
        System.out.println("estou voando.\n");
    }
}