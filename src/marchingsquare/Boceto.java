/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marchingsquare;

import java.util.*;

/**
 *
 * @author diegoandres
 */
public class Boceto {

    public static void main(String[] args) {
        int[][] celdas;
        celdas = new int[10][10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                celdas[i][j] = new Random().nextInt(2);
            }
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(celdas[i][j] == 1)
                    System.out.print("• ");
                else
                    System.out.print("° ");
            }
            System.out.println("\n");
        }
    }
    
}
