/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Super;

/**
 *
 * @author luan0
 */
public class Elefante extends Mamifero {
   private String cor;
    
    public Elefante(double peso, int qPatas, String cor){
        super(peso, qPatas);
        this.cor = cor;
    }
    
    public Elefante(double peso, int qPatas){
        super(peso, qPatas);
    }  
    
    public void Comer(){
        String comer = "E estou comendo plantando bananeira";
        System.out.println(comer);
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String toString(){
      String temp;
      temp = "\nSou um elefante "+getCor()+ "\nPeso: " + getPeso()+ " quilos" + "\nTenho: " + getqPatas() + " patas";
      return temp;
   } 
}
