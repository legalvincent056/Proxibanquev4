package com.huios.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Adresse;
import com.huios.metier.Client;
import com.huios.metier.Conseiller;
import com.huios.service.IServiceConseiller;




@Controller
@SessionScope
public class ClientBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6055996497840434848L;

	@Autowired
	private IServiceConseiller service; 
	private Collection<Client> clients;
	@Autowired
	private Client client;
	
	@Autowired
	@ManagedProperty(value="#{conseillerBean}")
	private ConseillerBean conseillerBean;
	
	@Autowired
	private Adresse adresse;

	public IServiceConseiller getService() {
		return service;
	}

	public void setService(IServiceConseiller service) {
		this.service = service;
	}

	public Collection<Client> getClients() {
		clients = service.listerClientsParConseiller(conseillerBean.getConseiller());
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public Client getClient() {
//		if (client == null)
//			client = new Client();
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public ConseillerBean getConseillerBean() {
		return conseillerBean;
	}

	public void setConseillerBean(ConseillerBean conseillerBean) {
		this.conseillerBean = conseillerBean;
	}
	
	public String afficherDetails(){
		return "detailsClient";
	}
	
	public String modifierClient(){
		service.modifierClient(client);
		return "detailsClient";
	}

	
	public String ajouterClient(Conseiller conseiller){ //A voir pour ajouter adresse
		service.ajouterClient(conseiller.getIdPersonne(), client);
		return "listeClients";
	}
	
	public String nouveau(){
		client= new Client();
		adresse= new Adresse();
		client.setAdresse(adresse);
		return "ajouterClient";
	}
	
}