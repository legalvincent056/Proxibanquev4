package test.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.Client;
import com.huios.metier.Conseiller;
import com.huios.service.IServiceConseiller;

public class ListerClientsParConseiller {

	@Test
	public void testTailleCollectionClients() {
		
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		Conseiller conseiller = (Conseiller) appContext.getBean("conseiller");
		
		  // recuperation du conseiller de test
		conseiller = isc.verificationLogin("demo", "demo");
		
		Collection<Client> clients = isc.listerClientsParConseiller(conseiller);
		
		Assert.assertEquals(4, clients.size());	
		appContext.close();
	}
}	
