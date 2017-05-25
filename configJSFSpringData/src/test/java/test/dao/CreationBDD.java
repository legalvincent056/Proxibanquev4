package test.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.huios.metier.Adresse;
import com.huios.metier.Client;
import com.huios.metier.Compte;
import com.huios.metier.CompteCourant;
import com.huios.metier.CompteEpargne;
import com.huios.metier.Conseiller;

import junit.framework.TestCase;

public class CreationBDD extends TestCase {

	/**
	 * Permet de créer les tables et de les peupler avec des données. A utiliser
	 * si "hibernate.hbm2ddl.auto" est mis sur "create" dans le fichier
	 * "persistence.xml"
	 */
	@Test
	public void testBDD() {
		Conseiller c = new Conseiller("Robichet", "Robert", "4565458", "roro69@gmail.fr", "demo", "demo");
		Conseiller c2 = new Conseiller("TheConseiller", "PrenomCon", "9874556", "Conseiller2@gmail.fr", "demo2",
				"demo2");

		Client cl1 = new Client("ZEZE", "Bernard", "05548922852", "berner@hotmail.fr", null, false);
		Client cl2 = new Client("tutu", "alice", "6584572222", "Atutu@hotmail.fr", null, false);
		Client cl3 = new Client("gaga", "Jojo", "9879495925", "jojotutu@hotmail.fr", "MomoEnterprise", true);
		Client cl4 = new Client("momo", "Lulu", "65484821212", "lulu@hotmail.fr", null, false);
		Client cl5 = new Client("LE BAIL", "Jonathan", "6525482323", "jojodu56@hotmail.fr", null, false);

		Adresse a1 = new Adresse("rue du chat qui tousse", "69740", "GENAS");
		Adresse a2 = new Adresse("avenue du chateau", "25148", "LOURDE");
		Adresse a3 = new Adresse("rue du mouton qui broute", "42563", "SAINT-ETIENNE");
		Adresse a4 = new Adresse("avenue de la rue", "56240", "QUIBERON");

		CompteCourant cc1 = new CompteCourant(2000, "2009-12-05");
		CompteCourant cc2 = new CompteCourant(3000, "2015-02-25");
		CompteCourant cc3 = new CompteCourant(4000, "2013-06-07");

		CompteEpargne ce1 = new CompteEpargne(20000, "2008-01-30");
		CompteEpargne ce2 = new CompteEpargne(10000, "2014-08-02");
		CompteEpargne ce3 = new CompteEpargne(8500, "2012-05-27");

		// collection clients
		Collection<Client> clients = new ArrayList<Client>();
		clients.add(cl1);
		clients.add(cl2);
		clients.add(cl3);
		clients.add(cl4);

		Collection<Client> clients2 = new ArrayList<Client>();
		clients2.add(cl5);

		// association conseiller-client
		c.setClients(clients);
		c2.setClients(clients2);

		cl1.setConseiller(c);
		cl2.setConseiller(c);
		cl3.setConseiller(c);
		cl4.setConseiller(c);
		cl5.setConseiller(c2);

		// association client-adresse
		cl1.setAdresse(a1);
		cl2.setAdresse(a2);
		cl3.setAdresse(a3);
		cl4.setAdresse(a4);
		cl5.setAdresse(a2);// Meme adresse que cl2

		// association client-compte
		Collection<Compte> comptes = new ArrayList<Compte>();
		comptes.add(cc1);
		comptes.add(ce1);

		cl1.setComptes(comptes);
		cc1.setClient(cl1);
		ce1.setClient(cl1);

		comptes = new ArrayList<Compte>();
		comptes.add(cc2);
		cl2.setComptes(comptes);
		cc2.setClient(cl2);

		comptes = new ArrayList<Compte>();
		comptes.add(ce2);
		cl3.setComptes(comptes);
		ce2.setClient(cl3);

		comptes = new ArrayList<Compte>();
		comptes.add(cc3);
		comptes.add(ce3);
		cl4.setComptes(comptes);
		cc3.setClient(cl4);
		ce3.setClient(cl4);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxiv3-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// conseiller
		em.persist(c);

		// clients
		em.persist(cl1);
		em.persist(cl2);
		em.persist(cl3);
		em.persist(cl4);
		// adresses
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);

		// comptes
		em.persist(cc1);
		em.persist(cc2);
		em.persist(cc3);
		em.persist(ce1);
		em.persist(ce2);
		em.persist(ce3);

		// Conseiller2
		em.persist(c2);

		// Client 5
		em.persist(cl5);

		tx.commit();
		em.close();

	}

}
