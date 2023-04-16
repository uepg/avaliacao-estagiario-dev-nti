/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Super;

/**
 *
 * @author luan0
 */
public class Ave extends Animal {
    
    public Ave(double peso, int qPatas){
        super(peso, qPatas);
    }
    
    
public String toString(){
      String temp;
      temp = "\nPeso: " + super.getPeso() + "\nPatas: " + super.getqPatas();
      return temp;
   }
}
