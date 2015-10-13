/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author Serhiy
 */
public class UserJdbsDao implements UserDAO{
    private DataSource dataSource;
    private JdbcTemplate dbTpl;
    
    public UserJdbsDao(DataSource ds){
        dataSource = ds;
        dbTpl = new JdbcTemplate(ds);
    }
    
    

    @Override
    public User craete(User user) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement stat = conn.prepareStatement(
                        "INSERT INTO users (name  , login , email , pass) VALUE (?, ?, ?, ?);",
                        new String[]{"id"});
                stat.setString(1, user.getName());
                stat.setString(2, user.getLogin());
                stat.setString(3, user.getEmail());
                stat.setString(4, user.getPass());
                return stat;
            }
        };
        KeyHolder kh = new GeneratedKeyHolder();
        dbTpl.update(creator, kh);
        user.setId((Long)kh.getKey());
        return user;
    }

    @Override
    public User readByID(Long id) {
        User user;
        user = dbTpl.queryForObject("SELECT id , name , login , email , pass FROM users WHERE id = ?;", 
                new Object[]{new Long(id)},new UserMapper());
        return user;
    }

    @Override
    public int update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    class UserMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet rs , int i) throws SQLException{
            User u = new User(rs.getLong("id"));
            u.setName(rs.getString("name"));
            u.setLogin(rs.getString("login"));
            u.setEmail(rs.getString("email"));
            u.setPass(rs.getString("pass"));
            return u;
        }
    }
}
