/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacao;

/**
 *
 * @author Mateus Felipe Ribeiro RA: 17243526
 */
public class Gato extends Mamifero{
    
    //mamifero que não pode atacar e nem voar
    public Gato(double peso,int patas) {
    	super(peso,patas);
    }
    
    public String nome()
    {
   	String aux = "gato";
   	return aux;
    }

    @Override
    public String atacar() 
    {
        String aux = "Não sei atacar";
        return aux;
    }

    @Override
    public String voar() 
    {
        String aux = "Não sei voar";
        return aux;
    }
}
