package tn.jardindenfant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import tn.jardindenfant.entities.Sujet;
import tn.jardindenfant.services.*;

@Repository
public interface SujetRepository extends CrudRepository<Sujet,Integer>{

	List<Sujet> findAllByForumId(int forum_id);
	@Query("SELECT count(*) as nbr FROM Sujet")
	int getNombresSujet();
	@Query("SELECT count(*) as nbr FROM Sujet s WHERE s.forum.id=:idforum")
	int getNombresSujet2(@Param("idforum") int type_forum);
}
