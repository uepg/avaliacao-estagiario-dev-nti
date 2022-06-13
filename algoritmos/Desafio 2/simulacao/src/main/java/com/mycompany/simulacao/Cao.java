/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacao;

/**
 *
 * @author Mateus Felipe Ribeiro RA: 17243526
 */
public class Cao extends Mamifero {
    
    //Mamífero que possuí nome, não voa, e pode usar o método atacar
    public Cao(double peso,int patas) {
    	super(peso,patas);
    }
    
    public String nome()
    {
   	String aux = "cão";
   	return aux;
    }
    
    public String atacar()
    {
    	String aux = "atacando";
    	return aux;
    }

    @Override
    public String voar()
    {
        String aux = "Não sei voar";
        return aux;
    }

}
