package com.huios.metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@DiscriminatorValue("GERANT")
public class Gerant extends Personne {

	private String login;
	private String pwd;
	@OneToMany(mappedBy="gerant")
	private Collection<Conseiller> conseillers = new ArrayList<Conseiller>();
	@OneToOne(mappedBy = "gerant")
	private Agence agence;
	
	

	public String getLogin() {
		return login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Gerant(String nom, String prenom, String telephone, String email, Collection<Conseiller> conseillers) {
		super(nom, prenom, telephone, email);
		this.conseillers = conseillers;
		this.agence = agence;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public Gerant(Collection<Conseiller> conseillers, Agence agence) {
		super();
		this.conseillers = conseillers;
		this.agence = agence;
	}

	public Gerant(Collection<Conseiller> conseillers) {
		super();
		this.conseillers = conseillers;
	}

	public Gerant() {
		super();
	}

	@Override
	public String toString() {
		return "Gerant [conseillers=" + conseillers + "]";
	}

}
