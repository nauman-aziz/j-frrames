
package labsTesting;
import java.util.*;
class NewException extends Exception{

    public NewException(String s){
        super(s);
    }
}

class Number {

    public float calculateQuotient(int numerator , int denominator)throws NewException{
       
        if(denominator != 0){
            return numerator/(float)denominator;
        }else{
            throw new NewException("Denominator shouldn't be zero . . . ");
            
        }
    }    
}

public class QuotientDriver {
//     public static void main (String[] args){
//        int num1 , num2;
//        Scanner scanner = new Scanner(System.in);
//        Number number = new Number();
//        try{
//            System.out.print("Enter 1st number: ");
//            num1 = scanner.nextInt();
//            System.out.print("Enter 2nd number: ");
//            num2 = scanner.nextInt();
//            System.out.print("result: "+ number.calculateQuotient(num1, num2));
//        
//        }catch(Exception ex){
//            ex.printStackTrace();
//        
//        }
//    }
    
}
