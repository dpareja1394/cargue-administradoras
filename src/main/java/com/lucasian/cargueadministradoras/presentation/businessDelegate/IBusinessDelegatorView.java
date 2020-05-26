package com.lucasian.cargueadministradoras.presentation.businessDelegate;

import com.lucasian.cargueadministradoras.modelo.Administradora;
import com.lucasian.cargueadministradoras.modelo.control.AdministradoraLogic;
import com.lucasian.cargueadministradoras.modelo.control.IAdministradoraLogic;
import com.lucasian.cargueadministradoras.modelo.dto.AdministradoraDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Administradora> getAdministradora() throws Exception;

    public void saveAdministradora(Administradora entity)
        throws Exception;

    public void deleteAdministradora(Administradora entity)
        throws Exception;

    public void updateAdministradora(Administradora entity)
        throws Exception;

    public Administradora getAdministradora(Long id) throws Exception;

    public List<Administradora> findByCriteriaInAdministradora(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Administradora> findPageAdministradora(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAdministradora() throws Exception;

    public List<AdministradoraDTO> getDataAdministradora()
        throws Exception;
    
    public ByteArrayInputStream cargarPlantillaAdministradoras(File archivoPlano) throws Exception;
}
