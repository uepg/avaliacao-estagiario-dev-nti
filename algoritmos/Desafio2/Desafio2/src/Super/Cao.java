/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Super;

/**
 *
 * @author luan0
 */
public class Cao extends Mamifero {
    private String cor;
    
    public Cao(double peso, int qPatas, String cor){
        super(peso, qPatas);
        this.cor = cor;
    }
    
    public Cao(double peso, int qPatas){
        super(peso, qPatas);
    }
    
    public void Atacar(){
        String atacar = "E estou atacando";
        System.out.println(atacar);
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
      temp = "\nSou um cao "+getCor()+ "\nPeso: " + getPeso()+ " quilos" + "\nTenho: " + getqPatas() + " patas";
      return temp;
   }
    
}
