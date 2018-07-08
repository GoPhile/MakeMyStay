package makemystay;

/**
 *
 * @author Josh Seaton
 * Created: 6/28/2018
 * Version: 1
 */
public interface IMmsRoom {
    public int getRoomId();
    public IMmsProperty getProperty();
    public String getDesignation();
    public String getDescription();
    public boolean hasQualityDescriptor();
    public String getQualityDescriptor();
}
