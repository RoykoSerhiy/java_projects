/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.dao.interfaces;

import cource.entities.Comment;
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
public class CommentJdbcDAO extends JdbcDaoSupport implements CommentDAO{

//     private DataSource dataSource;
//     private JdbcTemplate dbTpl;
//    
//    public CommentJdbcDAO(DataSource ds){
//        dataSource = ds;
//        dbTpl = new JdbcTemplate(ds);
//    }
    
    
    @Override
    public Comment create(Comment c) {
        PreparedStatementCreator creator = new PreparedStatementCreator(){

            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement stat = conn.prepareStatement(
                "insert into `comments` (authorId , postId , date , description) values (?, ?, ?, ?);"
                , new String[]{"id"});
                stat.setLong(1, c.getAuthorId());
                stat.setLong(2, c.getPostId());
                stat.setDate(3, c.getDate());
                stat.setString(4, c.getDescription());
                return stat;
            }
            
        };
        KeyHolder kh = new GeneratedKeyHolder();
        getJdbcTemplate().update(creator, kh);
        c.setId((Long)kh.getKey());
        return c;
    }

    @Override
    public Comment getById(Long id) {
        Comment c;
        
        c = getJdbcTemplate().queryForObject("SELECT id ,authorId , postId ,date ,description FROM posts WHERE id = ?;", 
                new Object[]{new Long(id)},new CommentJdbcDAO.CommentMapper());
        return c;
    }

    @Override
    public List<Comment> getByAuthorId(Long authId) {
        List<Comment> c;
        
        c = getJdbcTemplate().query("SELECT id ,authorId , postId ,date ,description FROM posts WHERE authorId = ?;", 
                new Object[]{new Long(authId)},new CommentJdbcDAO.CommentMapper());
        return c;
    }

    @Override
    public Comment getByPostId(Long postId) {
        Comment c;
        
        c = getJdbcTemplate().queryForObject("SELECT id ,authorId , postId ,date ,description FROM posts WHERE postId = ?;", 
                new Object[]{new Long(postId)},new CommentJdbcDAO.CommentMapper());
        return c;
    }

    @Override
    public List<Comment> list(Long postId) {
        return getJdbcTemplate().query(String.format("select * from `%s` where postId = ? order by `%s`;","comments" , "date")
                ,new Object[]{new Long(postId)}, new CommentJdbcDAO.CommentMapper());
    }

    @Override
    public int delete(int post_id) {
         String sql = String.format("delete from `%s` where postId = ?", "comments");
        return getJdbcTemplate().update(sql, post_id);
    }
    
     class CommentMapper implements RowMapper<Comment>{

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            Comment c = new Comment(rs.getLong("id"));
            c.setAuthorId(rs.getLong("authorId"));
            c.setPostId(rs.getLong("postId"));
            c.setDate(rs.getDate("date"));
            c.setDescription(rs.getString("description"));
            return c;
        }
     
     }
    
}
