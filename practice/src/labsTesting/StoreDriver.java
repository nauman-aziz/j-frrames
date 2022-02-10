
package labsTesting;
import java.util.*;
class IndexException extends Exception{

    public IndexException(String s){
        super(s);
    }
}

class Store {
    Scanner scanner = new Scanner(System.in);
    private int myArray[];
    private int size;
    public Store(int size){
        this.size = size;
        myArray =  new int[size];
    }
    public void store()throws IndexException{
        System.out.print("Enter index number: ");
       
        int index = scanner.nextInt();
        if(index >= size || index < 0 ){
            throw new IndexException("Invalid index...");
        }else{
            System.out.print("Enter value: ");
            int value = scanner.nextInt();
            myArray[index] = value;
            
        }
 
    }
    public void print(){
        if(myArray != null){
            int i = 0;
            while(i< size){
                System.out.println("Index :"+i+" Value :"+myArray[i]);
                i++;
            }
        }else{
            System.out.println("Array is null");
        
        }
    }


}
public class StoreDriver {
//    public static void main (String[] args){
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter size of array: ");
//        int size = scanner.nextInt();
//        Store str = new Store(size);
//        int option;
//        System.out.println("============================================================================================");
//        System.out.println("                             \"Welcome Customer \"                                          ");
//        System.out.println("============================================================================================");
//        do{
//            System.out.println("\n\n");
//            System.out.println("1:  Add value in the array");
//            System.out.println("2:  Print all values");
//            System.out.println("3:  Exit");
//            System.out.print(">>");
//            scanner = new Scanner(System.in);  
//            option = scanner.nextInt();
//            switch (option){
//                case 1:try{
//                    str.store();
//                }catch(IndexException ex){
//                    System.out.println("Error"+ex);
//                };break;
//                case 2:str.print();break;
//                case 3:System.out.println("GOOD BYE :p");System.exit(0);break;
//                default:System.out.println("invalid option please select again\n");break;
//            }
//        }while(option!=3 );
//    
//    }
    
}
