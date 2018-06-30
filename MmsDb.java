/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makemystay;
import java.sql.*;

/**
 *
 * @author owner
 */
public class MmsDb {
    
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
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                     "jdbc:ucanaccess://C:/users/owner/documents/MakeMyStay.accdb");
            return conn;
        }
        catch (Exception ex) {
             ex.printStackTrace();
        }
        return conn;
    }
    
}
