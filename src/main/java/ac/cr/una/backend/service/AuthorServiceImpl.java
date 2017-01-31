/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.model.Author;
import java.util.List;

/**
 *
 * @author Josue
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO dao;

    public AuthorServiceImpl() {
    }

    public AuthorServiceImpl(AuthorDAO dao) {
        this.dao = dao;
    }

    public AuthorDAO getDao() {
        return dao;
    }

    public void setDao(AuthorDAO dao) {
        this.dao = dao;
    }
    

    @Override
    public Author findByName(String name) {
        return dao.findByName(name);
    }

        @Override
    public List<Author> findAll() {
        return dao.findAll();
    }
}
