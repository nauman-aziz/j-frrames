//package practice;
//import java.util.Scanner;
//
//public class JavaPractice {
//    
//   public static void pattern(){
//     int start ;
//        int end =0,temp;
//        
//        for(int i = 0 ; i< 7 ; i++){
//            System.out.println("");
//            start = i;
//            
//           for(int j=0 ; j<14 ; j++ ){
//               if(i<4){
//                    end = 13-i;
//                    if(i==0 ){
//                        System.out.print("*");
//                    } 
//                    else{
//                        if(j%2 != 0 && start != 0){
//                            System.out.print(" ");
//                            start --;
//                        }else{
//                            if((j >= end || j==end-1) && j%2 == 0 ){
//                                System.out.print(" ");
//
//                            }else{  
//                                if(j>5 && j<9 && i==3){
//                                    System.out.print(" ");
//                                }else{
//                                    System.out.print("*");
//                                }
//                               
//
//                            }
//
//                        }
//                    } 
//               }if(i>3){
//                   
//                
//                    if(i==6 ){
//                        System.out.print("*");
//                    }else{
//                        if(j%2 == 0 && start >0){
//                            System.out.print("*");
//                            start--;
//                        
//                        }else{
//                            
//                            
//                            if((j >= end || j==end-1) && j%2 == 0 ){
//                                System.out.print(" ");
//                                end++;
//
//                            }else{  
//                                if(j%2 != 0 && (j<start || j==start+1)){
//                                    System.out.print(" ");
//                                }else{
//                                    System.out.print("*");
//                                }
//                                
//                            }
//
//                        }
//                        
//                    } 
//                   
//               }
//              
//            }      
//        }
//    
//    }
//   public static void Employee(){
//       
//       double payAmount,payPeriods,annualPay,periods;
//       payAmount = 2000.00;
//       payPeriods =12;
//       annualPay = payAmount * payPeriods;
//       System.out.println(annualPay);
//       
//   
//   }
//   public static void CompanyRecord(){
//       int totalCustomers = 12467;
//       System.out.println("The approximate number of customers in the survey who purchase one or more energy drinks per week is "+ (totalCustomers/100)*14);    
//       System.out.println("The approximate number of customers in the survey who prefer citrus flavored energy drinks is "+ (totalCustomers/100)*64);    
//       
//   
//   }
//   public static void ArmStrongRange(){
//       int num1, num2, i, n, rem, temp, count=0;
//		num1 = 0;
//		num2 = 408;
//		for(i=num1; i<=num2; i++)
//		{
//			temp=i;
//			n=0;
//			while(temp!=0)
//			{
//				rem=temp%10;
//				n = n + rem*rem*rem;
//				temp=temp/10;
//			}
//			if(i==n)
//			{
//				if(count==0)
//				{
//                                    System.out.println("Armstrong numbers between the given interval are : ");
//				}
//				System.out.print(i+ " ");
//				count++;
//			}
//		}
//		if(count==0)
//		{
//                     System.out.println("Armstrong number not found between the given interval");
//		}
//   
//   
//   }
//   public static void PakFlag(){
//        int n=5;
//        for(int i =1 ; i<= n ; i++){
//                for(int j =1 ; j<= n ; j++){
//
//
//                        if(i==1 || i==n || j==1 || j==n){
//                                System.out.print("#");
//
//
//                        }else{
//                                System.out.print("*");
//
//
//                        }
//
//
//                }
//                System.out.println();
//
//        }
//
//   
//   }
//   public static void number_of_even_and_odd_integers(){
//        int[] numberArray = {5,7,2,4,9};
//        int countEven = 0;
//        int countOdd = 0;
//        for(int i=0 ; i<numberArray.length ; i++){
//            if(numberArray[i]%2 == 0){
//                countEven++;
//            }else{
//                countOdd++;
//            }
//        }
//        System.out.print("Original Array: [" );
//        for(int i=0 ; i<numberArray.length ; i++){
//           if(i!= numberArray.length-1)
//           System.out.print(numberArray[i] +",");
//           else
//           System.out.println(numberArray[i] +"]");    
//        }
//        System.out.println("Count of even numbers : " + countEven);
//        System.out.println("Count of odd numbers : " + countOdd);
//   
//   }
//   public static void sumTill(){
//        SumClass obj = new SumClass();
//        int counter = 1;
//        float temp;
//        while(true){
//            Scanner input = new Scanner(System.in);
//            System.out.print("Enter Number 1: ");
//            temp = input.nextFloat();
//            if(temp == -1)
//                break;
//            
//            obj.setNum1(temp);
//            System.out.print("Enter Number 2: ");
//            temp = input.nextFloat();
//            if(temp == -1)
//                break;
//            
//            obj.setNum2(temp);
//            System.out.println("Sum is: " +  obj.sum());
//            if(counter == 1)
//                System.out.println("Operation performed "+ counter  +" time");
//            else
//                 System.out.println("Operation performed "+ counter  +" times");
//            
//            counter++ ; 
//        }
//
//   }
//  
//    public static void main(String[] args) {
////        pattern();
////        Employee();
////        CompanyRecord();
////        ArmStrongRange();
////        PakFlag();
////       String s;
////       
////       Employee[] employeeArray = new Employee[5];
////       for(int i = 0 ; i<5 ; i++ ){
////           employeeArray[i] = new Employee();
////       }
////       Scanner input = new Scanner(System.in);
////       employeeArray[0] = new Employee();
////       
////       System.out.print("Enter 1st employee name :");
////       employeeArray[0].setName(input.nextLine());
////       System.out.print("Enter 1st employee Email :");
////       employeeArray[0].setE_mail(input.nextLine());
////       System.out.print("Enter 1st employee company name :");
////       employeeArray[0].setCompany_name(input.nextLine());
////       System.out.print("Enter 1st employee salary :");
////       employeeArray[0].setSalary(input.nextDouble());
////       employeeArray[0].displayInfo();
////       
////       System.out.println("Creating 2nd employee by copy constructor");
////       employeeArray[1] = new Employee(employeeArray[0]);
////       employeeArray[1].displayInfo();
////       
////       System.out.println("Creating 3rd employee by parameterized constructor");
////       employeeArray[2] =new Employee("Numan" , "BITF18A502@pucit.edu.pk","NA_Soft" , 100000);
////       employeeArray[2].displayInfo();
////       
////       
////       System.out.println("Change the name of the 3rd employee and use it to make 4th employee");
////       employeeArray[2].setName("Eman Ijaz");
////       employeeArray[3] = new Employee(employeeArray[2]);
////       employeeArray[3].displayInfo();
////       
////       System.out.println("Creating 5th employee by parameterized constructor");
////       employeeArray[4] =new Employee("Eman Ijaz" , "BITF17A507@pucit.edu.pk","NA_Soft" , 123456);
////       employeeArray[4].displayInfo();
//       
//       
//  
//                StudentData studentData ;
//		studentData = new Student();
//		
//		//testing setters
//		studentData.setName();
//		studentData.setRollNumber();
//		studentData.setCGPA();
//		
//		//testing getters
//		System.out.println("Name     :"+ " " +studentData.getName());
//		System.out.println("Roll no. :"+ " " +studentData.getRollNumber());
//		System.out.println("CGPA     :"+ " " +studentData.getCGPA());	
//		
//		System.out.println();
//		
//		//testing showData function
//		studentData.showData();
//       
//        
////       SubArmStrong subClass = new SubArmStrong();
////       subClass.armstrongNumbers();
//       
////     Book b = new Book();
////     b.getData();
////     b.putData();
////        
////     Tape t = new Tape();
////     t.getData();
////     t.putData();   
////        
// 
//    }
//}
//   
