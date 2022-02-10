package eventManagement;

public class Admin {
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

    public Admin(){
    }
    
    public Admin(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    public Admin(Admin admin){
        this.id = admin.getId();
        this.name = admin.getName();
        this.password = admin.getPassword();
    }
    
    
}
