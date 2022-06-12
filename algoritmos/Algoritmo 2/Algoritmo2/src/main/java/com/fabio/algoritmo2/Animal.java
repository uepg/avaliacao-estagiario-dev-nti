package com.fabio.algoritmo2;

/**
 *
 * @author fabio
 */

public abstract class Animal {
    double peso;
    int n_patas;
    
    public Animal(double peso, int n_patas){
        this.peso = peso;
        this.n_patas = n_patas;
    }
    
    public void andar(){
        System.out.println("estou andando.\n");
    }
    
    public void comer(){
        System.out.println("estou comendo.\n");
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getN_patas() {
        return n_patas;
    }

    public void setN_patas(int n_patas) {
        this.n_patas = n_patas;
    }

    @Override
    public String toString() {
        return "Animal{" + "peso=" + peso + ", n_patas=" + n_patas + '}';
    }
}
