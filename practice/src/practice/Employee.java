/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author A&A
 */
public class Employee {
    private String name, e_mail , company_name;
    private double salary ;

    public Employee(){
    
    }

    public Employee(String name, String e_mail, String company_name, double salary) {
        this.name = name;
        this.e_mail = e_mail;
        this.company_name = company_name;
        this.salary = salary;
    }
    public Employee(Employee e) {
        this.name = e.getName();
        this.e_mail = e.getE_mail();
        this.company_name = e.getCompany_name();
        this.salary = e.getSalary();
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void displayInfo(){
        System.out.println("Employee name   : "+ name);
        System.out.println("Employee Email  : "+ e_mail);
        System.out.println("Employee company: "+ company_name);
        System.out.println("Employee salary : "+ salary);
    
    }
    
}
