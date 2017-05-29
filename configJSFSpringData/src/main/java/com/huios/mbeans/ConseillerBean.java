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

import com.huios.metier.Adresse;
import com.huios.metier.Conseiller;
import com.huios.metier.Gerant;
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
	private Adresse adresse;
	@Autowired
	private Conseiller conseiller;
	private Collection<Conseiller> conseillers = new ArrayList<Conseiller>();
	@Autowired
	@ManagedProperty(value="#{gerantBean}")
	private GerantBean gerantBean;
	private String PWD;
	private String PWDnew;
	private String PWDnewConf;
	
	
	public IServiceGerant getServiceG() {
		return serviceG;
	}

	public void setServiceG(IServiceGerant serviceG) {
		this.serviceG = serviceG;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public GerantBean getGerantBean() {
		return gerantBean;
	}

	public void setGerantBean(GerantBean gerantBean) {
		this.gerantBean = gerantBean;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public String getPWDnew() {
		return PWDnew;
	}

	public void setPWDnew(String pWDnew) {
		PWDnew = pWDnew;
	}

	public String getPWDnewConf() {
		return PWDnewConf;
	}

	public void setPWDnewConf(String pWDnewConf) {
		PWDnewConf = pWDnewConf;
	}

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
		if (conseiller == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Connexion échouée, mot de passe/login invalides", " "));
			conseiller = new Conseiller();
			return "index";
		} else {
			return "listeClients";
		}
	}
	public void delete(){
		service.deleteConseiller(conseiller);
		conseiller = new Conseiller();
	}
	public String deconnexion(){
		conseiller = new Conseiller();
		return "index";
	}
	public String nouveau(){
		conseiller= new Conseiller();
		adresse= new Adresse();
		conseiller.setAdresse(adresse);
		return "ajouterConseiller";
	}
	public String ajouterConseiller(Gerant gerant){ //A voir pour ajouter adresse
		serviceG.ajouterConseiller(gerant.getIdPersonne(), conseiller);
		return "listeConseillers";
	}
	public String afficherDetails(){
		return "detailsConseiller";
	}
	
	public String modifierConseiller(){
		serviceG.modifierConseiller(conseiller);
		return "detailsConseiller";
	}
	public String changementPWD(){
		if(PWD.equals(conseiller.getPwd())){
			if(PWDnew.equals(PWDnewConf)){
				conseiller.setPwd(PWDnew);
				service.modifierConseiller(conseiller);
			}
			else{
				return "PWDDif";
			}
		}
		else{
			return "PWDFaux";
		}
		System.out.println("test");
		return "listeClients";
	}
}
