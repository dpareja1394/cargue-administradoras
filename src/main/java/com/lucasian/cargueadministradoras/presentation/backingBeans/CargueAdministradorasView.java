package com.lucasian.cargueadministradoras.presentation.backingBeans;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lucasian.cargueadministradoras.modelo.Administradora;
import com.lucasian.cargueadministradoras.presentation.businessDelegate.IBusinessDelegatorView;
import com.lucasian.cargueadministradoras.utilities.Constantes;
import com.lucasian.cargueadministradoras.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CargueAdministradorasView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CargueAdministradorasView.class);

    //Archivo de Carga
    private UploadedFile fileAdministradoras;
    
    //Lista Administradoras
    private List<Administradora> administradoras;
    
    //Archivo de error
    private StreamedContent fileErrorsCargueAdministradoras;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public CargueAdministradorasView() {
        super();
    }

	/**
	 * @return the fileAdministradoras
	 */
	public UploadedFile getFileAdministradoras() {
		return fileAdministradoras;
	}

	/**
	 * @param fileAdministradoras the fileAdministradoras to set
	 */
	public void setFileAdministradoras(UploadedFile fileAdministradoras) {
		this.fileAdministradoras = fileAdministradoras;
	}

	/**
	 * @return the administradoras
	 */
	public List<Administradora> getAdministradoras() {
		try {
			if(administradoras == null) {
				administradoras = businessDelegatorView.getAdministradora();
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return administradoras;
	}

	/**
	 * @param administradoras the administradoras to set
	 */
	public void setAdministradoras(List<Administradora> administradoras) {
		this.administradoras = administradoras;
	}

	/**
	 * @return the businessDelegatorView
	 */
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	/**
	 * @param businessDelegatorView the businessDelegatorView to set
	 */
	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	/**
	 * @return the fileErrorsCargueAdministradoras
	 */
	public StreamedContent getFileErrorsCargueAdministradoras() {
		try {
			if(!validateCargaAdministradoras()) {
				uploadAdministradoras();
			};
			
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return fileErrorsCargueAdministradoras;
	}

	/**
	 * @param fileErrorsCargueAdministradoras the fileErrorsCargueAdministradoras to set
	 */
	public void setFileErrorsCargueAdministradoras(StreamedContent fileErrorsCargueAdministradoras) {
		this.fileErrorsCargueAdministradoras = fileErrorsCargueAdministradoras;
	}
	
	//Métodos
	private boolean validateCargaAdministradoras() {
		boolean isNotValid = false;
		
		if(fileAdministradoras == null || fileAdministradoras.getFileName() == null || fileAdministradoras.getFileName().trim().isEmpty()) {
			isNotValid = true;
			FacesUtils.addErrorMessage("Error en el archivo de carga de administradoras");
		}else{
			String ext = FilenameUtils.getExtension(fileAdministradoras.getFileName());
			if (!ext.equals(Constantes.EXTENSION)) {
				isNotValid = true;
				FacesUtils.addErrorMessage("msgFormatoExcel");
			}
		}
		return isNotValid;
	}
	
	public void uploadAdministradoras() {
		try {
			this.fileErrorsCargueAdministradoras = null;
			File file = null;
			if (fileAdministradoras != null) {

			        String name = fileAdministradoras.getFileName();

			        InputStream inputStream = fileAdministradoras.getInputstream();
			        OutputStream outputStream = null;

			        file = new File(name);

			        outputStream = new FileOutputStream(file);

			        int read = 0;
			        byte[] bytes = new byte[1024];

			        while ((read = inputStream.read(bytes)) != -1) {
			            outputStream.write(bytes, 0, read);
			        }

			    }
			
			
			ByteArrayInputStream fileError = businessDelegatorView.cargarPlantillaAdministradoras(file);
			if(fileError != null) {
				InputStream stream = fileError;
				this.fileErrorsCargueAdministradoras = new DefaultStreamedContent(
						stream, "application/pdf", "InformeErroresCargueAdministradoras.pdf");
				FacesUtils.addErrorMessage("msgCargaFallida");
			}else{
				FacesUtils.addInfoMessage("msgCargaExitosa");
				administradoras = null;
				getAdministradoras();
			}
		}catch (Exception e) {
			FacesUtils.addErrorMessage("msgGuardadoErroneo");
		}
	}

}
