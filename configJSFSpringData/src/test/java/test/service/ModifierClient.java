package test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.Client;
import com.huios.service.IServiceConseiller;


public class ModifierClient {

	@Test
	public void test() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		Client client = (Client) appContext.getBean("client");
		Client client2 = (Client) appContext.getBean("client");
		
		// chercher client id= 2  avec nom original = ZEZE
		
		client = isc.retourneClientParId(2);
		client.setNom("NomTest");
		
		isc.modifierClient(client);
		
		client2 = isc.retourneClientParId(2);		
			
		Assert.assertEquals("NomTest", client2.getNom());
		
		// restaure le client
		
		client2.setNom("ZEZE");
		isc.modifierClient(client2);
		
		appContext.close();
	}

}
