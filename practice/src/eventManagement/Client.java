
package eventManagement;

public class Client {
    private int id ;
    private String name,password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client(){
    }
    
    public Client(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
     public Client(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.password = client.getPassword();
    }
    
    
}
