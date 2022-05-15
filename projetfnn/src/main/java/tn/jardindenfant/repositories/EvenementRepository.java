package tn.jardindenfant.repositories;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import tn.jardindenfant.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
	
	@Query("SELECT e from Evenement  e   where( (e.nom_event like %:word% or e.description_event like %:word% ))")
	public List<Evenement> searchEvent(@Param("word") String word);
	
	//@Query("SELECT p.event as event , p.event.places as places ,  p.event.remaining as remaining    from payment p GROUP BY ( p.event.id_event ) ORDER BY  sum(p.number_tickets) DESC  ")

	//public List<Evenement> findTop(PageRequest pageRequest);

	//@Query(value = "SELECT * FROM Evenement e WHERE e.etat = 1", nativeQuery = true)
	//public List<Evenement> findAllEvent();

	//@Query(value = "SELECT * FROM Evenement e WHERE e.etat = 0", nativeQuery = true)
	//public List<Evenement> findArchivedEvent();
	

}
