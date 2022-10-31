
package models;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Role implements Serializable {
   
    private int roleID;
    private String roleType;

    public Role() {
    }

    public Role(int roleID, String roleType) {
        this.roleID = roleID;
        this.roleType = roleType;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    
    
}
