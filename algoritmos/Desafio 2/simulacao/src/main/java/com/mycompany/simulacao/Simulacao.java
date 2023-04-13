/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.simulacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus Felipe Ribeiro RA: 17243526
 */
public class Simulacao {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        
        /*
        Criamos um arrayList para conter todos os animais
        Assim é possível testar todas as combinações de ações de forma organizada
        */
        
        List<Animal> listaAnimal = new ArrayList<Animal>();
        
    	Animal a = new Cao(6,4);
    	Animal b = new Gato(2,4);
    	Animal c = new Elefante(200,4);
    	Animal d = new Cavalo(100,4);
	Animal e = new Andorinha(0.4,4);
	Animal f = new Pato(1,4);
	Animal g = new Galinha(1,4);

        //Adicionamos os animais criados ao ArrayList
    	listaAnimal.add(a);
    	listaAnimal.add(b);
    	listaAnimal.add(c);
    	listaAnimal.add(d);
    	listaAnimal.add(e);
    	listaAnimal.add(f);
	listaAnimal.add(g);

        /*
        Realiza a amostragem das funções de cada animal, 
        para os casos de ser um cão
        Ou ave que saiba voar, 
        realiza a checagem do seu nome em seguida mostra sua função específica
        */
    	for (Animal i : listaAnimal) 
        {
            
            System.out.println("Sou um " + i.nome() + " e estou " + i.andar());
            
            System.out.println("Sou um " + i.nome() + " e estou " + i.comer());
            
            if(i.nome() == "cão")
            {
                
    		System.out.println("Sou um " + i.nome() + " e estou " + i.atacar());
                
            }
            else if(i.nome() == "andorinha" || i.nome() == "pato")
            {
                
    		System.out.println("Sou um " + i.nome() + " e estou " + i.voar());
            }

        }
    }
}
