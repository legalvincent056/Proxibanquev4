package com.huios.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Placement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPlacement;
	private double montant;
	private String placeFinanciere;
	@ManyToOne
	private Client client;

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getPlaceFinanciere() {
		return placeFinanciere;
	}

	public void setPlaceFinanciere(String placeFinanciere) {
		this.placeFinanciere = placeFinanciere;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getIdPlacement() {
		return idPlacement;
	}

	public void setIdPlacement(long idPlacement) {
		this.idPlacement = idPlacement;
	}

	@Override
	public String toString() {
		return "Placement [montant=" + montant + ", placeFinanciere=" + placeFinanciere + ", client=" + client + "]";
	}
}
