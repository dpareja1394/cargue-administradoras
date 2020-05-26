package com.lucasian.cargueadministradoras.modelo.control;

import com.lucasian.cargueadministradoras.dataaccess.dao.*;
import com.lucasian.cargueadministradoras.exceptions.*;
import com.lucasian.cargueadministradoras.modelo.*;
import com.lucasian.cargueadministradoras.modelo.dto.AdministradoraDTO;
import com.lucasian.cargueadministradoras.modelo.dto.ErrorCargaDTO;
import com.lucasian.cargueadministradoras.utilities.Constantes;
import com.lucasian.cargueadministradoras.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Zathura Code Generator http://zathuracode.org www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("AdministradoraLogic")
public class AdministradoraLogic implements IAdministradoraLogic {
	private static final Logger log = LoggerFactory.getLogger(AdministradoraLogic.class);

	/**
	 * DAO injected by Spring that manages Administradora entities
	 *
	 */
	@Autowired
	private IAdministradoraDAO administradoraDAO;
	
	@Autowired
	private IInformeLogic informeLogic;

	@Transactional(readOnly = true)
	public List<Administradora> getAdministradora() throws Exception {
		log.debug("finding all Administradora instances");

		List<Administradora> list = new ArrayList<Administradora>();

		try {
			list = administradoraDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Administradora failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Administradora");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveAdministradora(Administradora entity) throws Exception {
		log.debug("saving Administradora instance");

		try {
			if (entity.getCodTpId() == null) {
				throw new ZMessManager().new EmptyFieldException("codTpId");
			}

			if ((entity.getCodTpId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodTpId(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException("codTpId");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getFsp() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFsp(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("fsp");
			}

			if ((entity.getFusionada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFusionada(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("fusionada");
			}

//            if (entity.getId() == null) {
//                throw new ZMessManager().new EmptyFieldException("id");
//            }

			if ((entity.getId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("id");
			}

			if ((entity.getMultipleArp() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMultipleArp(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("multipleArp");
			}

			if (entity.getNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("nombre");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 200) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getNroId() == null) {
				throw new ZMessManager().new EmptyFieldException("nroId");
			}

			if ((entity.getNroId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNroId(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("nroId");
			}

//            if (getAdministradora(entity.getId()) != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }

			administradoraDAO.save(entity);

			log.debug("save Administradora successful");
		} catch (Exception e) {
			log.error("save Administradora failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteAdministradora(Administradora entity) throws Exception {
		log.debug("deleting Administradora instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Administradora");
		}

		if (entity.getId() == null) {
			throw new ZMessManager().new EmptyFieldException("id");
		}

		try {
			administradoraDAO.delete(entity);

			log.debug("delete Administradora successful");
		} catch (Exception e) {
			log.error("delete Administradora failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateAdministradora(Administradora entity) throws Exception {
		log.debug("updating Administradora instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Administradora");
			}

			if (entity.getCodTpId() == null) {
				throw new ZMessManager().new EmptyFieldException("codTpId");
			}

			if ((entity.getCodTpId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodTpId(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException("codTpId");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getFsp() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFsp(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("fsp");
			}

			if ((entity.getFusionada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFusionada(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("fusionada");
			}

			if (entity.getId() == null) {
				throw new ZMessManager().new EmptyFieldException("id");
			}

			if ((entity.getId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getId(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("id");
			}

			if ((entity.getMultipleArp() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMultipleArp(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("multipleArp");
			}

			if (entity.getNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("nombre");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 200) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getNroId() == null) {
				throw new ZMessManager().new EmptyFieldException("nroId");
			}

			if ((entity.getNroId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNroId(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("nroId");
			}

			administradoraDAO.update(entity);

			log.debug("update Administradora successful");
		} catch (Exception e) {
			log.error("update Administradora failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<AdministradoraDTO> getDataAdministradora() throws Exception {
		try {
			List<Administradora> administradora = administradoraDAO.findAll();

			List<AdministradoraDTO> administradoraDTO = new ArrayList<AdministradoraDTO>();

			for (Administradora administradoraTmp : administradora) {
				AdministradoraDTO administradoraDTO2 = new AdministradoraDTO();

				administradoraDTO2.setId(administradoraTmp.getId());
				administradoraDTO2
						.setCodTpId((administradoraTmp.getCodTpId() != null) ? administradoraTmp.getCodTpId() : null);
				administradoraDTO2
						.setCodigo((administradoraTmp.getCodigo() != null) ? administradoraTmp.getCodigo() : null);
				administradoraDTO2.setFechaFusion(administradoraTmp.getFechaFusion());
				administradoraDTO2.setFsp((administradoraTmp.getFsp() != null) ? administradoraTmp.getFsp() : null);
				administradoraDTO2.setFusionada(
						(administradoraTmp.getFusionada() != null) ? administradoraTmp.getFusionada() : null);
				administradoraDTO2.setMultipleArp(
						(administradoraTmp.getMultipleArp() != null) ? administradoraTmp.getMultipleArp() : null);
				administradoraDTO2
						.setNombre((administradoraTmp.getNombre() != null) ? administradoraTmp.getNombre() : null);
				administradoraDTO2
						.setNroId((administradoraTmp.getNroId() != null) ? administradoraTmp.getNroId() : null);
				administradoraDTO.add(administradoraDTO2);
			}

			return administradoraDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Administradora getAdministradora(Long id) throws Exception {
		log.debug("getting Administradora instance");

		Administradora entity = null;

		try {
			entity = administradoraDAO.findById(id);
		} catch (Exception e) {
			log.error("get Administradora failed", e);
			throw new ZMessManager().new FindingException("Administradora");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Administradora> findPageAdministradora(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<Administradora> entity = null;

		try {
			entity = administradoraDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Administradora Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberAdministradora() throws Exception {
		Long entity = null;

		try {
			entity = administradoraDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Administradora Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles                 este arreglo debera tener:
	 *
	 *                                 [0] = String variable = (String) varibles[i];
	 *                                 representa como se llama la variable en el
	 *                                 pojo
	 *
	 *                                 [1] = Boolean booVariable = (Boolean)
	 *                                 varibles[i + 1]; representa si el valor
	 *                                 necesita o no ''(comillas simples)usado para
	 *                                 campos de tipo string
	 *
	 *                                 [2] = Object value = varibles[i + 2];
	 *                                 representa el valor que se va a buscar en la
	 *                                 BD
	 *
	 *                                 [3] = String comparator = (String) varibles[i
	 *                                 + 3]; representa que tipo de busqueda voy a
	 *                                 hacer.., ejemplo: where nombre=william o
	 *                                 where nombre<>william, en este campo iria el
	 *                                 tipo de comparador que quiero si es = o <>
	 *
	 *                                 Se itera de 4 en 4..., entonces 4 registros
	 *                                 del arreglo representan 1 busqueda en un
	 *                                 campo, si se ponen mas pues el continuara
	 *                                 buscando en lo que se le ingresen en los
	 *                                 otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                                 la diferencia son estas dos posiciones
	 *
	 *                                 [0] = String variable = (String) varibles[j];
	 *                                 la variable ne la BD que va a ser buscada en
	 *                                 un rango
	 *
	 *                                 [1] = Object value = varibles[j + 1]; valor 1
	 *                                 para buscar en un rango
	 *
	 *                                 [2] = Object value2 = varibles[j + 2]; valor
	 *                                 2 para buscar en un rango ejempolo: a > 1 and
	 *                                 a < 5 --> 1 seria value y 5 seria value2
	 *
	 *                                 [3] = String comparator1 = (String)
	 *                                 varibles[j + 3]; comparador 1 ejemplo: a
	 *                                 comparator1 1 and a < 5
	 *
	 *                                 [4] = String comparator2 = (String)
	 *                                 varibles[j + 4]; comparador 2 ejemplo: a
	 *                                 comparador1>1 and a comparador2<5 (el
	 *                                 original: a > 1 and a < 5) *
	 * @param variablesBetweenDates(en este caso solo para mysql) [0] = String
	 *                                 variable = (String) varibles[k]; el nombre de
	 *                                 la variable que hace referencia a una fecha
	 *
	 *                                 [1] = Object object1 = varibles[k + 2]; fecha
	 *                                 1 a comparar(deben ser dates)
	 *
	 *                                 [2] = Object object2 = varibles[k + 3]; fecha
	 *                                 2 a comparar(deben ser dates)
	 *
	 *                                 esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<Administradora> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<Administradora> list = new ArrayList<Administradora>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between \'" + value + "\' and \'" + value2 + "\')")
							: (tempWhere + " AND (model." + variable + " between \'" + value + "\' and \'" + value2
									+ "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = administradoraDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public ByteArrayInputStream cargarPlantillaAdministradoras(File archivoPlano) throws Exception {
		List<ErrorCargaDTO> listaErrores = new ArrayList<ErrorCargaDTO>();
		List<Administradora> administradoras = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			log.info("Ingresa al método cargarPlantillaAdministradoras");
			listaErrores = new ArrayList<ErrorCargaDTO>();
			administradoras = new ArrayList<Administradora>();
			if (archivoPlano == null) {
				ErrorCargaDTO errorCarga = new ErrorCargaDTO(0, "El archivo plano no puede ser nulo");
				listaErrores.add(errorCarga);
			} else {
				administradoras = new ArrayList<Administradora>();
				fileReader = new FileReader(archivoPlano);
				bufferedReader = new BufferedReader(fileReader);

				String linea = "";
				Integer contadorLinea = 1;
				while ((linea = bufferedReader.readLine()) != null) {
					if (linea.split(";").length != 9) {
						ErrorCargaDTO errrCargaDTO = new ErrorCargaDTO(contadorLinea,
								"La línea solo contiene " + linea.split(";").length + " campos.");
						listaErrores.add(errrCargaDTO);
					} else {
						Administradora administradora = null;
						String codigo = linea.split(";")[0].trim();
						String nombre = linea.split(";")[1].trim();
						String tipoIdentificacion = linea.split(";")[2].trim();
						String numeroIdentificacion = linea.split(";")[3].trim();
						String naturaleza = linea.split(";")[4].trim();
						String multipleArp = linea.split(";")[5].trim();
						String fsp = linea.split(";")[6].trim();
						String fusionada = linea.split(";")[7].trim();
						String fechaFusion = linea.split(";")[8].trim();

						String mensajeError = validarAdministradora(contadorLinea, codigo, nombre, tipoIdentificacion,
								numeroIdentificacion, naturaleza, multipleArp, fsp, fusionada, fechaFusion);
						if(mensajeError.trim().equals("")) {
							administradora = mapearAdministradora(codigo, nombre, tipoIdentificacion,
								numeroIdentificacion, naturaleza, multipleArp, fsp, fusionada, fechaFusion);
						}else {
							ErrorCargaDTO errorCargaDTO = new ErrorCargaDTO(contadorLinea, mensajeError);
							listaErrores.add(errorCargaDTO);
						}
						if(administradora != null && listaErrores.isEmpty()){
							administradoras.add(administradora);
						}
					}
					contadorLinea++;
				}

			}
			
			if(!listaErrores.isEmpty()) {
				return informeLogic.getInformeErroresCarga(listaErrores);
			}else {
				for(Administradora administradora : administradoras) {
					saveAdministradora(administradora);
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			listaErrores.add(new ErrorCargaDTO(0, e.getMessage()));
		} finally {
			bufferedReader.close();
			fileReader.close();
		}
		return null;
	}

	private Administradora mapearAdministradora(String codigo, String nombre, String tipoIdentificacion,
			String numeroIdentificacion, String naturaleza, String multipleArp, String fsp, String fusionada,
			String fechaFusion) throws Exception {
		Administradora administradora = null;
		try {
			administradora = new Administradora();
			administradora.setCodigo(codigo.trim());
			administradora.setNombre(nombre.trim());
			administradora.setCodTpId(tipoIdentificacion.trim());
			administradora.setNroId(numeroIdentificacion.trim());
			administradora.setNaturaleza(getMapNaturaleza().get(naturaleza));
			administradora.setMultipleArp(multipleArp.equalsIgnoreCase("X")?1L:0L);
			administradora.setFsp(fsp.equalsIgnoreCase("X")?1L:0L);
			administradora.setFusionada(fusionada.equalsIgnoreCase("X")?1L:0L);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
			
			administradora.setFechaFusion(fusionada.equalsIgnoreCase("X")?simpleDateFormat.parse(fechaFusion):null);
			
		} catch (Exception e) {
			throw e;
		}
		return administradora;
	}

	private String validarAdministradora(Integer contadorLinea, String codigo, String nombre, String tipoIdentificacion,
			String numeroIdentificacion, String naturaleza, String multipleArp, String fsp, String fusionada,
			String fechaFusion) {
		String mensaje = "";
		try {
//			Pattern pattern = Pattern.compile("[a-z][A-Z][1-9]");
//			Pattern pattern = Pattern.compile("(\\w)");

			// Validación Código
			if (codigo == null || codigo.trim().equals("")) {
				mensaje += "El código es requerido. ";
			} else {
//				Matcher matcher = pattern.matcher(codigo.trim());
				if (Pattern.matches("\\P{Alnum}", codigo.trim())) {
					mensaje += "El código sólo puede contener caracteres alfanuméricos. ";
				}
			}

			// Validación Nombre
			if (nombre == null || nombre.trim().equals("")) {
				mensaje += "El nombre es requerido. ";
			} else {
//				Matcher matcher = pattern.matcher(nombre.trim());
				if (Pattern.matches("^[a-zA-Z0-9]*$", nombre.trim())) {
					mensaje += "El nombre sólo puede contener caracteres alfanuméricos. ";
				}
			}

			// Validación Tipo Identificación
			if (tipoIdentificacion == null || tipoIdentificacion.trim().equals("")) {
				mensaje += "El Tipo de Identificación es requerido. ";
			} else {
				if (!existeCodigo(tipoIdentificacion, Constantes.TIPOS_IDENTIFICACION)) {
					mensaje += "El tipo de identificación " + tipoIdentificacion + " no existe. ";
				}
			}

			// Validación Número de Identificación
			if (numeroIdentificacion == null || numeroIdentificacion.trim().equals("")) {
				mensaje += "El número de identificación es requerido. ";
			} else {
				try {
					Long numero = Long.parseLong(numeroIdentificacion);
				} catch (Exception e) {
					mensaje += "El número de identificación debe contener caracteres numéricos. ";
				}
			}

			// Validar Naturaleza
			if (naturaleza == null || naturaleza.trim().equals("")) {
				mensaje += "La naturaleza es requerida. ";
			} else {
				if (!getMapNaturaleza().containsKey(naturaleza)) {
					mensaje += "La naturaleza " + naturaleza + " no existe. ";
				}
			}

			// Validar Múltiple ARP
			if (!(multipleArp.equals("") || multipleArp.equalsIgnoreCase("X"))) {
				mensaje += "El campo Múltiple ARP debe ser marcado con una X o dejarlo vacío. ";
			}

			// Validar Fusionada
			if (!(fusionada.equals("") || fusionada.equalsIgnoreCase("X"))) {
				mensaje += "El campo Fusionada debe ser marcado con una X o dejarlo vacío. ";
			}

			//Si la administradora está fusionada, entonces validar la fecha de fusión 
			if (fusionada.equalsIgnoreCase("X")) {
				try {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
					Date fechaFusionDate = simpleDateFormat.parse(fechaFusion);
				} catch (Exception e) {
					mensaje += "Fecha fusión debe estar en formato DDMMAAAA. ";
				}
			}

		} catch (Exception e) {

		}
		return mensaje;
	}

	public boolean existeCodigo(String codigo, String[] arregloCodigos) {
		for (String string : arregloCodigos) {
			if (string.trim().equalsIgnoreCase(codigo)) {
				return true;
			}
		}
		return false;
	}
	
	public Map<String, String> getMapNaturaleza(){
		Map<String, String> naturalezasMap = new HashMap<String, String>();
		naturalezasMap.put("PR", "PRIVADA");
		naturalezasMap.put("PU", "PÚBLICA");
		naturalezasMap.put("MI", "MIXTA");
		return naturalezasMap;
	}

}
