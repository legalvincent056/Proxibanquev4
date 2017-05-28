package com.huios.metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@DiscriminatorValue("CLIENT")
public class Client extends Personne {

	private String nomEntreprise;
	private boolean entreprise = false;

	@OneToMany(mappedBy = "client")
	private Collection<Compte> comptes = new ArrayList<Compte>();
	@OneToMany(mappedBy = "client")
	private Collection<Placement> placements = new ArrayList<Placement>();
	@ManyToOne
	private Conseiller conseiller;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String telephone, String email, String nomEntreprise, boolean entreprise) {
		super(nom, prenom, telephone, email);
		this.nomEntreprise = nomEntreprise;
		this.entreprise = entreprise;

	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Collection<Placement> getPlacements() {
		return placements;
	}

	public void setPlacements(Collection<Placement> placements) {
		this.placements = placements;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	@Override
	public String getNom() {
		return super.getNom();
	}

	@Override
	public void setNom(String nom) {
		super.setNom(nom);
	}

	@Override
	public String getPrenom() {
		return super.getPrenom();
	}

	@Override
	public void setPrenom(String prenom) {
		super.setPrenom(prenom);
	}

	@Override
	public String getTelephone() {
		return super.getTelephone();
	}

	@Override
	public void setTelephone(String telephone) {
		super.setTelephone(telephone);
	}

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		super.setEmail(email);
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public boolean isEntreprise() {
		return entreprise;
	}

	public void setEntreprise(boolean entreprise) {
		this.entreprise = entreprise;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Client [nomEntreprise=" + nomEntreprise + ", entreprise=" + entreprise + ", conseiller=" + conseiller + ", toString()=" + super.toString()
				+ "]";
	}








}
