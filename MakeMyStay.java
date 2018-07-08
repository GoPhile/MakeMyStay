package makemystay;
import java.util.*;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 2
 */
public class MakeMyStay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<IMmsUser> userList = MmsUserManager.getUsers();
        for (IMmsUser user : userList) {
            System.out.println(user.getUsername());
            System.out.println("   Property Owner: " + user.isPropertyOwner());
            System.out.println(user.isAssignedAsDelegate());
            System.out.println(MmsUserManager.addNewUser("HotelMogul", "test", "Smith", "Johnny", "test@test.gov") == null);
        }
        MmsDb.closeConnection();
    }
}
