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
public class SubArmStrong extends ArmStrong{
    @Override
    void armstrongNumbers(){
        int  newGenNum, remmainder, tt;
        for(int i=0; i<=1000; i++){
            tt=i;
            newGenNum=0;
            while(tt!=0){
                    remmainder=tt%10;
                    newGenNum = newGenNum + remmainder * remmainder *remmainder;
                    tt=tt/10;
            }
            if(i==newGenNum){
                System.out.print(i+ " ");
                
            }
        }
  
    }
    
}
