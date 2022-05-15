package tn.jardindenfant.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.jardindenfant.entities.Consultation;
import tn.jardindenfant.entities.Enfant;

@EnableJpaRepositories
@Repository
public interface ConsultationRepository extends CrudRepository<Consultation,Integer> {
	
	@Query("SELECT e FROM Consultation e WHERE e.maladie=:word")
	public List<Consultation> searchConsultation(@Param("word") String maladie);
	
	@Query("SELECT count(*) as nbr FROM Consultation")
	int getNombresConsultation();
	
	//@Query("SELECT count(*) FROM Consultation c WHERE c.id_enfant=id_e")
	//int getNombresConsultationByEnfant(@Param("id_e") String NbEnfantConsultation);
	
	
	//@Query("SELECT p FROM Publication p WHERE p.dateDerniereModification=:date") 
	//List<Consultation> searchByDate(@Param("date") Date date);


}
