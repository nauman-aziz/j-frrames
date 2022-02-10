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
public class Tape extends Publication{
    private float playingTime;
     @Override
     public void getData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minutes of playing time");
        scanner.nextFloat();
    }
    @Override
    public void putData(){
        System.out.println("Pages :"+ playingTime);
        
    }
    
}
