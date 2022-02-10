
package homeWork;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Bank implements java.io.Serializable {
    //Data members
    private int accountNo;
    private int pinCode;
    private String name;
    private double amount;

    //Constructors
    public Bank(){
    }
    
    public Bank(String name, int accountNo, int pinCode, double amount) {
        this.name = name;
        this.accountNo = accountNo;
        this.pinCode = pinCode;
        this.amount = amount;
    }
    
    public Bank(Bank bank){
        this.name = bank.getName();
        this.accountNo = bank.getAccountNo();
        this.pinCode = bank.getPinCode();
        this.amount = bank.getAmount();
    }

    //Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
 
}


class CustomersRecordBook{
    //Data Member
    private final ArrayList<Bank> bankList;
    private Bank loginUser;//logined user
    private int index;
    
    
    //Constructor
    CustomersRecordBook(){
        bankList = new ArrayList<>();
    }
    
    public void addNewRecord(){
        String tempName;
        int tempAccountNo,tempPinCode;
        double tempAmount = 1000;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name        :");
        tempName = scanner.nextLine();
        System.out.print("Please enter your account no. :");
        tempAccountNo = scanner.nextInt();
        System.out.print("Please enter your pin code    :");
        tempPinCode = scanner.nextInt();
        Bank bank = new Bank(tempName, tempAccountNo,  tempPinCode, tempAmount);
        bankList.add(bank);
    }
    
    public void addNewRecord(Bank bank){
        bankList.add(bank);
    }
    
    public void transfer( ){
        String recipientName;
        int recipientAccNo;
        double amountTransfer;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter recipient name        :");
        recipientName = scanner.nextLine();
        System.out.print("Please enter recipient account no. :");
        recipientAccNo = scanner.nextInt();
        System.out.print("Please enter amount to transfer    :");
        amountTransfer = scanner.nextDouble();

        if(ifPersonExist(recipientName, recipientAccNo)){// if recipent exists
            makeTransection( recipientAccNo , amountTransfer); // make transection

        }else{
            JOptionPane optionPane = new JOptionPane("Error", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("No such recipient exists");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }  
    }
    
    
    public boolean ifPersonExist(String searchedName , int searchedAccNo ){
        for (Bank bankList1 : bankList) {
            Bank b = (Bank) bankList1;
            if ( searchedName.equals(b.getName()) && searchedAccNo == b.getAccountNo()) 
                return true;
        } 
        return false;    
    }
    public void makeTransection( int receiverAccNo , double amountTransfer){
        //amount deduction
        loginUser.setAmount(loginUser.getAmount() - amountTransfer);
        
        //amount accession
        for (Bank bankList1 : bankList) {
            Bank b = (Bank) bankList1;
            if ( receiverAccNo == b.getAccountNo()){
                b.setAmount(b.getAmount() + amountTransfer);
                break;
            }       
        } 
    }
    
     public void withdraw(){
        double withDrawAmount;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the amount you want to withdraw:");
        withDrawAmount = scanner.nextDouble();
        if (withDrawAmount <= loginUser.getAmount()){
            loginUser.setAmount(loginUser.getAmount() - withDrawAmount);
            bankList.add(index, loginUser);//update the logined user in arrayLlist
        }
        else{
            JOptionPane optionPane = new JOptionPane("Error", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Insufficient Balance");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }
    public  Boolean login(){
        
        int cardNo,pinCode,i;
        i=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card No.");
        cardNo = scanner.nextInt() ;
        for (Bank bankList1 : bankList) {
            i++;
            Bank bank = (Bank) bankList1;
            if(bank.getAccountNo() == cardNo){
                System.out.println("Enter Pin");
                pinCode = scanner.nextInt();
                if(bank.getPinCode() == pinCode){
                    index =i;
                    loginUser = new Bank(bank);
                    return true;
                }
            }
        }
        System.out.println("No such user exists");
        return false;
		
    }
    
    public void showMenu(){
                                                            //if successfully login
        //just for delay
        System.out.println("\n\n                                preparing Files\n                                 Hold on a min.\n");
        try {
                TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        //clearScreen();
        int option;

        System.out.println("============================================================================================");
        System.out.println("                             \"Welcome "+loginUser.getName()+" \"                           ");
        System.out.println("============================================================================================");
        do{
            System.out.println("\n\n");
            System.out.println("1:  Withdraw Cash");
            System.out.println("2:  Check Balance");
            System.out.println("3:  Make a Transection");
            System.out.println("4:  Add new account");
            System.out.println("5:  Exit");
            System.out.print(">>");
            Scanner scanner = new Scanner(System.in);    //System.in is a standard input stream   
            option = scanner.nextInt();
            switch (option){
                case 1:this.withdraw();
                       System.out.println("Amount withdraw successfully \nYour remaining balance is : "+loginUser.getAmount()+" $");break;
                case 2:System.out.println("Your account balance is : "+loginUser.getAmount()+" $");break;
                case 3:this.transfer();break;
                case 4:this.addNewRecord();break;  
                case 5:System.out.println("GOOD BYE "+loginUser.getName()+" :p");
                       this.saveAccountsToFile();System.exit(0);break;
                default:System.out.println("invalid option please select again\n");break;
            }
        }while(option!=5 );

    }
    public void saveAccountsToFile(){
//        //save every account record into accounts file
//        File accountsFile = new File("accounts.txt");
//        FileWriter fr = null;
//        BufferedWriter br = null;
//        PrintWriter pr = null;
//        try {
//            fr = new FileWriter(accountsFile, false); //if we use "true" then records will be append
//            br = new BufferedWriter(fr);
//            pr = new PrintWriter(br);
//        } catch (IOException e1) {
//                e1.printStackTrace();
//        }
//
//        File f = new File("accounts.txt");
//        if(f.exists()){
//            f.delete();
//            try {
//                    f.createNewFile();
//            } catch (IOException e) {
//                    e.printStackTrace();
//            }
//        }	
//        for(Bank bankList1 : bankList){
//            Bank bank = (Bank) bankList1;
//                pr.println(bank.getAccountNo());
//                pr.println(bank.getPinCode());
//                pr.println(bank.getName());
//                pr.println(bank.getAmount());			
//        }
//        try {
//            pr.close();
//            br.close();
//            fr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        bankList.add(index, loginUser);//update the logined user in arrayLlist
        FileOutputStream fOut = null;
        ObjectOutputStream out = null;
        String filename = "account.txt";
        try{
            System.out.println("Writing data into the file");
            fOut = new FileOutputStream(filename);
            out = new ObjectOutputStream(fOut);
            for(Bank bankList1 : bankList){
                Bank bank = (Bank) bankList1;
                out.writeObject(bank);

            }
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
		
    }
        
}

public class BankDriver {
//    public static void main(String[] args) throws IOException  {
//       try{  
//           //the file to be opened for reading  
////           FileInputStream fis = new FileInputStream("accounts.txt");       
////           Scanner sc = new Scanner(fis);    //file to be scanned   
//            CustomersRecordBook customersRecordBook;
//            customersRecordBook = new CustomersRecordBook();
//            
//
//            
////            int option;
////            do{
////            System.out.println("\n\n");
////            System.out.println("1:  Creat User");
////            System.out.println("2:  Login");
////            System.out.println("3:  Exit");
////            System.out.print(">>");
////            Scanner scanner = new Scanner(System.in);    //System.in is a standard input stream   
////            option = scanner.nextInt();
////            switch (option){
////                case 1:customersRecordBook.addNewRecord();customersRecordBook.saveAccountsToFile();break;
////                case 2:customersRecordBook.login();break;
////                case 3:System.exit(0);break;
////                default:System.out.println("invalid option please select again\n");break;
////            }
////        }while(option!=3 );
//            
//            FileInputStream istream = new FileInputStream("account.txt");
//            ObjectInputStream in = new ObjectInputStream(istream);
//            Bank bank;
//            try{
//                while( istream.available() > 0){ // check if the file stream is at the end
//                  bank = (Bank) in.readObject();
//                  customersRecordBook.addNewRecord(bank);
//                }
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//                
////           int count = 0;
////           String temp;
//// 
////           while(sc.hasNextLine())  
////           {  
////                   Bank bank = new Bank();
////                   temp = sc.nextLine();
////                   bank.setAccountNo(Integer.parseInt(temp));
////                   temp = sc.nextLine();
////                   bank.setPinCode(Integer.parseInt(temp));
////                   temp = sc.nextLine();
////                   bank.setName(temp);
////                   temp = sc.nextLine();
////                   bank.setAmount(Double.parseDouble(temp));
////                   customersRecordBook.addNewRecord(bank);
////           }  
////           sc.close();     //closes the file  
//           
//           
//         int loginTries=2;   //Login check
//           System.out.println("                                                                                ");
//           System.out.println("============================================================================================");
//           System.out.println("                    *          **         ***     *****   **    *                           ");
//           System.out.println("                    *        *    *      *          *     * *   *                           ");
//           System.out.println("                    *       *      *    *   ***     *     *  *  *                           ");
//           System.out.println("                    *        *    *      *   *      *     *   * *                           ");
//           System.out.println("                    *******    **         ***     *****   *    **                           ");
//           System.out.println("============================================================================================");
//           while(loginTries>-2){
//                   if(customersRecordBook.login()){
//                           customersRecordBook.showMenu();
//
//                   }else {
//                           System.out.println("Please Enter valid input\n you have "+loginTries+" tries remaining");
//                           loginTries--;
//                           if(loginTries == -1 ) {
//
//                                   System.out.println("Security Alaram ringing");
//                                   for (int j = 0; j <5 ; j++) {
//                                           java.awt.Toolkit.getDefaultToolkit().beep(); 
//                                   }
//                                   System.exit(0);
//                           }
//
//                   }
//           }
//       }catch(IOException e){  
//           e.printStackTrace();  
//       } 
//   }
}
    
