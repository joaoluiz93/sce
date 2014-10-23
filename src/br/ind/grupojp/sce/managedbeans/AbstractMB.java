package br.ind.grupojp.sce.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class AbstractMB {

	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";

	public AbstractMB() {
		super();
	}

	protected void menssagemErro(String message) {
		FacesMessage msg = new FacesMessage(message);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	protected void menssagemInfo(String message) {

		FacesMessage msg = new FacesMessage(message);
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	protected void menssagemGrave(String message) {
		FacesMessage msg = new FacesMessage(message);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		;
	}

	protected void closeDialog() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}

	protected void keepDialogOpen() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}

	protected RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}

}