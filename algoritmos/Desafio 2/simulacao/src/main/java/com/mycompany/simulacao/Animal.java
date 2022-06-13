/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacao;

/**
 *
 * @author Mateus Felipe Ribeiro RA: 17243526
 */
public abstract class Animal {
    
    //Todos os animais possuem quantidade de patas e seu peso
    
    public double peso;
    public int patas;
    
    public Animal(double peso,int patas) {
    	this.peso=peso;
    	this.patas=patas;
    }
    
    /*
    Todos os animais irão herdar os métodos andar e comer
    */
    public String andar()
    {
    	String aux = "andando";
    	return aux;
    }
    
    public String comer()
    {
    	String aux = "comendo";
    	return aux;
    }
    
    //métodos abstratos para que todos os animais herdem, podendo usalos ou não
    public abstract String nome();
    public abstract String atacar();
    public abstract String voar();
}
