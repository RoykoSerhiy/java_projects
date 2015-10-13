/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.dao.interfaces;

import cource.entities.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Serhiy
 */
public interface UserDAO {
    public User create(User u);
    public User readById(Long id);
    public User checkByLoginAndPassword(String login , String password);
    public boolean update(User user);
    public boolean delete(int id);
    public Map<Long , User> getUsers(List<Long> ids);
    public List<User> list();
}
