package com.fabio.algoritmo2;

/**
 *
 * @author fabio
 */

public class Andorinha extends Ave implements AveVoo{
    
    public Andorinha(double peso, int n_patas){
        super(peso, n_patas);
    }
    
    @Override
    public void voar(){
        System.out.println("estou voando.\n");
    }
}