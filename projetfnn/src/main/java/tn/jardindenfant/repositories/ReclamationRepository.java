package tn.jardindenfant.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.jardindenfant.entities.Reclamation;
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
	//@Query("SELECT r FROM Reclamation r WHERE r.description LIKE %?1%")
           
          
	@Query("SELECT r FROM Reclamation r WHERE CONCAT(r.idReclamation, r.description ,r.etatRecalmation) LIKE %?1%")
    public List <Reclamation> search(String keyword);
	
	
}
