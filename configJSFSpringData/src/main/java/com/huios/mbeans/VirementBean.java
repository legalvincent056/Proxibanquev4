package com.huios.mbeans;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Compte;
import com.huios.service.IServiceConseiller;



@Controller
@SessionScope
public class VirementBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2844022733522014481L;
	@Autowired
	private IServiceConseiller service;
	private Compte compteDebiteur;
	private Compte compteCrediteur;
	
	private long idCompteCrediteur;
	private double montant;
	private Collection<Compte> autresComptes;

	public IServiceConseiller getService() {
		return service;
	}


	public void setService(IServiceConseiller service) {
		this.service = service;
	}


	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}


	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}


	public Compte getCompteCrediteur() {
		return compteCrediteur;
	}


	public void setCompteCrediteur(Compte compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public long getIdCompteCrediteur() {
		return idCompteCrediteur;
	}


	public void setIdCompteCrediteur(long idCompteCrediteur) {
		this.idCompteCrediteur = idCompteCrediteur;
	}


	public String afficherVirement(){
		autresComptes = service.listerAutresComptes(compteDebiteur.getNumeroCompte());
		return "virement";
	}
		
	
	public String effectuerVirement(){
		compteCrediteur= service.getCompteParId(idCompteCrediteur);
		if(service.virementComptes(compteDebiteur, compteCrediteur, montant)){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Virement réalisé avec succés!", null));
		}
		else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solde insuffisant, virement non effectué", null));
		}
		montant = 0;
		return "virement";
	}


	public Collection<Compte> getAutresComptes() {
		return autresComptes;
	}


	public void setAutresComptes(Collection<Compte> autresComptes) {
		this.autresComptes = autresComptes;
	}
	
}