/**
 * 
 */
package com.huios.dao.springdata;
/**
 * @author FLorent - Florent - Théo - Vincent
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.huios.metier.Adresse;

public interface IDaoAdresse extends JpaRepository<Adresse,Long> {

}
