package makemystay;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 1
 */
public interface IMmsUser {
    public int getUserId();
    public String getUsername();
    public String getPassword();
    public String getEmail();
    public String getLastName();
    public String getFirstName();
    public boolean isPropertyOwner();
    public boolean isAssignedAsDelegate();
}
