package com.huios.mbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Gerant;
import com.huios.service.IServiceGerant;
@Controller
@SessionScope
public class GerantBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 448662768824935812L;
	@Autowired
	private IServiceGerant service;
	@Autowired
	private Gerant gerant;
	
	
	
	public Gerant getGerant() {
		return gerant;
	}
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	public IServiceGerant getService() {
		return service;
	}
	public void setService(IServiceGerant service) {
		this.service = service;
	}
	
	public String connexion() {
		gerant = service.verificationLoginGerant(gerant.getLogin(), gerant.getPwd());
		if (gerant.equals(null)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Connexion échouée, mot de passe/login invalides", null));
			gerant = new Gerant();
			return "indexGerant";
		} else {
			return "listeConseillers";
		}
	}
	
	public String deconnexion(){
		gerant = new Gerant();
		return "indexGerant";
		
	}
	
	

}
