package com.huios.metier;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Inheritance
@Component
@Scope("prototype")
@DiscriminatorColumn(name = "TYPE_COMPTE")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numeroCompte;
	private double solde;
	private String dateOuverture;
	@ManyToOne
	private Client client;
	@OneToOne
	private CarteBancaire carteBancaire;

	public long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public Compte(int numeroCompte, double solde, String dateOuverture, Client client, CarteBancaire carteBancaire) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client = client;
		this.carteBancaire = carteBancaire;
	}

	
	public Compte(double solde, String dateOuverture) {
		super();
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	public Compte() {
		super();
	}

	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + "]";
	}



}
