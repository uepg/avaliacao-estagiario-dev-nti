/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Super;

/**
 *
 * @author luan0
 */
public class Animal {
    private double peso;
    private int qPatas;
    
    protected Animal(double peso, int qPatas){
        this.peso = peso;
        this.qPatas = qPatas;
    }
    
     public void Comer(){
        String comer = "E estou comendo";
        System.out.println(comer);
    }
    
    public void Andar(){
        String andar = "E estou andando";
        System.out.println(andar);
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the qPatas
     */
    public int getqPatas() {
        return qPatas;
    }

    /**
     * @param qPatas the qPatas to set
     */
    public void setqPatas(int qPatas) {
        this.qPatas = qPatas;
    }
    
}
