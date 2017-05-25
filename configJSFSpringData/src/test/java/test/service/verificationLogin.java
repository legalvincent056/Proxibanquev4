package test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.Conseiller;
import com.huios.service.IServiceConseiller;



public class verificationLogin {

	
	@Test
	public void testConseillerExiste() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		Conseiller conseiller = (Conseiller) appContext.getBean("conseiller");
		
		conseiller =isc.verificationLogin("demo", "demo");
		
			
		Assert.assertEquals("Robichet", conseiller.getNom());
		appContext.close();
	}
	
	@Test
	public void testConseillerNexistePas() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		Conseiller conseiller = (Conseiller) appContext.getBean("conseiller");
		
		conseiller =isc.verificationLogin("fefe", "fefe");

		
		Assert.assertEquals(null, conseiller);
		appContext.close();
	}
	
	

}
