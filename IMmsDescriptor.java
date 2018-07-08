package makemystay;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 1
 * 
 * The purpose of this class is to simply add these descriptors to a list
 * that might accompany a property listing so that rooms can be given these
 * these descriptors
 * 
 */

public interface IMmsDescriptor {
    public int getDescriptorId();
    public String getDescriptor();
    public int getOrdinal();
}
