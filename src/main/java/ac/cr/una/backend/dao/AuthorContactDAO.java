/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

/**
 *
 * @author Josue
 */
public interface AuthorContactDAO {
    
 
    public List<AuthorContact> findAll();
    public AuthorContact save(AuthorContact authorContact);
    public boolean deleteAll();
    
}
