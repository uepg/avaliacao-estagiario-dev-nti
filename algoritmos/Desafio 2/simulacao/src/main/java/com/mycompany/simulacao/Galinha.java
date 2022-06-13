/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacao;

/**
 *
 * @author Mateus Felipe Ribeiro RA: 17243526
 */
public class Galinha extends Ave {
    
    //ave que não pode atacar e nem voar
    public Galinha(double peso,int patas) {
    	super(peso,patas);
    }

    public String nome()
    {
   	String aux = "galinha";
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
