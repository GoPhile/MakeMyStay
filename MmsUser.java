package makemystay;
import java.util.*;
/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 1
 * Version: 2
 *  JS: Made all variables final; updated @Override notation
 * Version: 3
 *  JS: Created a parameterized constructor for all-at-once object creation
 * Updated: 7/7/2018
 *
 */
public class MmsUser implements IMmsUser {
    private final int userId;
    private final String username;
    private final String password;
    private final String email;
    private final String lastName;
    private final String firstName;
    
    public MmsUser (int userId, String username, String password,
            String email, String lastName, String firstName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    @Override
    public int getUserId() {
        return userId;
    }
    
    @Override 
    public String getUsername() {
        return username;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public String getEmail() {
        return email;
    }
    
    @Override
    public String getLastName() {
        return lastName;
    }
    
    @Override
    public String getFirstName() {
        return firstName;
    }
    
    @Override
    public boolean isPropertyOwner() {
        return MmsUserManager.isPropertyOwner(userId);
    }
    
    @Override
    public boolean isAssignedAsDelegate() {
        List<IMmsProperty> myDelegations = this.getPropertiesAsDelegate();
        return !myDelegations.isEmpty();
    }
    
    public List<IMmsProperty> getPropertiesAsDelegate() {
        return MmsUserManager.getPropertiesAsDelegate(this);
    }
}
