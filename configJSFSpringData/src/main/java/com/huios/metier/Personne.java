package com.huios.metier;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Entity
@Component
@Scope("prototype")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSONNE_TYPE")
public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPersonne;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Adresse adresse;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String telephone, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone
				+ ", email=" + email + ", adresse=" + adresse + "]";
	}
	
	

}
