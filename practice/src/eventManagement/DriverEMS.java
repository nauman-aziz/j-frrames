
package eventManagement;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

class EventManagementSystem{
     //Data Member
    private final ArrayList<Admin> adminList;
    private final ArrayList<Client> clientList;
    private Admin loginAdmin;//logined admin
    private Client loginClient;//logined client
    private int indexAdmin;
    private int indexClient;
    private Boolean a,c;

    public Admin getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(Admin loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public Client getLoginClient() {
        return loginClient;
    }

    public void setLoginClient(Client loginClient) {
        this.loginClient = loginClient;
    }

    public int getIndexAdmin() {
        return indexAdmin;
    }

    public void setIndexAdmin(int indexAdmin) {
        this.indexAdmin = indexAdmin;
    }

    public int getIndexClient() {
        return indexClient;
    }

    public void setIndexClient(int indexClient) {
        this.indexClient = indexClient;
    }

    public Boolean getA() {
        return a;
    }

    public void setA(Boolean a) {
        this.a = a;
    }

    public Boolean getC() {
        return c;
    }

    public void setC(Boolean c) {
        this.c = c;
    }
    
    
    //Constructor
    EventManagementSystem(){
        adminList = new ArrayList<>();
        clientList = new ArrayList<>();
        readClientFile ( );
        readAdminFile ( );
        a=c=false;
    }
    public void readAdminFile ( ){
        String tokens[],spliter[];

        String id, name, password;
        try {

            FileReader fr = new FileReader("Admin.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while ( line != null ) {
                tokens = line.split(",");

                spliter = tokens[0].split(":");
                id = spliter[1];
                spliter = tokens[1].split(":");
                name = spliter[1];
                spliter = tokens[2].split(":");
                password = spliter[1];
                Admin temp = new Admin(Integer.parseInt(id), name, password);
                adminList.add(temp);
                line = br.readLine();
            }

        }catch(IOException ioEx){ System.out.println(ioEx); }
    }
    public void readClientFile ( ){
        String tokens[],spliter[];

        String id, name, password;
        try {

            FileReader fr = new FileReader("Client.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while ( line != null ) {
                tokens = line.split(",");

                spliter = tokens[0].split(":");
                id = spliter[1];
                spliter = tokens[1].split(":");
                name = spliter[1];
                spliter = tokens[2].split(":");
                password = spliter[1];
                Client temp = new Client(Integer.parseInt(id), name, password);
                clientList.add(temp);
                line = br.readLine();
            }

        }catch(IOException ioEx){ System.out.println(ioEx); }
    }
    
public  Boolean loginForAdmin(){
        
        int id,i;
        String password;
        i=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your ID.");
        id = scanner.nextInt() ;
        for (Admin adminList1 : adminList) {
            i++;
            Admin admin = (Admin) adminList1;
            if(admin.getId() == id){
                System.out.println("Enter Password");
                Scanner sc = new Scanner(System.in);
                password = sc.nextLine();
                if(admin.getPassword().equals(password) ){
                    indexAdmin =i;
                    a=true;
                    loginAdmin = new Admin(admin);
                    return true;
                }
            }
        }
        
        System.out.println("No such Admin exists");
        return false;
		
    }
    public  Boolean loginForClient(){
        
        int id,i;
        String password;
        i=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your ID.");
        id = scanner.nextInt() ;
        for (Client clientList1 : clientList) {
            i++;
            Client client = (Client) clientList1;
            if(client.getId() == id){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Password");
                password = sc.nextLine();
                if(client.getPassword().equals(password) ){
                    indexClient =i;
                    c=true;
                    loginClient = new Client(client);
                    return true;
                }
                
            }
        }
        
        System.out.println("No such Client exists");
        return false;
		
    }
    public void viewClients(){
        int i=1;
        System.out.println("Showing all the registered clients");
        System.out.println("==================================");
        for(Client clientList1 : clientList ){
            System.out.println("                      Client no."+i);
            System.out.println("                      ============");
            Client c = (Client) clientList1;
            System.out.println("   id     |"+c.getId());
            System.out.println("  Name    |"+c.getName());
            System.out.println("Password  |"+c.getPassword());
            i++;
            System.out.println("==================================");
        }
        
    }
    public void searchClient(){
        int id;
        Boolean check = false;
        System.out.println("Enter the Client ID to search");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        System.out.println("==================================");
        for(Client clientList1 : clientList ){
            
            Client c = (Client) clientList1;
            if(c.getId() == id){
                check =true;
                System.out.println("   id     |"+c.getId());
                System.out.println("  Name    |"+c.getName());
                System.out.println("Password  |"+c.getPassword());
                System.out.println("==================================");
                break;
            }
            
        }
        if(check == false){
            System.out.println("Client Not Exists");
        }
    
    }
    
    public void deleteClient(){
        int id,i=0;
        Boolean check = false;
        System.out.println("Enter the Client ID to delete");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        System.out.println("==================================");
        for(Client clientList1 : clientList ){
            
            Client c = (Client) clientList1;
            if(c.getId() == id){
                check =true;
                clientList.remove(i);
                System.out.println("Client Deleted Successfully");
                System.out.println("==================================");
                break;
            }
            i++;
        }
        if(check == false){
            System.out.println("Client Not Exists");
        }
    
    }
    
    public void saveData(){
                //save every account record into Client file
        System.out.println("Saving data to Clients file....");
        File accountsFile = new File("Client.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        PrintWriter pr = null;
        try {
            fr = new FileWriter(accountsFile, false); //if we use "true" then records will be append
            br = new BufferedWriter(fr);
            pr = new PrintWriter(br);
            File f = new File("Client.txt");
            if(f.exists()){
                f.delete();
                try {
                        f.createNewFile();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }	
            for(Client clientList1 : clientList){
                Client c = (Client) clientList1;
                pr.println("Id:"+c.getId()+","+" Name:"+c.getName()+","+" Password:"+c.getPassword());

            }
        
            pr.close();
            br.close();
            fr.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("System Shutting Down ");
    }
    
    public void showMenuAdmin(){
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
        Scanner scanner = new Scanner(System.in);  

        System.out.println("============================================================================================");
        System.out.println("                              \"Welcome "+loginAdmin.getName()+" \"                           ");
        System.out.println("============================================================================================");
        do{
            System.out.println("\n\n");
            System.out.println("1:  view the details of all clients");
            System.out.println("2:  search the details of a client");
            System.out.println("3:  Delete a client");
            System.out.println("4:  Exit");
            System.out.print(">>");
               
            option = scanner.nextInt();
            switch (option){
                case 1:this.viewClients();break;
                case 2:this.searchClient();break;
                case 3:this.deleteClient();break;    
                case 4:this.saveData();System.exit(0);break;
                default:System.out.println("invalid option please select again\n");break;    
            }
        }while(option!=4 );
    
    }
    
    public void showMenuClient(){
                                                             //if successfully login
        //just for delay
        System.out.println("\n\n                                preparing Files\n                                 Hold on a min.\n");
        try {
                TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
       
        Scanner scanner ;   

        System.out.println("============================================================================================");
        System.out.println("                               \"Welcome "+loginClient.getName()+" \"                       ");
        System.out.println("============================================================================================");
        try{  
           //the file to be opened for reading  
           FileInputStream fis = new FileInputStream("event.txt");       
           scanner = new Scanner(fis);    //file to be scanned   
           while(scanner.hasNextLine()){
               System.out.println(scanner.nextLine());
               
           }
          scanner.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    
    }

}

public class DriverEMS {
    public static void main (String[] args){
    EventManagementSystem ems = new EventManagementSystem();
           int loginTries=2;   //Login check
           int module;
           Scanner scanner = new Scanner(System.in);
           System.out.println("                                                                                ");
           System.out.println("============================================================================================");
           System.out.println("                    *          **         ***     *****   **    *                           ");
           System.out.println("                    *        *    *      *          *     * *   *                           ");
           System.out.println("                    *       *      *    *   ***     *     *  *  *                           ");
           System.out.println("                    *        *    *      *   *      *     *   * *                           ");
           System.out.println("                    *******    **         ***     *****   *    **                           ");
           System.out.println("============================================================================================");
           System.out.println("             1)Admin                                            2)Client                    ");
           System.out.print(">>");
           module = scanner.nextInt();
           System.out.println("============================================================================================");
           if(module == 1){
               ems.setA(true);
               System.out.println("                                    Admin Portal                                            ");
           }else if(module == 2){
               ems.setC(true);
               System.out.println("                                    Client Portal                                            ");
           }else{
               System.out.println("                             Not valid option ...(Shutting down)                             ");
               System.exit(0);
           }
           System.out.println("============================================================================================");
           while(loginTries>-2){
                if(ems.getA() && ems.loginForAdmin() ){
                    ems.showMenuAdmin();
                }else if(ems.getC() && ems.loginForClient()){
                    ems.showMenuClient();
                     System.exit(0);
                }else {
                    System.out.println("Please Enter valid input\n you have "+loginTries+" tries remaining");
                    loginTries--;
                    if(loginTries == -1 ) {

                        System.out.println("Security Alaram ringing");
                        for (int j = 0; j <5 ; j++) {
                                java.awt.Toolkit.getDefaultToolkit().beep(); 
                        }
                        System.exit(0);
                    }

               }
           }
    
    }

    
}
