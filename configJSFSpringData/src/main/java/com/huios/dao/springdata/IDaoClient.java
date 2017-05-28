/**
 * Interfaces contenant les Méthodes en Query pour le Client
 */
package com.huios.dao.springdata;
/**
 * @author FLorent - Florent - Théo - Vincent
 *
 */
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.huios.metier.Client;
import com.huios.metier.Conseiller;


public interface IDaoClient extends JpaRepository<Client,Long> {

	

	//public Conseiller verificationLogin(String login, String pwd);
	
	
	@Query ("SELECT c FROM Client c WHERE c.conseiller = :conseiller")
	public Collection<Client> listerClientsParConseiller(@Param("conseiller") Conseiller conseiller);

	//@Modifying
	//@Query("UPDATE Personne p SET p.nom = ?1, p.prenom= ?2, p.adresse = ?3, p.codePostal = ?4, p.ville = ?5, p.telephone = ?6, p.email = ?7 WHERE p.id = ?8")
	//public void modifierClient(String nom, String prenom, String adresse, String codepostal, String ville, String telephone, String email, int idConseiller);
	
	
}
