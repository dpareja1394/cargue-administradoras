package com.lucasian.cargueadministradoras.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class AdministradoraDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AdministradoraDTO.class);
    private String codTpId;
    private String codigo;
    private Date fechaFusion;
    private Long fsp;
    private Long fusionada;
    private Long id;
    private Long multipleArp;
    private String nombre;
    private String nroId;
    private String naturaleza;

    public String getCodTpId() {
        return codTpId;
    }

    public void setCodTpId(String codTpId) {
        this.codTpId = codTpId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaFusion() {
        return fechaFusion;
    }

    public void setFechaFusion(Date fechaFusion) {
        this.fechaFusion = fechaFusion;
    }

    public Long getFsp() {
        return fsp;
    }

    public void setFsp(Long fsp) {
        this.fsp = fsp;
    }

    public Long getFusionada() {
        return fusionada;
    }

    public void setFusionada(Long fusionada) {
        this.fusionada = fusionada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMultipleArp() {
        return multipleArp;
    }

    public void setMultipleArp(Long multipleArp) {
        this.multipleArp = multipleArp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroId() {
        return nroId;
    }

    public void setNroId(String nroId) {
        this.nroId = nroId;
    }
    
    public String getNaturaleza() {
    	return naturaleza;
    }
    
    public void setNaturaleza(String naturaleza) {
    	this.naturaleza = naturaleza;
    }
}
