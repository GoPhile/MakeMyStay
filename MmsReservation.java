/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makemystay;

import java.util.Date;

/**
 *
 * @author Josh Seaton
 */
public class MmsReservation implements IMmsReservation {
    private final int customerId;
    private final int roomId;
    private final int reservationStatusId;
    private final Date startDateTime;
    private final Date endDateTime;
    
    public MmsReservation (int customerId, int roomId,
            int reservationStatusId, Date startDateTime, Date endDateTime) {
        this.customerId = customerId;
        this.roomId = roomId;
        this.reservationStatusId = reservationStatusId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
    
    @Override
    public IMmsUser getCustomer() {
        return MmsUserManager.getUser(customerId);
    }

    @Override
    public IMmsRoom getRoom() {
        return MmsRoomManager.getRoom(roomId);
    }

    @Override
    public IMmsReservationStatus getReservationStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getStartDateTime() {
        return startDateTime;
    }

    @Override
    public Date getEndDateTime() {
        return endDateTime;
    }

    @Override
    public void setReservationStatus(IMmsReservationStatus newStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
