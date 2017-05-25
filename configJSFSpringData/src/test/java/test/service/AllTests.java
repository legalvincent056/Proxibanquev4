package test.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AfficherConseiller.class, GetCompteParId.class, ListerClientsParConseiller.class, ModifierClient.class,
		RetourneClientParId.class, verificationLogin.class, VirementComptes.class })
public class AllTests {

}
