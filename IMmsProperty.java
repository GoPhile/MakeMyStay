package makemystay;
import java.util.*;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 1
 */
public interface IMmsProperty {
    public int getPropertyId();
    public IMmsUser getOwner();
    public List<IMmsUser> getDelegates();
    public String getPropertyName ();
    public String getPropertyDescription ();
    public String getLocaleDescription ();
    public String getStreetAddress ();
    public String getCity ();
    public String getState ();
    public String getPostCode ();
    public String getTelephone ();
    public List<IMmsRoom> getRooms();
}
