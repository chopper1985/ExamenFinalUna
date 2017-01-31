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

import ac.cr.una.backend.model.Consultorio;
import java.util.List;

/**
 *
 * @author mguzmana
 */
public interface ConsultorioService {

    public List<Consultorio> findByName(String text);
    public List<Consultorio> findAll();
    public Consultorio save(Consultorio consul);
    public Consultorio update(Consultorio consul);
    public boolean delete(int id);
}
