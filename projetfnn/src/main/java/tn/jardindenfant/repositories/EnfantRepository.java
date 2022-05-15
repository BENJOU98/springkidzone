package tn.jardindenfant.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.jardindenfant.entities.Enfant;

@Repository
public interface EnfantRepository extends CrudRepository<Enfant,Integer > {

	
	@Query("SELECT e FROM Enfant e WHERE e.nom=:word")
	public List<Enfant> searchEnfant(@Param("word") String nomenfant);
	
	@Query("SELECT count(*) as nbr FROM Enfant")
	int getNombresEnfant();
	
	@Query("SELECT count(*) as nbr FROM Enfant e WHERE e.sexe like '%Garçon%'")
	int getNombresGarçon();
	
	@Query("SELECT count(*) as nbr FROM Enfant e WHERE e.sexe like '%Fille%'")
	int getNombresFille();
	
	//@Query("SELECT p FROM Publication p WHERE p.dateDerniereModification=:date") 
	//List<Enfant> searchPublicationByDate(@Param("date") Date date);


}

