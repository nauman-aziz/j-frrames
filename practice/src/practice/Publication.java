/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Scanner;

/**
 *
 * @author A&A
 */
public class Publication {
    private String title;
    private float price;
    
    public void getData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title");
        title = scanner.nextLine();
        System.out.println("Enter price");
        price = scanner.nextFloat();
    }
    public void putData(){
        System.out.println("Title :"+ title);
        System.out.println("Price :"+ price);
        
    }
}
