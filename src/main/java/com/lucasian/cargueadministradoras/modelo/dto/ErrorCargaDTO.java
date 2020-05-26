package com.lucasian.cargueadministradoras.modelo.dto;

public class ErrorCargaDTO {
	private Integer fila;
	private String error;
	
	public ErrorCargaDTO() {
		super();
	}
	
	public ErrorCargaDTO(Integer fila, String error) {
		super();
		this.fila = fila;
		this.error = error;
	}
	
	/**
	 * @return the fila
	 */
	public Integer getFila() {
		return fila;
	}
	/**
	 * @param fila the fila to set
	 */
	public void setFila(Integer fila) {
		this.fila = fila;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
}
