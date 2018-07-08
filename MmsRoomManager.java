/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makemystay;

import java.sql.*;
import java.util.*;

/**
 *
 * @author owner
 */
public class MmsRoomManager {
    public static List<IMmsRoom> getRooms (IMmsProperty property) {
        List<IMmsRoom> rooms = new ArrayList<>();
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT IdRoom " +
                    "FROM Room " +
                    "WHERE IdProperty =" + property.getPropertyId() +
                        " AND Deleted=False;");
            while (rs.next()) {
                rooms.add(MmsRoomManager.getRoom(rs.getInt("IdRoom")));
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return rooms;
    }
    
    public static IMmsRoom getRoom (int roomId) {
        MmsRoom room = null;
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT * FROM Room " +
                    "WHERE IdRoom =" + roomId +
                        " AND Deleted=False;");
            while (rs.next()) {
                room = new MmsRoom();
                
                room.setRoomId(rs.getInt("IdRoom"));
                room.setProperty(rs.getInt("IdProperty"));
                room.setDescription(rs.getString("Description"));
                room.setDesignation(rs.getString("Designation"));
            }
            
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return room;
    }
    
    public void addRoom (int propertyId, String description, String designation) {
        ;
    }
}
