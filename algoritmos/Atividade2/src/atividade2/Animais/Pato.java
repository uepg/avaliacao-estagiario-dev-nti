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
public class Pato extends Ave implements Voo{

    public Pato() {
    }
    
    @Override
    public void voar() {
        System.out.println("A ave "+getClass().getSimpleName()+(" está voando"));
    }
    
}
