/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Scanner;

public class Book extends Publication{
    private int pageCount;
    @Override
     public void getData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no. of pages");
        scanner.nextInt();
    }
    @Override
    public void putData(){
        System.out.println("Pages :"+ pageCount);
        
    }
    
}
