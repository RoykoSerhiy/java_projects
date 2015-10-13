/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.User;

/**
 *
 * @author Serhiy
 */
public interface UserDAO {
    public User craete(User user);
    public User readByID(Long id);
    public int update(User user);
    public int delete(int id);
    public List<User> list();
}
