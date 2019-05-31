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
public class Cao extends Mamifero{

    public Cao() {
    }
    
    public void atacar(){
        System.out.println("O "+getClass().getSimpleName()+" está atacando");
    }
}
