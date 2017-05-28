package com.huios.mbeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Client;
import com.huios.metier.Compte;
import com.huios.metier.CompteCourant;
import com.huios.service.IServiceConseiller;

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
	private Client client;
	@Autowired
	private Compte compte;
	private Collection<Compte> comptes;
	@Autowired
	@ManagedProperty(value = "#{clientBean}")
	private ClientBean clientBean;

	@Autowired
	private CompteCourant compteCourant;

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

}