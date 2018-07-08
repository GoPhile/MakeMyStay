/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makemystay;

/**
 *
 * @author owner
 */
public class MmsReservationStatus implements IMmsReservationStatus {
    private int reservationStatusId;
    private String description;
    private int ordinal;
    
    public MmsReservationStatus (int reservationStatusId, String description, int ordinal) {
        this.reservationStatusId = reservationStatusId;
        this.description = description;
        this.ordinal = ordinal;
    }
    
    @Override
    public int getReservationStatusId() {
        return reservationStatusId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getOrdinal() {
        return ordinal;
    }
    
}
