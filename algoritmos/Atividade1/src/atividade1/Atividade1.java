/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade1;

import atividade1.Vo.Venda;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Atividade1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Venda venda = new Venda();
        venda.setData(scanner.nextLine());
        venda.setHora(scanner.nextLine());
        venda.setNumeroDaVenda(scanner.nextInt());
        venda.gravarVenda(venda);
    }
    
}
