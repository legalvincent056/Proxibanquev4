package test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.Client;
import com.huios.service.IServiceConseiller;



public class RetourneClientParId {

	
	@Test
	public void testRetourneUnClient() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		Client client = (Client) appContext.getBean("client");
		client = isc.retourneClientParId(2);	
		
		Assert.assertEquals("ZEZE", client.getNom());
		appContext.close();	
	}
	
	
	@Test
	public void testRetourneUnClientAvecSonAdresse() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		Client client = (Client) appContext.getBean("client");
		client = isc.retourneClientParId(2);	

			
		Assert.assertEquals("GENAS", client.getAdresse().getVille());
		appContext.close();	
	}
	

}
