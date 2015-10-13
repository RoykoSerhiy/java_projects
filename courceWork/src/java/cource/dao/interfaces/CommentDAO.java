/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.dao.interfaces;

import cource.entities.Comment;
import java.util.List;

/**
 *
 * @author Serhiy
 */
public interface CommentDAO {
    public Comment create(Comment c);
    public Comment getById(Long id);
    public List<Comment> getByAuthorId(Long authId);
    public Comment getByPostId(Long postId);
    public int delete(int post_id);
    //public int update(Comment c);
    //public int delete(Long id);
    public List<Comment> list(Long postId);
}
