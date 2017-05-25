/**
 * Interfaces contenant les Méthodes en Query pour les Comptes
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
import com.huios.metier.Compte;

public interface IDaoCompte extends JpaRepository<Compte,Long> {

	
	@Query ("SELECT c FROM Compte c WHERE c.client = :client")
	public Collection<Compte> listerComptesClient(@Param("client") Client client);
	
	@Query("SELECT c FROM Compte c WHERE c.numeroCompte <> :id")
	public Collection<Compte> listerAutresComptes(@Param("id") long idCompte);
	
	
	
}
