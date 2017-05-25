package com.huios.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Agence {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAgence;
	private String numAgence;
	private long dateCreation;
	@OneToOne
	private Gerant gerant;

	public Agence(String numAgence, long dateCreation, Gerant gerant) {
		super();
		this.numAgence = numAgence;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
	}

	public Agence(String idAgence, long dateCreation) {
		super();
		this.numAgence = idAgence;
		this.dateCreation = dateCreation;
	}

	public Agence() {
		super();
	}

	public String getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(String numAgence) {
		this.numAgence = numAgence;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public long getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(long dateCreation) {
		this.dateCreation = dateCreation;
	}

	public long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(long idAgence) {
		this.idAgence = idAgence;
	}

	@Override
	public String toString() {
		return "Agence [numAgence=" + numAgence + ", dateCreation=" + dateCreation + ", gerant=" + gerant + "]";
	}

}
