/**
 * 
 */
package com.lucasian.cargueadministradoras.modelo.control;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.lucasian.cargueadministradoras.modelo.dto.ErrorCargaDTO;

/**
 * @author DPAREJA
 *
 */
public interface IInformeLogic {
	public ByteArrayInputStream getInformeErroresCarga(List<ErrorCargaDTO> errores) throws Exception;
}
