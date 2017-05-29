package com.huios.mbeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Client;
import com.huios.metier.Compte;
import com.huios.metier.CompteCourant;
import com.huios.metier.CompteEpargne;
import com.huios.service.IServiceConseiller;
import com.huios.service.IServiceGerant;

@Controller
@SessionScope
public class CompteBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6112365196611017112L;

	@Autowired
	private IServiceConseiller service;
	@Autowired
	private IServiceGerant serviceG;
	@Autowired
	private Client client;
	@Autowired
	private Compte compte;
	private Collection<Compte> comptes;
	@Autowired
	@ManagedProperty(value = "#{clientBean}")
	private ClientBean clientBean;
	@Autowired
	private GerantBean gerantBean;
	private Collection<Compte> comptesDecouvert = new ArrayList<>();
	@Autowired
	private CompteCourant compteCourant;
	@Autowired
	private CompteEpargne compteEpargne;
	@Autowired
	private CompteCourant compteCourantASupprimer;
	@Autowired
	private CompteEpargne compteEpargneASupprimer;
	private Collection<CompteCourant> comptesCourant = new ArrayList<>();
	private Collection<CompteEpargne> comptesEpargne = new ArrayList<>();

	public Collection<CompteCourant> getComptesCourant() {
		Collection<CompteCourant> cs = service.listerComptesCourantClient(clientBean.getClient());
		return cs;
	}

	public void setComptesCourant(Collection<CompteCourant> comptesCourant) {
		this.comptesCourant = comptesCourant;
	}

	public Collection<CompteEpargne> getComptesEpargne() {
		Collection<CompteEpargne> ce = service.listerComptesEpargneClient(clientBean.getClient());
		return ce;
	}

	public void setComptesEpargne(Collection<CompteEpargne> comptesEpargne) {
		this.comptesEpargne = comptesEpargne;
	}

	public IServiceGerant getServiceG() {
		return serviceG;
	}

	public void setServiceG(IServiceGerant serviceG) {
		this.serviceG = serviceG;
	}

	public GerantBean getGerantBean() {
		return gerantBean;
	}

	public void setGerantBean(GerantBean gerantBean) {
		this.gerantBean = gerantBean;
	}

	public Collection<Compte> getComptesDecouvert() {
		 comptesDecouvert.clear();
		 setComptesDecouvert(serviceG.listeCompteDecouvert(gerantBean.getGerant()));
		return comptesDecouvert;
	}

	public void setComptesDecouvert(Collection<Compte> comptesDecouvert) {
		this.comptesDecouvert = comptesDecouvert;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public CompteCourant getCompteCourantASupprimer() {
		return compteCourantASupprimer;
	}

	public void setCompteCourantASupprimer(CompteCourant compteCourantASupprimer) {
		this.compteCourantASupprimer = compteCourantASupprimer;
	}

	public CompteEpargne getCompteEpargneASupprimer() {
		return compteEpargneASupprimer;
	}

	public void setCompteEpargneASupprimer(CompteEpargne compteEpargneASupprimer) {
		this.compteEpargneASupprimer = compteEpargneASupprimer;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public IServiceConseiller getService() {
		return service;
	}

	public void setService(IServiceConseiller service) {
		this.service = service;
	}

	public Collection<Compte> getComptes() {
		comptes = service.listerComptesClient(clientBean.getClient());
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public ClientBean getClientBean() {
		return clientBean;
	}

	public void setClientBean(ClientBean clientBean) {
		this.clientBean = clientBean;
	}

	public String ajouterCompteCourant(Client cl) {
		setCompteCourant(new CompteCourant());
		client=cl;
		return "ajouterCompteCourant";
	}
	public String ajouterCompteEpargne(Client cl) {
		setCompteEpargne(new CompteEpargne());
		client=cl;
		return "ajouterCompteEpargne";
	}
	

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	
	public String creerCompteCourant(){
		Date actuelle = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 String dat = dateFormat.format(actuelle);
		 compteCourant.setDateOuverture(dat);
		service.ajouterCompte(client.getIdPersonne(), compteCourant);
		return "detailsClient";
	}
	public void delete(){
		service.deleteCompte(compte);
		compte = new Compte();

	}
	 public String creerCompteEpargne(){
		 Date actuelle = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 String dat = dateFormat.format(actuelle);
		 compteEpargne.setDateOuverture(dat);
		 service.ajouterCompte(client.getIdPersonne(), compteEpargne);
		 return "detailsClient";
		 }
	 public String listeComptesDecouvert(){
		 getComptesDecouvert();
		 return "listeComptesDecouvert";
	 }
	 public String supprimerCompteCourant(){
		service.supprimerCompteCourant(compteCourantASupprimer);
		return clientBean.afficherDetails();
	 }
	 public String supprimerCompteEpargne(){
		service.supprimerCompteEpargne(compteEpargneASupprimer);
		return clientBean.afficherDetails();
	 }
	 
	 public String verificationSoldeCompteCourant(){
		 if(compteCourantASupprimer.getSolde()==0){
			 return "suppressionCompteCourant";
		 }
		 else{
			 return "erreurSuppressionCompteCourant";
		 }
	 }
	 public String verificationSoldeCompteEpargne(){
		 if(compteEpargneASupprimer.getSolde()==0){
			 return "suppressionCompteEpargne";
		 }
		 else{
			 return "erreurSuppressionCompteEpargne";
		 }
	 }
}