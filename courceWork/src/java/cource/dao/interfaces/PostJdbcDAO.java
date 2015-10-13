/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.dao.interfaces;

import cource.entities.Post;
import cource.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
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
public class PostJdbcDAO extends JdbcDaoSupport implements PostDAO{

//    private DataSource dataSource;
//    private JdbcTemplate dbTpl;
//    
//    public PostJdbcDAO(DataSource ds){
//        dataSource = ds;
//        dbTpl = new JdbcTemplate(ds);
//    }
    
    
    @Override
    public Post create(Post p) {
        PreparedStatementCreator creator = new PreparedStatementCreator(){

            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement stat = conn.prepareStatement(
                        "insert into posts (userId , publishedDate , title , description) values (?, ?, ?, ?);"
                        ,new String[]{"id"});
                stat.setLong(1, p.getUserId());
                stat.setDate(2, p.getPublishedDate());
                stat.setString(3, p.getTheme());
                stat.setString(4, p.getDescription());
                return stat;
            }
            
            
        };
        KeyHolder kh = new GeneratedKeyHolder();
        getJdbcTemplate().update(creator , kh);
        p.setId((Long)kh.getKey());
        return p;
    }

    @Override
    public Post getById(Long id) {
        Post post;
        post = getJdbcTemplate().queryForObject("SELECT id ,userId ,publishedDate, title , description FROM posts WHERE id = ?;", 
                new Object[]{new Long(id)},new PostJdbcDAO.PostMapper());
        return post;
    }

    @Override
    public List<Post> getByAuthorId(Long authId) {
        List<Post> posts;
        posts = getJdbcTemplate().query("SELECT * FROM posts WHERE userId = ?;", 
                new Object[]{new Long(authId)},new PostJdbcDAO.PostMapper());
        return posts;
    }

    @Override
    public boolean update(Post p) {
        String sql = String.format("update `%s` set publishedDate = ?, title = ?, description = ? where id = ?",
                "posts");
        return getJdbcTemplate().update(sql, p.getPublishedDate() , p.getTheme() , p.getDescription() , p.getId()) > 0;
    }

    @Override
    public boolean delete(Long id) {
       String sql = String.format("delete from `%s` where id = ?", "posts");
       return getJdbcTemplate().update(sql, id) > 0;
    }

    @Override
    public List<Post> list(int limit) {
        return getJdbcTemplate().query(String.format("select * from %s limit %d","posts" ,limit)
                , new PostMapper());
    }
    
    class PostMapper implements RowMapper<Post>{

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post p = new Post(rs.getLong("id"));
            p.setUserId(rs.getLong("userId"));
            p.setPublishedDate(rs.getDate("publishedDate"));
            p.setTheme(rs.getString("title"));
            p.setDescription(rs.getString("description"));
            return p;
        }
        
    }
    
}
