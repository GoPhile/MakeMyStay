package makemystay;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Josh Seaton
 * Created: 7/8/2018
 * Version: 1
 */

public class MmsReservationManager {
    private static Map<Integer, IMmsReservationStatus> reservationStatuses;
    
    public static IMmsReservation getReservation (int reservationId) {
        MmsReservation reservation = null;
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT * " +
                                "FROM Reservation " +
                                "WHERE IdReservation=" + reservationId +  ";";
            ResultSet rs = s.executeQuery(sqlString);
                        
            if (rs.next()) {
                reservation = new MmsReservation(
                    rs.getInt("IdUser"),
                    rs.getInt("IdRoom"),
                    rs.getInt("IdReservationStatus"),
                    rs.getDate("StartDateTime"),
                    rs.getDate("EndDateTime"));
            }
            rs.close();
            s.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return reservation;
    }
    
    private static void getReservationStatusFromDb() {
        reservationStatuses = new HashMap<>();
        
        try {
            Connection conn = MmsDb.getOpenConnection();
            Statement s = conn.createStatement();
            String sqlString = "SELECT * " +
                                "FROM ReservationStatus " +
                                "ORDER BY Ordinal;";
            ResultSet rs = s.executeQuery(sqlString);
            
            while (rs.next()) {
                reservationStatuses.put(rs.getInt("IdReservationStatus"),
                        new MmsReservationStatus(
                                rs.getInt("IdReservationStatus"),
                                rs.getString("Description"),
                                rs.getInt("Ordinal")));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static IMmsReservationStatus getReservationStatusById (int reservationStatusId) {
        if (reservationStatuses == null)
            getReservationStatusFromDb();
        
        return reservationStatuses.get(reservationStatusId);
    }
}
