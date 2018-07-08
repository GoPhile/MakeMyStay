package makemystay;
import java.sql.*;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 2
 * JS: Now, it attempts to not close the connection while running
 */
public class MmsDb {
    private static Connection conn;
    
    public static void test () {
        try {
            Connection conn=DriverManager.getConnection(
                "jdbc:ucanaccess://C:/users/owner/documents/MakeMyStay.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM User;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            // close and cleanup
            s.close();
            conn.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static Connection getOpenConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                    conn = DriverManager.getConnection(
                             "jdbc:ucanaccess://C:/users/owner/documents/MakeMyStay.accdb");
            }
        }
        catch (Exception ex) {
             ex.printStackTrace();
        }
        
        return conn;
    }
    
    public static void closeConnection() {
        try {
            if (conn != null || !conn.isClosed()) {
                conn.close();
            }
        }
        catch (Exception ex) {
             ex.printStackTrace();
        }
    }
}
