/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author luan0
 */
public class Formatador {
    
    public double converterVirgulaParaPonto(String pString){
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if(pString.charAt(i) == ','){
                retorno += '.';
            }
            else{
                retorno += pString.charAt(i);
            }
        }
        return Double.parseDouble(retorno);
   }
    
}
