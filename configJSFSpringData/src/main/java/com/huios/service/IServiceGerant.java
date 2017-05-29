package com.huios.service;

import java.util.Collection;

import com.huios.metier.Compte;
import com.huios.metier.Conseiller;
import com.huios.metier.Gerant;

public interface IServiceGerant {

	public void ajouterConseiller(long idPersonne , Conseiller conseiller);
	public void ajouterGerant(Gerant gerant);
	
	/**
	 * retourne la liste de clients d'un conseiller
	 * 
	 * @param gerant
	 *            Gerant dont on veut la liste des conseillers
	 * @return la liste de conseiller par gerant
	 */
	public Collection<Conseiller> listerConseillerParGerant(Gerant gerant);
	public void modifierConseiller(Conseiller conseiller);
	public Gerant verificationLoginGerant(String login, String pwd);
	public Collection<Compte> listeCompteDecouvert(Gerant gerant);
}
