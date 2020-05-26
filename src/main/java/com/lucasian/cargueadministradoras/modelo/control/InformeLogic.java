/**
 * 
 */
package com.lucasian.cargueadministradoras.modelo.control;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasian.cargueadministradoras.modelo.dto.ErrorCargaDTO;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 * @author DPAREJA
 *
 */
@Scope("singleton")
@Service("InformeLogic")
public class InformeLogic implements IInformeLogic {

	private static final Logger log = LoggerFactory.getLogger(InformeLogic.class);
	
	@Override
	@Transactional(readOnly=true)
	public ByteArrayInputStream getInformeErroresCarga(List<ErrorCargaDTO> errores) throws Exception {
		ByteArrayInputStream informe = null;
		InputStream inputStream = null;
		ByteArrayOutputStream bos = null;
		try {
			Map<String, Object> dataInit = initReport("ReporteErrores.jasper");
			inputStream = (InputStream) dataInit.get("input");
			Map<String, Object> params = (Map<String, Object>) dataInit.get("params");
			bos = new ByteArrayOutputStream();
			
			JasperPrint print = JasperFillManager.fillReport(inputStream, params,
					new JRBeanCollectionDataSource(errores));
			
			// Se exporta el reporte a PDF
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(bos));
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);

			exporter.exportReport();
			
			ByteArrayInputStream is = new ByteArrayInputStream(bos.toByteArray());
			
			informe = is != null ? is : null; 
			is.close();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}finally {
			inputStream.close();
			bos.close();
			informe.close();
		}
		return informe;
	}
	
	@Transactional(readOnly = true)
	public Map<String, Object> initReport(String report) throws Exception {
		InputStream inputStream = null;
		Map<String, Object> data = null;
		try {
			// SE CONSULTA LA RUTA BASE DE REPORTES
			
			String rutaBaseReportes = "C:\\Users\\DPAREJA\\eclipse-workspace\\cargue-administradoras\\src\\main\\resources";
			
			// Se valida si la ruta existe
			File fRutaBaseReportes = new File(rutaBaseReportes);
			
			if (!fRutaBaseReportes.exists() || !fRutaBaseReportes.isDirectory() || !fRutaBaseReportes.canRead()) {
				throw new Exception("No existe la ruta base de reportes, no es un directorio o no se tiene acceso de lectura al directorio: " + fRutaBaseReportes.getPath());
			}			
			
			// Se valida la ruta del reporte
			File fReporte = new File(fRutaBaseReportes, report);
			if (!fReporte.exists() || !fReporte.isFile() || !fReporte.canRead()) {
				throw new Exception("No existe la ruta del reporte, no es un archivo o no se tiene acceso de lectura al mismo: " + fReporte.getPath());
			}

			// Se abre el reporte
			inputStream = new FileInputStream(fReporte);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("P_SUBREPORT_DIR", (fRutaBaseReportes.getPath().endsWith("/") ? fRutaBaseReportes.getPath()
					: (fRutaBaseReportes.getPath() + "/")));
			
			data = new HashMap<String, Object>();
			
			data.put("input", inputStream);
			data.put("params", params);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
		return data;
	}

}
