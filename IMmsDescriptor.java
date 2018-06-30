/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makemystay;

/**
 *
 * @author Josh Seaton
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
