package test.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.CompteCourant;
import com.huios.metier.CompteEpargne;
import com.huios.service.IServiceConseiller;




public class GetCompteParId {
	
	
		
	@Test
	public void testRetourneUnCompteCourant() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
				
		CompteCourant cc = (CompteCourant) appContext.getBean("compteCourant");
		
		cc = (CompteCourant) isc.getCompteParId(1);

			
		Assert.assertEquals("2009-12-05",cc.getDateOuverture());
		appContext.close();
	}
	
	
	@Test
	public void testRetourneUnCompteEpargne() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		CompteEpargne ce = (CompteEpargne) appContext.getBean("compteEpargne");
		
		ce = (CompteEpargne) isc.getCompteParId(4);
		
		
		Assert.assertEquals("2008-01-30",ce.getDateOuverture());
		appContext.close();
	}
		

}
