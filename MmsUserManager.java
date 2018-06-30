/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makemystay;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;

/**
 *
 * @author Josh Seaton
 */
public class MmsUserManager {
    public static List<IMmsUser> getUsers() {
        List<IMmsUser> userList = new ArrayList<IMmsUser>();
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM User WHERE Enabled=True;");
            while (rs.next()) {
                MmsUser newItem = new MmsUser();
                newItem.setUserId(rs.getInt("IdUser"));
                newItem.setUsername(rs.getString("Username"));
                newItem.setPassword(rs.getString("Password"));
                newItem.setEmail(rs.getString("Email"));
                newItem.setLastName(rs.getString("LName"));
                newItem.setFirstName(rs.getString("FName"));
                userList.add(newItem);
            }
            
            s.close();
            conn.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

        return userList;
    }
    
    public static boolean isPropertyOwner (int userId) {
        boolean retVal = false;
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT Count(*) AS PropertyCount FROM Property WHERE IdUser=" + userId + ";";
            ResultSet rs = s.executeQuery(sqlString);
            //System.out.println(sqlString);
            //System.out.println(getSqlTypeName(rs.getMetaData().getColumnType(1)));
            rs.next();
            if (rs.getInt("PropertyCount") > 0)
                retVal = true;
            
            s.close();
            conn.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return retVal;
    }
    
/*
 * The following code was found on Stack Overflow. I did not write it.
 * It's for test purposes only.
 *   
 */
    
    public static String getSqlTypeName(int type) {
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
