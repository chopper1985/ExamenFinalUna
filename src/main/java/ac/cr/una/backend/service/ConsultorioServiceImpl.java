/*
 * Copyright (C) 2016 mguzmana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.ConsultorioDAO;
import ac.cr.una.backend.model.Consultorio;
import java.util.List;

/**
 *
 * @author mguzmana
 */
public class ConsultorioServiceImpl implements ConsultorioService {

    private ConsultorioDAO dao;

    public ConsultorioServiceImpl() {
    }

    public ConsultorioServiceImpl(ConsultorioDAO dao) {
        this.dao = dao;
    }

    public ConsultorioDAO getDao() {
        return dao;
    }

    public void setDao(ConsultorioDAO dao) {
        this.dao = dao;
    }

    
    @Override
    public List<Consultorio> findByName(String text) {
        return dao.findByName(text);
    }

    @Override
    public List<Consultorio> findAll() {
        return dao.findAll();
    }

    @Override
    public Consultorio save(Consultorio consul) {
        return dao.save(consul);
    }

    @Override
    public Consultorio update(Consultorio consul) {
        return dao.update(consul);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

}
