package com.huios.metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Personne {

	private String login;
	private String pwd;
	@OneToMany(mappedBy="conseiller")
	private Collection<Client> clients = new ArrayList<Client>();
	@ManyToOne
	private Gerant gerant;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

//	public Conseiller(Collection<Client> clients, Gerant gerant) {
//		super();
//		this.clients = clients;
//		this.gerant = gerant;
//	}

	public Conseiller(Collection<Client> clients) {
		super();
		this.clients = clients;
	}

	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom, String telephone, String email,String login,String pwd) {
		super(nom, prenom, telephone, email);
		this.login=login;
		this.pwd=pwd;
	}

	@Override
	public String toString() {
		return "Conseiller [login=" + login + ", pwd=" + pwd + "]";
	}





}
