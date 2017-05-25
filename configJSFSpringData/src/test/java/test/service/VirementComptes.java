package test.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.CompteCourant;
import com.huios.metier.CompteEpargne;
import com.huios.service.IServiceConseiller;



public class VirementComptes {

	@Test
	public void testVirementMontantNegatif() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		CompteCourant cc = (CompteCourant) appContext.getBean("compteCourant");
		CompteEpargne ce = (CompteEpargne) appContext.getBean("compteEpargne");
			
		 Assert.assertFalse(isc.virementComptes(cc, ce,-500));
		 appContext.close();
		}
	
	
	@Test
	public void testVirementCompteCourantSoldeInsuffisant() {
		
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		CompteCourant cc = (CompteCourant) appContext.getBean("compteCourant");
		CompteEpargne ce = (CompteEpargne) appContext.getBean("compteEpargne");
			
		cc.setSolde(1000);
		cc.setDecouvert(500);
		
		Assert.assertFalse(isc.virementComptes(cc, ce,2000));
		appContext.close();
	}
	
	
	@Test
	public void testVirementCompteEpargneSoldeInsuffisant() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IServiceConseiller isc = (IServiceConseiller) appContext.getBean("serviceImp");
		
		CompteCourant cc = (CompteCourant) appContext.getBean("compteCourant");
		CompteEpargne ce = (CompteEpargne) appContext.getBean("compteEpargne");
		
			
		ce.setSolde(1000);
		
		Assert.assertFalse(isc.virementComptes(cc, ce,2000));
		appContext.close();
	}
	
	
	
}
