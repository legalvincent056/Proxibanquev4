package test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.Conseiller;
import com.huios.service.IServiceConseiller;



public class AfficherConseiller {

	@Test
	public void testRetourneUnConseiller() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		Conseiller conseiller = (Conseiller) appContext.getBean("conseiller");
		conseiller = isc.afficherConseiller(1);		
				
		Assert.assertEquals("Robichet", conseiller.getNom());
		
		
		
		appContext.close();		
	}
	
	
	@Test
	public void testConseillerInexistant() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		Conseiller conseiller = (Conseiller) appContext.getBean("conseiller");
		conseiller = isc.afficherConseiller(9999999);
		
		Assert.assertEquals(null, conseiller);
		
		appContext.close();	
	}

}
