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
public class Student implements StudentData{
    private String name,rollNo;
    private double CGPA;
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void setName(){
        System.out.println("Enter Student name: ");
        this.name = scanner.nextLine();
    }
    @Override
    public void setRollNumber(){
        System.out.println("Enter Student roll number: ");
        this.rollNo = scanner.nextLine();
    }
    @Override
    public void setCGPA(){
        System.out.println("Enter Student CGPA: ");
        this.CGPA = scanner.nextDouble();
    }
    @Override
    public String getName(){
            return name;
    }
    @Override
    public String getRollNumber(){
            return rollNo;
    }
    @Override
    public double getCGPA(){
            return CGPA;
    }
    @Override
    public void showData(){
            System.out.println("Name     :"+ " " +this.name);
            System.out.println("Roll no. :"+ " " +this.rollNo);
            System.out.println("CGPA     :"+ " " +this.CGPA);
    }
    
}
