package makemystay;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 1
 */
public class MmsUserManager {
    /**
     * 
     * @param username
     * @return Returns either null is username is not found in the database,
     * or an IMmsUser handle if the username if found. Always check for null
     * when using this method.
     */
    public static IMmsUser getUserByUsername (String username) {
        IMmsUser user = null;
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT IdUser FROM User " +
                    "WHERE UserName ='" + username + "' " +
                        " AND Deleted=False;");
            if (rs.next()) {
                user = MmsUserManager.getUser(rs.getInt("IdUser"));
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return user;
    }
    
    public static IMmsUser getUser (int userId) {
        MmsUser user = null;
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT * FROM User " +
                    "WHERE IdUser =" + userId +
                        " AND Deleted=False;");
            while (rs.next()) {
                user = new MmsUser(
                    rs.getInt("IdUser"),
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("Email"),
                    rs.getString("LName"),
                    rs.getString("FName"));
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return user;
    }
    /**
     *Do not use this method. It was for testing purposes only.
     */
    
    public static List<IMmsUser> getUsers() {
        List<IMmsUser> userList = new ArrayList<IMmsUser>();
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(
                        "SELECT * " +
                                "FROM User " +
                                "WHERE Deleted=False;");
            while (rs.next()) {
                IMmsUser newItem = MmsUserManager.getUser(rs.getInt("IdUser"));
                userList.add(newItem);
            }
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

        return userList;
    }
    
    public static boolean isPropertyOwner (int userId) {
        boolean isPropertyOwner = false;
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT Count(*) AS PropertyCount FROM Property WHERE IdUser=" + userId + ";";
            ResultSet rs = s.executeQuery(sqlString);
            //System.out.println(sqlString);
            //System.out.println(getSqlTypeName(rs.getMetaData().getColumnType(1)));
            rs.next();
            if (rs.getInt("PropertyCount") > 0)
                isPropertyOwner = true;
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return isPropertyOwner;
    }
    
    public static List<IMmsProperty> getPropertiesAsOwner (IMmsUser user) {
        return getPropertiesAsOwner(user.getUserId());
    }
    
    public static List<IMmsProperty> getPropertiesAsOwner (int userId) {
        List<IMmsProperty> properties = new ArrayList<IMmsProperty>();
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT IdProperty FROM Property " +
                                "WHERE IdUser=" + userId + " AND Deleted=False;";
            ResultSet rs = s.executeQuery(sqlString);
            while (rs.next()) {
                properties.add(MmsPropertyManager.getProperty(rs.getInt("IdProperty")));
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return properties;
    }
    
    public static List<IMmsProperty> getPropertiesAsDelegate (IMmsUser user) {
        return getPropertiesAsDelegate(user.getUserId());
    }
    
    public static List<IMmsProperty> getPropertiesAsDelegate (int userId) {
        List<IMmsProperty> properties = new ArrayList<IMmsProperty>();
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT IdProperty FROM PropertyDelegateMap " +
                                "WHERE IdUser=" + userId + " AND Deleted=False;";
            ResultSet rs = s.executeQuery(sqlString);
            while (rs.next()) {
                properties.add(MmsPropertyManager.getProperty(rs.getInt("IdProperty")));
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return properties;
    }
    
    /**
     * This method is an internal check for collisions with existing database
     * values. It should not be a replacement for properly validating new user
     * entries. This should be implemented as business logic. This method
     * merely attempts to reduce or eliminate SQL exceptions which may be
     * difficult or complex to debug.
     */
    
    private static boolean hasCollision (String username, String email) {
        boolean hasCollision = true;
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT Count(*) as UserCount " +
                                "FROM User " +
                                "WHERE UserName='" + username + "' OR " +
                                    "Email='" + email + "';";            
            ResultSet rs = s.executeQuery(sqlString);
            
            while (rs.next()) {
                if (rs.getInt("UserCount") == 0)
                    hasCollision = false;
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return hasCollision;
    }
    
    public static IMmsUser addNewUser (String username, String password,
            String lastName, String firstName, String email) {
        IMmsUser newUser = null;
        
        if (!MmsUserManager.hasCollision(username, email)) {
            try {
                Connection conn = MmsDb.getOpenConnection();
                Statement s = conn.createStatement();
                String sqlString = "INSERT INTO User " +
                            "(UserName, Password, LName, FName, Email, Deleted) " +
                        "VALUES(" + username + ", " + password + ", " + lastName + 
                            ", " + firstName + ", " + email + ", False;";
                s.executeQuery(sqlString);

                s = conn.createStatement();
                sqlString = "SELECT IdUser FROM User WHERE UserName='" + "';";
                ResultSet rs = s.executeQuery(sqlString);

                while (rs.next()) {
                    newUser = MmsUserManager.getUser(rs.getInt("IdUser"));
                }

                rs.close();
                s.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return newUser;
    }
    
/**
 * The following code was found on Stack Overflow. I did not write it.
 * It's for test purposes only.
 *   
 */

    private static String getSqlTypeName(int type) {
        switch (type) {
        case Types.BIT:
            return "BIT";
        case Types.TINYINT:
            return "TINYINT";
        case Types.SMALLINT:
            return "SMALLINT";
        case Types.INTEGER:
            return "INTEGER";
        case Types.BIGINT:
            return "BIGINT";
        case Types.FLOAT:
            return "FLOAT";
        case Types.REAL:
            return "REAL";
        case Types.DOUBLE:
            return "DOUBLE";
        case Types.NUMERIC:
            return "NUMERIC";
        case Types.DECIMAL:
            return "DECIMAL";
        case Types.CHAR:
            return "CHAR";
        case Types.VARCHAR:
            return "VARCHAR";
        case Types.LONGVARCHAR:
            return "LONGVARCHAR";
        case Types.DATE:
            return "DATE";
        case Types.TIME:
            return "TIME";
        case Types.TIMESTAMP:
            return "TIMESTAMP";
        case Types.BINARY:
            return "BINARY";
        case Types.VARBINARY:
            return "VARBINARY";
        case Types.LONGVARBINARY:
            return "LONGVARBINARY";
        case Types.NULL:
            return "NULL";
        case Types.OTHER:
            return "OTHER";
        case Types.JAVA_OBJECT:
            return "JAVA_OBJECT";
        case Types.DISTINCT:
            return "DISTINCT";
        case Types.STRUCT:
            return "STRUCT";
        case Types.ARRAY:
            return "ARRAY";
        case Types.BLOB:
            return "BLOB";
        case Types.CLOB:
            return "CLOB";
        case Types.REF:
            return "REF";
        case Types.DATALINK:
            return "DATALINK";
        case Types.BOOLEAN:
            return "BOOLEAN";
        case Types.ROWID:
            return "ROWID";
        case Types.NCHAR:
            return "NCHAR";
        case Types.NVARCHAR:
            return "NVARCHAR";
        case Types.LONGNVARCHAR:
            return "LONGNVARCHAR";
        case Types.NCLOB:
            return "NCLOB";
        case Types.SQLXML:
            return "SQLXML";
        }

        return "?";
    }
}
