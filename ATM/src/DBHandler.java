import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHandler {
   static final String DB_URL =
      "jdbc:derby://localhost:1527/ATMdataBase;create=true";
   static final String DB_DRV =
      "org.apache.derby.jdbc.ClientDriver";
   static final String DB_USER = "APP";
   static final String DB_PASSWD = " ";

  
    public Connection getDbConnection(){
    
        Connection connection = null; 
      try{          
         // Class.forName("org.apache.derby.jdbc.ClientDriver");
         connection = DriverManager.getConnection
            (DB_URL,DB_USER,DB_PASSWD); 
         return connection;
      }
      catch(SQLException ex){
      }
//      catch (ClassNotFoundException ex) {
//           Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
//       }
        return null;
    }
}
