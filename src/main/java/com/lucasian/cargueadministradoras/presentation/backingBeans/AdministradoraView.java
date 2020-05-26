package com.lucasian.cargueadministradoras.presentation.backingBeans;

import com.lucasian.cargueadministradoras.exceptions.*;
import com.lucasian.cargueadministradoras.modelo.*;
import com.lucasian.cargueadministradoras.modelo.dto.AdministradoraDTO;
import com.lucasian.cargueadministradoras.presentation.businessDelegate.*;
import com.lucasian.cargueadministradoras.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class AdministradoraView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AdministradoraView.class);
    private InputText txtCodTpId;
    private InputText txtCodigo;
    private InputText txtFsp;
    private InputText txtFusionada;
    private InputText txtMultipleArp;
    private InputText txtNombre;
    private InputText txtNroId;
    private InputText txtId;
    private Calendar txtFechaFusion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<AdministradoraDTO> data;
    private AdministradoraDTO selectedAdministradora;
    private Administradora entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public AdministradoraView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            AdministradoraDTO administradoraDTO = (AdministradoraDTO) e.getObject();

            if (txtCodTpId == null) {
                txtCodTpId = new InputText();
            }

            txtCodTpId.setValue(administradoraDTO.getCodTpId());

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(administradoraDTO.getCodigo());

            if (txtFsp == null) {
                txtFsp = new InputText();
            }

            txtFsp.setValue(administradoraDTO.getFsp());

            if (txtFusionada == null) {
                txtFusionada = new InputText();
            }

            txtFusionada.setValue(administradoraDTO.getFusionada());

            if (txtMultipleArp == null) {
                txtMultipleArp = new InputText();
            }

            txtMultipleArp.setValue(administradoraDTO.getMultipleArp());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(administradoraDTO.getNombre());

            if (txtNroId == null) {
                txtNroId = new InputText();
            }

            txtNroId.setValue(administradoraDTO.getNroId());

            if (txtId == null) {
                txtId = new InputText();
            }

            txtId.setValue(administradoraDTO.getId());

            if (txtFechaFusion == null) {
                txtFechaFusion = new Calendar();
            }

            txtFechaFusion.setValue(administradoraDTO.getFechaFusion());

            Long id = FacesUtils.checkLong(txtId);
            entity = businessDelegatorView.getAdministradora(id);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedAdministradora = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedAdministradora = null;

        if (txtCodTpId != null) {
            txtCodTpId.setValue(null);
            txtCodTpId.setDisabled(true);
        }

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(true);
        }

        if (txtFsp != null) {
            txtFsp.setValue(null);
            txtFsp.setDisabled(true);
        }

        if (txtFusionada != null) {
            txtFusionada.setValue(null);
            txtFusionada.setDisabled(true);
        }

        if (txtMultipleArp != null) {
            txtMultipleArp.setValue(null);
            txtMultipleArp.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtNroId != null) {
            txtNroId.setValue(null);
            txtNroId.setDisabled(true);
        }

        if (txtFechaFusion != null) {
            txtFechaFusion.setValue(null);
            txtFechaFusion.setDisabled(true);
        }

        if (txtId != null) {
            txtId.setValue(null);
            txtId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFechaFusion() {
        Date inputDate = (Date) txtFechaFusion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Long id = FacesUtils.checkLong(txtId);
            entity = (id != null) ? businessDelegatorView.getAdministradora(id)
                                  : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCodTpId.setDisabled(false);
            txtCodigo.setDisabled(false);
            txtFsp.setDisabled(false);
            txtFusionada.setDisabled(false);
            txtMultipleArp.setDisabled(false);
            txtNombre.setDisabled(false);
            txtNroId.setDisabled(false);
            txtFechaFusion.setDisabled(false);
            txtId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCodTpId.setValue(entity.getCodTpId());
            txtCodTpId.setDisabled(false);
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtFechaFusion.setValue(entity.getFechaFusion());
            txtFechaFusion.setDisabled(false);
            txtFsp.setValue(entity.getFsp());
            txtFsp.setDisabled(false);
            txtFusionada.setValue(entity.getFusionada());
            txtFusionada.setDisabled(false);
            txtMultipleArp.setValue(entity.getMultipleArp());
            txtMultipleArp.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtNroId.setValue(entity.getNroId());
            txtNroId.setDisabled(false);
            txtId.setValue(entity.getId());
            txtId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedAdministradora = (AdministradoraDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedAdministradora"));
        txtCodTpId.setValue(selectedAdministradora.getCodTpId());
        txtCodTpId.setDisabled(false);
        txtCodigo.setValue(selectedAdministradora.getCodigo());
        txtCodigo.setDisabled(false);
        txtFechaFusion.setValue(selectedAdministradora.getFechaFusion());
        txtFechaFusion.setDisabled(false);
        txtFsp.setValue(selectedAdministradora.getFsp());
        txtFsp.setDisabled(false);
        txtFusionada.setValue(selectedAdministradora.getFusionada());
        txtFusionada.setDisabled(false);
        txtMultipleArp.setValue(selectedAdministradora.getMultipleArp());
        txtMultipleArp.setDisabled(false);
        txtNombre.setValue(selectedAdministradora.getNombre());
        txtNombre.setDisabled(false);
        txtNroId.setValue(selectedAdministradora.getNroId());
        txtNroId.setDisabled(false);
        txtId.setValue(selectedAdministradora.getId());
        txtId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedAdministradora == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Administradora();

            Long id = FacesUtils.checkLong(txtId);

            entity.setCodTpId(FacesUtils.checkString(txtCodTpId));
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setFechaFusion(FacesUtils.checkDate(txtFechaFusion));
            entity.setFsp(FacesUtils.checkLong(txtFsp));
            entity.setFusionada(FacesUtils.checkLong(txtFusionada));
            entity.setId(id);
            entity.setMultipleArp(FacesUtils.checkLong(txtMultipleArp));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setNroId(FacesUtils.checkString(txtNroId));
            businessDelegatorView.saveAdministradora(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Long id = new Long(selectedAdministradora.getId());
                entity = businessDelegatorView.getAdministradora(id);
            }

            entity.setCodTpId(FacesUtils.checkString(txtCodTpId));
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setFechaFusion(FacesUtils.checkDate(txtFechaFusion));
            entity.setFsp(FacesUtils.checkLong(txtFsp));
            entity.setFusionada(FacesUtils.checkLong(txtFusionada));
            entity.setMultipleArp(FacesUtils.checkLong(txtMultipleArp));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setNroId(FacesUtils.checkString(txtNroId));
            businessDelegatorView.updateAdministradora(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedAdministradora = (AdministradoraDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedAdministradora"));

            Long id = new Long(selectedAdministradora.getId());
            entity = businessDelegatorView.getAdministradora(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long id = FacesUtils.checkLong(txtId);
            entity = businessDelegatorView.getAdministradora(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteAdministradora(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedAdministradora = (AdministradoraDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedAdministradora"));

            Long id = new Long(selectedAdministradora.getId());
            entity = businessDelegatorView.getAdministradora(id);
            businessDelegatorView.deleteAdministradora(entity);
            data.remove(selectedAdministradora);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codTpId, String codigo,
        Date fechaFusion, Long fsp, Long fusionada, Long id, Long multipleArp,
        String nombre, String nroId) throws Exception {
        try {
            entity.setCodTpId(FacesUtils.checkString(codTpId));
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setFechaFusion(FacesUtils.checkDate(fechaFusion));
            entity.setFsp(FacesUtils.checkLong(fsp));
            entity.setFusionada(FacesUtils.checkLong(fusionada));
            entity.setMultipleArp(FacesUtils.checkLong(multipleArp));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setNroId(FacesUtils.checkString(nroId));
            businessDelegatorView.updateAdministradora(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("AdministradoraView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCodTpId() {
        return txtCodTpId;
    }

    public void setTxtCodTpId(InputText txtCodTpId) {
        this.txtCodTpId = txtCodTpId;
    }

    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public InputText getTxtFsp() {
        return txtFsp;
    }

    public void setTxtFsp(InputText txtFsp) {
        this.txtFsp = txtFsp;
    }

    public InputText getTxtFusionada() {
        return txtFusionada;
    }

    public void setTxtFusionada(InputText txtFusionada) {
        this.txtFusionada = txtFusionada;
    }

    public InputText getTxtMultipleArp() {
        return txtMultipleArp;
    }

    public void setTxtMultipleArp(InputText txtMultipleArp) {
        this.txtMultipleArp = txtMultipleArp;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtNroId() {
        return txtNroId;
    }

    public void setTxtNroId(InputText txtNroId) {
        this.txtNroId = txtNroId;
    }

    public Calendar getTxtFechaFusion() {
        return txtFechaFusion;
    }

    public void setTxtFechaFusion(Calendar txtFechaFusion) {
        this.txtFechaFusion = txtFechaFusion;
    }

    public InputText getTxtId() {
        return txtId;
    }

    public void setTxtId(InputText txtId) {
        this.txtId = txtId;
    }

    public List<AdministradoraDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataAdministradora();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<AdministradoraDTO> administradoraDTO) {
        this.data = administradoraDTO;
    }

    public AdministradoraDTO getSelectedAdministradora() {
        return selectedAdministradora;
    }

    public void setSelectedAdministradora(AdministradoraDTO administradora) {
        this.selectedAdministradora = administradora;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
