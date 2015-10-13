/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cource.dao.interfaces;

import cource.entities.Post;
import java.util.List;

/**
 *
 * @author Serhiy
 */
public interface PostDAO {
    public Post create(Post p);
    public Post getById(Long id);
    public List<Post> getByAuthorId(Long authId);
    public boolean update(Post p);
    public boolean delete(Long id);
    
    public List<Post> list(int limit);
}
