/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makemystay;
import java.util.*;

/**
 *
 * @author owner
 */
public interface IMmsProperty {
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
