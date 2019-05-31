/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade2.Animais;

/**
 *
 * @author pedro
 */
public class Animal {
    private float peso;
    private int quantidadeDePatas;

    public Animal() {
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getQuantidadeDePatas() {
        return quantidadeDePatas;
    }

    public void setQuantidadeDePatas(int quantidadeDePatas) {
        this.quantidadeDePatas = quantidadeDePatas;
    }
    
    public void andar(){
        System.out.println("O animal "+getClass().getSimpleName()+" está andando");
    }
    
    public void comer(){
        System.out.println("O animal "+getClass().getSimpleName()+" está comendo");      
    }
}
