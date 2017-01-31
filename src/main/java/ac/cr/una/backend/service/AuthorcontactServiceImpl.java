package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.List;

public class AuthorcontactServiceImpl implements AuthorContactService {

    private AuthorContactDAO authorContacDAO;
    private AuthorDAO authorDAO;

    public AuthorcontactServiceImpl() {
    }

    public AuthorcontactServiceImpl(AuthorContactDAO authorContacDAO, AuthorDAO authorDAO) {
        this.authorContacDAO = authorContacDAO;
        this.authorDAO = authorDAO;
    }

    public AuthorContactDAO getAuthorContacDAO() {
        return authorContacDAO;
    }

    public void setAuthorContacDAO(AuthorContactDAO authorContacDAO) {
        this.authorContacDAO = authorContacDAO;
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public List<AuthorContact> findAll() {
        return authorContacDAO.findAll();
    }

    @Override
    public AuthorContact save(AuthorContact authorContact) {
        return authorContacDAO.save(authorContact);
    }

    @Override
    public boolean deleteAll() {
        return authorContacDAO.deleteAll();

    }

    @Override
    public Author findByName(String name) {
        return authorDAO.findByName(name);
    }

}
