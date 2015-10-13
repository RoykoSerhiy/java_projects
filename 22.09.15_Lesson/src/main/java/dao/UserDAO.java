/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Serhiy
 */
public interface UserDAO {
    public void addUser(User u) throws SQLException;   
    public void updateUser(User u) throws SQLException;
    public void deleteUser(User u) throws SQLException;
    
    public List<User> getUsersByNameTplAndId(String tpl , Integer id);
    
    
}
