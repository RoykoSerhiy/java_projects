/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.dao.interfaces;


import cource.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.codec.digest.Sha2Crypt;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author Serhiy
 */
public class UserJdbcDAO extends JdbcDaoSupport implements UserDAO{

//   private DataSource dataSource;
    //private JdbcTemplate dbTpl;
//    
//    public UserJdbcDAO(DataSource ds){
//        dataSource = ds;
//        dbTpl = new JdbcTemplate(ds);
//    }
    
    
    @Override
    public User create(User u) {
        //System.out.println(u);
        PreparedStatementCreator creator = new PreparedStatementCreator(){
            
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement stat = conn.prepareStatement(
                        "INSERT INTO users (login  , pass , name , surname , email) VALUE (?, ?, ?, ?, ?);",
                        new String[]{"id"});
                stat.setString(1, u.getLogin());
                stat.setString(2, hash(u.getPass()));
                stat.setString(3, u.getName());
                stat.setString(4, u.getSurname());
                stat.setString(5, u.getEmail());
                return stat;
            }
            

        };
        KeyHolder kh = new GeneratedKeyHolder();
        getJdbcTemplate().update(creator, kh);
        u.setId((Long)kh.getKey());
        return u;
    }

    @Override
    public User readById(Long id) {
        User user;
        user = getJdbcTemplate().queryForObject("SELECT id ,login , pass , name, surname,email FROM users WHERE id = ?;", 
                new Object[]{new Long(id)},new UserMapper());
        return user;
    }

    @Override
    public User checkByLoginAndPassword(String login, String password) {
       final String sql = String.format("select * from `%s` where login = ? AND pass = ? ;", "users");
		List<User> res = getJdbcTemplate().query(sql, new UserMapper(), login, hash(password));
		if(res.isEmpty())
			return null;
		return res.get(0);
    }

    @Override
    public boolean update(User user) {
        return getJdbcTemplate().update(String.format("update `%s` set "
				+ "login = ?, pass = ?, name = ?, surname = ?, email = ? "
				+ "where id = ?", "users"), 
				user.getLogin(), hash(user.getPass()), user.getName(), user.getSurname() , user.getEmail() , user.getId())
				> 0;
    }

    @Override
    public boolean delete(int id) {
        final String sql = String.format("delete from `%s` where id = ?", "users");
        int res = getJdbcTemplate().update(sql , id);
        if(res <= 0)
        {
            return false;
        }
        return true;
    }

    @Override
    public List<User> list() {
        return getJdbcTemplate().query(
                "select * from `users` order by `id`", new UserMapper());
    }
    // must be modified
    public String hash(String pass){
        return Sha2Crypt.sha512Crypt(pass.getBytes(),"$6$round=7000$123abcZqwerty");
    }

    @Override
    public Map<Long, User> getUsers(List<Long> ids) {
        Map<Long , User> users = new HashMap<>();
            for (Long id : ids) {
            users.put(id , getJdbcTemplate().queryForObject("SELECT id ,login , pass , name, surname,email FROM users WHERE id = ?;", new Object[]{new Long(id)},new UserMapper()));
            }
            return users;
    }

    
    
    class UserMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet rs , int i) throws SQLException{
            User u = new User(rs.getLong("id"));
            u.setLogin(rs.getString("login"));
            u.setPass(rs.getString("pass"));
            u.setName(rs.getString("name"));
            u.setSurname(rs.getString("surname"));
            u.setEmail(rs.getString("email"));
            return u;
        }
    }
}
