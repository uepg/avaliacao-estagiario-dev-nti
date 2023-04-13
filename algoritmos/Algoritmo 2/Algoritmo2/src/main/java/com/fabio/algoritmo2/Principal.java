package com.fabio.algoritmo2;

/**
 *
 * @author fabio
 */

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Cao cao = new Cao(30.5, 4);
        Gato gato = new Gato(10.7, 4);
        Elefante elefante = new Elefante(70, 4);
        Cavalo cavalo = new Cavalo(45, 4);
        Galinha galinha = new Galinha(10, 2);
        
        AveVoo andorinha = new Andorinha(5, 2);
        AveVoo pato = new Pato(15.1, 2);
        
        Andorinha auxA = (Andorinha) andorinha;
        Pato auxP = (Pato) pato;
        
        Scanner le = new Scanner(System.in);
        
        int opc, aux;
        
        do{
            System.out.println("\n================ANIMAIS================\n");
            System.out.println("1- Cao\n");
            System.out.println("2- Gato\n");
            System.out.println("3- Elefante\n");
            System.out.println("4- Cavalo\n");
            System.out.println("5- Galinha\n");  
            System.out.println("6- Andorinha\n");
            System.out.println("7- Pato\n");
            System.out.println("8- Sair\n");

            System.out.println("\nQual animal deseja acessar? ");
            opc = le.nextInt();
            
            switch(opc){
                case 1:
                    System.out.println("\n================CAO================\n");
                    System.out.println("1- Andar\n");
                    System.out.println("2- Comer\n");
                    System.out.println("3- Atacar\n");
                    
                    System.out.println("\nQual acao deseja acessar? ");
                    aux = le.nextInt();
                    
                    if (aux == 1){
                        System.out.print("\nSou um "+cao.getClass().getSimpleName()+" e ");
                        cao.andar();
                        break;
                    }
                    if (aux == 2){
                        System.out.print("\nSou um "+cao.getClass().getSimpleName()+" e ");
                        cao.comer();
                        break;
                    }
                    if (aux == 1){
                        System.out.print("\nSou um "+cao.getClass().getSimpleName()+" e ");
                        cao.atacar();
                        break;
                    }
                    else{
                        System.out.println("\nOpc invalida.\n");
                        break;
                    }
                    
                case 2:
                    System.out.println("\n================GATO================\n");
                    System.out.println("1- Andar\n");
                    System.out.println("2- Comer\n");
                    
                    System.out.println("\nQual acao deseja acessar? ");
                    aux = le.nextInt();
                    
                    if (aux == 1){
                        System.out.print("\nSou um "+gato.getClass().getSimpleName()+" e ");
                        gato.andar();
                        break;
                    }
                    if (aux == 2){
                        System.out.print("\nSou um "+gato.getClass().getSimpleName()+" e ");
                        gato.comer();
                        break;
                    }
                    else{
                        System.out.println("\nOpc invalida.\n");
                        break;
                    }
                    
                case 3:
                    System.out.println("\n================ELEFANTE================\n");
                    System.out.println("1- Andar\n");
                    System.out.println("2- Comer\n");
                    
                    System.out.println("\nQual acao deseja acessar? ");
                    aux = le.nextInt();
                    
                    if (aux == 1){
                        System.out.print("\nSou um "+elefante.getClass().getSimpleName()+" e ");
                        elefante.andar();
                        break;
                    }
                    if (aux == 2){
                        System.out.print("\nSou um "+elefante.getClass().getSimpleName()+" e ");
                        elefante.comer();
                        break;
                    }
                    else{
                        System.out.println("\nOpc invalida.\n");
                        break;
                    }
                    
                case 4:
                    System.out.println("\n================CAVALO================\n");
                    System.out.println("1- Andar\n");
                    System.out.println("2- Comer\n");
                    
                    System.out.println("\nQual acao deseja acessar? ");
                    aux = le.nextInt();
                    
                    if (aux == 1){
                        System.out.print("\nSou um "+cavalo.getClass().getSimpleName()+" e ");
                        cavalo.andar();
                        break;
                    }
                    if (aux == 2){
                        System.out.print("\nSou um "+cavalo.getClass().getSimpleName()+" e ");
                        cavalo.comer();
                        break;
                    }
                    else{
                        System.out.println("\nOpc invalida.\n");
                        break;
                    }
                    
                case 5:
                    System.out.println("\n================GALINHA================\n");
                    System.out.println("1- Andar\n");
                    System.out.println("2- Comer\n");
                    
                    System.out.println("\nQual acao deseja acessar? ");
                    aux = le.nextInt();
                    
                    if (aux == 1){
                        System.out.print("\nSou uma "+galinha.getClass().getSimpleName()+" e ");
                        galinha.andar();
                        break;
                    }
                    if (aux == 2){
                        System.out.print("\nSou uma "+galinha.getClass().getSimpleName()+" e ");
                        galinha.comer();
                        break;
                    }
                    else{
                        System.out.print("\nOpc invalida.\n");
                        break;
                    }
                    
                case 6:
                    System.out.println("\n================ANDORINHA================\n");
                    System.out.println("1- Andar\n");
                    System.out.println("2- Comer\n");
                    System.out.println("3- Voar\n");
                    
                    System.out.println("\nQual acao deseja acessar? ");
                    aux = le.nextInt();
                    
                    if (aux == 1){
                        System.out.print("\nSou uma "+andorinha.getClass().getSimpleName()+" e ");
                        auxA.andar();
                        break;
                    }
                    if (aux == 2){
                        System.out.print("\nSou um "+andorinha.getClass().getSimpleName()+" e ");
                        auxA.comer();
                        break;
                    }
                    if (aux == 3){
                        System.out.print("\nSou um "+andorinha.getClass().getSimpleName()+" e ");
                        andorinha.voar();
                        break;
                    }
                    else{
                        System.out.println("\nOpc invalida.\n");
                        break;
                    }
                    
                case 7:
                    System.out.println("\n================PATO================\n");
                    System.out.println("1- Andar\n");
                    System.out.println("2- Comer\n");
                    System.out.println("3- Voar\n");
                    
                    System.out.println("\nQual acao deseja acessar? ");
                    aux = le.nextInt();
                    
                    if (aux == 1){
                        System.out.print("\nSou um "+pato.getClass().getSimpleName()+" e ");
                        auxP.andar();
                        break;
                    }
                    if (aux == 2){
                        System.out.print("\nSou um "+pato.getClass().getSimpleName()+" e ");
                        auxP.comer();
                        break;
                    }
                    if (aux == 3){
                        System.out.print("\nSou um "+pato.getClass().getSimpleName()+" e ");
                        pato.voar();
                        break;
                    }
                    else{
                        System.out.println("\nOpc invalida.\n");
                        break;
                    }
            }
        }while(opc != 8);
    }
}