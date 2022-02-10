
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Helpers {
      public static void displayMessage(String title,String msg){
         JOptionPane.showMessageDialog(null, msg, "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
    }
      
    public static DefaultTableModel loadData(ResultSet rs) throws SQLException { 
     
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames;
        columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
  
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }
         
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> list = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                list.add(rs.getObject(i));
            }
            data.add(list);
        }
        return new DefaultTableModel(data, columnNames);
        
    }
               
}

