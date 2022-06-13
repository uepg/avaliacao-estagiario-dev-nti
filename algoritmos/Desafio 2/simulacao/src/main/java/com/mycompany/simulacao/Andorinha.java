/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulacao;

/**
 *
 * @author Mateus Felipe Ribeiro RA: 17243526
 */
public class Andorinha extends Ave implements Voo{
    
    //Ave que pode implementar a caracteristica de voo
    public Andorinha(double peso,int patas) {
    	super(peso,patas);

    }
    
    public String voar()
    {
    	String aux = "voando";
    	return aux;
    }
    public String nome()
    {
   	String aux = "andorinha";
   	return aux;
    }

    @Override
    public String atacar()
    {
        String aux = "Não sei atacar";
        return aux;
    }
}
