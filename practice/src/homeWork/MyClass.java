/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeWork;

/**
 *
 * @author A&A
 */
public abstract class MyClass{
    //public abstract int dataMember;   we cannot declare datamembers as abstract

    public abstract void display();

    public  abstract void displaySomething();

    public void show()
    {System.out.println("This method is declared in Abstract class");}
    
    public MyClass(){
        System.out.println("Yes, Abstract Classes can have constructors !\n" 
                + " ract class can have a constructor though it cannot be instantiated. But"
                + " the constructor defined in an abstract class can be used for"
                + " instantiation of concrete class of this abstract class.");
    }
    
//    public abstract MyClass(int a){
//        System.out.println("NO a constructor cannot be abstract");
//    }
    

}


 