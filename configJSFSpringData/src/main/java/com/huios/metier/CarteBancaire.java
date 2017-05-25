package com.huios.metier;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@Inheritance
@DiscriminatorColumn(name="CARTE_TYPE")
public abstract class CarteBancaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCarteBancaire;
	private boolean bloquee = false;
	@OneToOne
	private Compte compte;

	public boolean isBloquee() {
		return bloquee;
	}

	public void setBloquee(boolean bloquee) {
		this.bloquee = bloquee;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "CarteBancaire [bloquee=" + bloquee + ", compte=" + compte + "]";
	}

}
