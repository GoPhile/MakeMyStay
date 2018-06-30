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
