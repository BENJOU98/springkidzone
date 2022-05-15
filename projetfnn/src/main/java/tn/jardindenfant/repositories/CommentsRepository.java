package tn.jardindenfant.repositories;
import java.util.List;


import tn.jardindenfant.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {	
	@Query(value="SELECT comments.* from comments where pub_id_id = :publicationId ",nativeQuery=true)
	List<Comments> RelevantComments(@Param("publicationId") int id);
}
