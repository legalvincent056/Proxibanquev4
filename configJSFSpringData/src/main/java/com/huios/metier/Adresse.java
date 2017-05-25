package com.huios.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAdresse;
	private String rue;
	private String codePostal;
	private String ville;
	
	
	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse() {
		super();
	}

	public long getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	
	

}
