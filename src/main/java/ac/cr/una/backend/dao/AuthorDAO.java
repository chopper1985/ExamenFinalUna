/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;
import java.util.List;

/**
 *
 * @author Josue
 */
public interface AuthorDAO {
    public Author findByName (String name);
    public List<Author> findAll();
    
}
