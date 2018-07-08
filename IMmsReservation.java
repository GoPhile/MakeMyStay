/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makemystay;
import java.util.Date;

/**
 *
 * @author owner
 */
public interface IMmsReservation {
    public IMmsUser getCustomer();
    public IMmsRoom getRoom();
    public IMmsReservationStatus getReservationStatus();
    public Date getStartDateTime();
    public Date getEndDateTime();
    public void setReservationStatus(IMmsReservationStatus newStatus);
}
