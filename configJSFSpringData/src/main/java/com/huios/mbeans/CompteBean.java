package com.huios.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Compte;
import com.huios.service.IServiceConseiller;


@Controller
@SessionScope
public class CompteBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6112365196611017112L;

	@Autowired
	private IServiceConseiller service;
	
	private Collection<Compte> comptes;
	@Autowired
	@ManagedProperty(value="#{clientBean}")
	private ClientBean clientBean;
	
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
	
	
	
}