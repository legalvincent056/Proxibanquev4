package com.huios.service;

import java.util.Collection;

import com.huios.metier.Adresse;
import com.huios.metier.Client;
import com.huios.metier.Compte;
import com.huios.metier.Conseiller;


public interface IServiceConseiller {

	/**
	 * Méthode qui retourne un conseiller grace à son login et son mdp
	 * 
	 * @param login
	 *            identifiant
	 * @param pwd
	 *            mots de passe
	 * @return retourne le conseiller
	 */
	public Conseiller verificationLogin(String login, String pwd);

	/**
	 * retourne la liste de clients d'un conseiller
	 * 
	 * @param conseiller
	 *            Conseiller dont on veux la liste de clients
	 * @return la liste de client du conseiller
	 */
	public Collection<Client> listerClientsParConseiller(Conseiller conseiller);

	/**
	 * modifie le client
	 * 
	 * @param client
	 *            client à modifier
	 * 
	 */
	public void modifierClient(Client client);
	/**
	 * Ajoute le client
	 * 
	 * @param client
	 *            client à ajouter
	 * 
	 */
	public void ajouterClient(long idConseiller, Client client);

	/**
	 * Récupère les comptes associés à un client
	 * 
	 * @param client
	 *            Le client dont on veut les comptes
	 * @return Les comptes du client
	 */
	public Collection<Compte> listerComptesClient(Client client);

	/**
	 * Retourne un client correspondant a l'Id
	 * 
	 * @param idClient
	 *            id du client à retourner
	 * @return client correspondant à l'id
	 */
	public Client retourneClientParId(long idClient);

	/**
	 * Retourne un compte selectionné par son id
	 * 
	 * @param idCompte
	 *            identifiant du compte à retourner
	 * @return compte correspondant à l'Id
	 */
	public Compte getCompteParId(long idCompte);

	/**
	 * Récupère tous les comptes de l'agence sauf le compte donné en argument
	 * 
	 * @param idCompte
	 *            identifiant du compte à exclure des comptes retournés
	 * 
	 * @return une collection de comptes de l'agence
	 */
	public Collection<Compte> listerAutresComptes(long idCompte);

	/**
	 * Met à jour les comptes lors d'un virement
	 * 
	 * @param compteDebiteur
	 *            Compte débité
	 * @param compteCrediteur
	 *            Compte crédité
	 * @param montant
	 *            Somme à virer
	 * @return vrai si le virement a été effectué et faux dans le cas contraire
	 */
	public boolean virementComptes(Compte compteDebiteur, Compte compteCrediteur, double montant);

	/**
	 * retourne le conseiller corespondant a l'Id
	 * 
	 * @param idConseiller
	 *            id du conseiller à retourner
	 * @return conseiller corespondant à l'Id
	 */
	public Conseiller afficherConseiller(long idConseiller);
	
	public void ajouterCompte(long idPersonne , Compte compte);
	
	public void ajouterAdresse(long idPersonne,Adresse adresse);
}
