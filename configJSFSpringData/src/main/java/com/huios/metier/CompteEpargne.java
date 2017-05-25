package com.huios.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	private double remuneration = 0.03;

	public double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}

	public CompteEpargne(int numeroCompte, double solde, String dateOuverture, Client client,
			CarteBancaire carteBancaire, double remuneration) {
		super(numeroCompte, solde, dateOuverture, client, carteBancaire);
		this.remuneration = remuneration;
	}

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(double solde, String dateOuverture) {
		super(solde, dateOuverture);
	}

	@Override
	public String toString() {
		return "CompteEpargne [remuneration=" + remuneration + "]";
	}



}
