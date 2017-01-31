/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Consultorio;
import java.util.List;
/**
 *
 * @author Josue
 */
public interface ConsultorioDAO {

    public List<Consultorio> findByName(String text);
    public List<Consultorio> findAll();
    public Consultorio save(Consultorio consul);
    public Consultorio update(Consultorio consul);
    public boolean delete(int id);

}
