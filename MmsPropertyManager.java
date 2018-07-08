package makemystay;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 1
 * Version: 2
 * Updated: 7/7/2018
 *  JS: Created core API functionality
 */
public class MmsPropertyManager {
    public static IMmsProperty getProperty (int propertyId) {
        MmsProperty property = null;
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT * " +
                                "FROM Property " +
                                "WHERE IdProperty=" + propertyId +
                                    " AND Deleted=False;";
            
            ResultSet rs = s.executeQuery(sqlString);
            if (rs.next()) {
                property = new MmsProperty(rs.getInt("IdProperty"),
                    rs.getInt("IdUser"),
                    rs.getString("PropertyName"),
                    rs.getString("PropertyDescription"),
                    rs.getString("LocaleDescription"),
                    rs.getString("StreetAddress"),
                    rs.getString("City"),
                    rs.getString("State"),
                    rs.getString("PostCode"),
                    rs.getString("Telephone"));
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return property;
    }
    
    public static List<IMmsUser> getDelegatesOfProperty (IMmsProperty property) {
        return getDelegatesOfProperty(property.getPropertyId());
    }
    
    public static List<IMmsUser> getDelegatesOfProperty (int propertyId) {
        List<IMmsUser> listDelegates = new ArrayList<IMmsUser>();
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT IdUser " +
                                "FROM PropertyDelegateMap " +
                                "WHERE IdProperty=" + propertyId +
                                    " AND Deleted=False;";
            
            ResultSet rs = s.executeQuery(sqlString);
            while (rs.next()) {
                listDelegates.add(MmsUserManager.getUser(rs.getInt("IdUser")));
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return listDelegates;
    }
    
    private static boolean hasCollision (int owner, String propertyName) {
        boolean hasCollision = true;
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT Count(*) AS PropertyCount " +
                    "FROM Property " +
                    "WHERE IdUser=" + owner + " AND PropertyName='" + propertyName + "';";
            ResultSet rs = s.executeQuery(sqlString);
            rs.next();
            if (rs.getInt("PropertyCount") == 0)
                hasCollision = false;
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return hasCollision;
    }
    
    public static IMmsProperty addProperty (int owner, String propertyName,
            String propertyDescription, String localeDescription,
            String streetAddress, String city, String state, String postCode,
            String telephone) {
        IMmsProperty newProperty = null;
        
        if (!MmsPropertyManager.hasCollision(owner, propertyName)) {
            try {
                Connection conn = MmsDb.getOpenConnection();
                Statement s = conn.createStatement();
                String sqlString = "INSERT INTO Property (IdUser, PropertyName, " +
                        "PropertyDescription, LocaleDescription, StreetAddress, " +
                        "City, State, PostCode, Telephone, Deleted) " +
                        "Values (" + 
                            owner + ", " +
                            "'" + propertyName + "', " +
                            "'" + propertyDescription + "', " +
                            "'" + localeDescription + "', " +
                            "'" + streetAddress + "', " +
                            "'" + city + "', " +
                            "'" + state + "', " +
                            "'" + postCode + "', " +
                            "'" + telephone + "' " +
                            "False);";

                s.executeUpdate(sqlString);
                s.close();
                s = conn.createStatement();

                sqlString = "SELECT IdProperty " +
                        "FROM Property " +
                        "WHERE IdUser=" + owner +
                            " AND PropertyName='" + propertyName + "';";

                ResultSet rs = s.executeQuery(sqlString);

                if (rs.next())
                    newProperty = MmsPropertyManager.getProperty(rs.getInt("IdProperty"));

                rs.close();
                s.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return newProperty;
    }
    
    public static void deleteProperty (IMmsProperty property) {
        MmsPropertyManager.deleteProperty(property.getPropertyId());
    }
    
    public static void deleteProperty (int propertyId) {
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            
            String sqlString = "UPDATE Property " +
                    "SET Deleted=True " +
                    "WHERE IdProperty=" + propertyId + ";";
            
            s.executeUpdate(sqlString);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}

