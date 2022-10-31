
package services;

import dataaccess.UserDB;
import java.util.ArrayList;
import models.User;

/**
 *
 * @author user
 */
public class UserService {
    
    
    public ArrayList<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        ArrayList<User> users = userDB.getAll();
        return users;
    }
    
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    } 
    
     public void insert(String email, String firstName, String lastName, String password, int role) throws Exception {
       User user = new User(email, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);  
    }
    
    public void update(String email, String firstName, String lastName, String password, int role) throws Exception {
       User user = new User(email, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.update(user);  
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);

    }

    public void insert(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
