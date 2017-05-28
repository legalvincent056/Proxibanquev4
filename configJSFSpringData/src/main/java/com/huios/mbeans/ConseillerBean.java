package com.huios.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Conseiller;
import com.huios.service.IServiceConseiller;
import com.huios.service.IServiceGerant;


@Controller
@SessionScope
public class ConseillerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2555872694845302663L;
	@Autowired
	private IServiceConseiller service;
	
	@Autowired
	private IServiceGerant serviceG;
	
	@Autowired
	private Conseiller conseiller;
	private Collection<Conseiller> conseillers = new ArrayList<Conseiller>();
	@Autowired
	@ManagedProperty(value="#{gerantBean}")
	private GerantBean gerantBean;
	
	
	public IServiceConseiller getService() {
		return service;
	}

	public void setService(IServiceConseiller service) {
		this.service = service;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	public Collection<Conseiller> getConseillers() {
		conseillers = serviceG.listerConseillerParGerant(gerantBean.getGerant());
		return conseillers;
	}

	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
	
	

	public String connexion() {
		conseiller = service.verificationLogin(conseiller.getLogin(), conseiller.getPwd());
		if (conseiller.equals(null)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Connexion échouée, mot de passe/login invalides", null));
			conseiller = new Conseiller();
			return "index";
		} else {
			return "listeClients";
		}
	}
	
	public String deconnexion(){
		conseiller = new Conseiller();
		return "index";
		
	}
	
}