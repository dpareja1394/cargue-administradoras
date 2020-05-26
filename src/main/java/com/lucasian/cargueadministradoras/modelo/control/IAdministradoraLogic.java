package com.lucasian.cargueadministradoras.modelo.control;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import com.lucasian.cargueadministradoras.modelo.Administradora;
import com.lucasian.cargueadministradoras.modelo.dto.AdministradoraDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IAdministradoraLogic {
    public List<Administradora> getAdministradora() throws Exception;

    /**
         * Save an new Administradora entity
         */
    public void saveAdministradora(Administradora entity)
        throws Exception;

    /**
         * Delete an existing Administradora entity
         *
         */
    public void deleteAdministradora(Administradora entity)
        throws Exception;

    /**
        * Update an existing Administradora entity
        *
        */
    public void updateAdministradora(Administradora entity)
        throws Exception;

    /**
         * Load an existing Administradora entity
         *
         */
    public Administradora getAdministradora(Long id) throws Exception;

    public List<Administradora> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Administradora> findPageAdministradora(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAdministradora() throws Exception;

    public List<AdministradoraDTO> getDataAdministradora()
        throws Exception;
    
    public ByteArrayInputStream cargarPlantillaAdministradoras(File archivoPlano) throws Exception;
}
