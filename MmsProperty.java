package makemystay;

import java.util.List;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version 1
 * Version: 2
 * Updated: 7/7/2018
 *  JS: Made all variables final; added @Override notation
 */
public class MmsProperty implements IMmsProperty {
    private final int propertyId;
    private final int owner;
    private final String propertyName;
    private final String propertyDescription;
    private final String localeDescription;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String postCode;
    private final String telephone;
    
    public MmsProperty(int propertyId, int owner, String propertyName,
            String propertyDescription, String localeDescription,
            String streetAddress, String city, String state, String postCode,
            String telephone) {
        this.propertyId = propertyId;
        this.owner = owner;
        this.propertyName = propertyName;
        this.propertyDescription = propertyDescription;
        this.localeDescription = localeDescription;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.telephone = telephone;
    }
    
    @Override
    public int getPropertyId() {
        return propertyId;
    }
    
    @Override
    public IMmsUser getOwner() {
        return MmsUserManager.getUser(owner);
    }

    @Override
    public List<IMmsUser> getDelegates() {
        return MmsPropertyManager.getDelegatesOfProperty(this);
    }
    
    @Override
    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public String getPropertyDescription() {
        return propertyDescription;
    }

    @Override
    public String getLocaleDescription() {
        return localeDescription;
    }

    @Override
    public String getStreetAddress() {
        return streetAddress;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getPostCode() {
        return postCode;
    }

    @Override
    public String getTelephone() {
        return telephone;
    }

    @Override
    public List<IMmsRoom> getRooms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
