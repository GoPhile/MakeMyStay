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
public class MmsUser implements IMmsUser {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String lastName;
    private String firstName;
    
    public void setUserId (int userId) {
        this.userId = userId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUsername (String username) {
        this.username = username;
    }
        
    public String getUsername() {
        return username;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public boolean isPropertyOwner() {
        return MmsUserManager.isPropertyOwner(userId);
    }
    
    public boolean isAssignedAsDelegate() {
        return false;  // This line is a place holder
    }
}
