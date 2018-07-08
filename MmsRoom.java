/*
 * The setters in this class are only for setting the values of the
 * encapsulated variables. They are not to be used and cannot be used
 * to make changes to the underlying database table(s).
 */
package makemystay;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version 1
 */
public class MmsRoom implements IMmsRoom {
    
    private int roomId;
    private int propertyId;
    private String designation;
    private String description;
    
    public int getRoomId() {
        return roomId;
    }
    
    public void setRoomId (int roomId) {
        this.roomId = roomId;
    }

    public IMmsProperty getProperty() {
        return MmsPropertyManager.getProperty(propertyId);
    }
    
    public void setProperty(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation (String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription (String description) {
        this.description = description;
    }

    public boolean hasQualityDescriptor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getQualityDescriptor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
