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
public interface StudentData {
    void setName();
    void setRollNumber();
    void setCGPA();

    String getName();
    String getRollNumber();
    double getCGPA();

    void showData();
    
}
