package tn.jardindenfant.repositories;

import org.hibernate.usertype.UserType;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import tn.jardindenfant.entities.Jardin;

public interface JardinRepository extends JpaRepository<Jardin, Long> {
	
	@Query("SELECT k FROM Jardin k where k.directeur_id=:user or k.responsable_garderie=:user or k.medecin_id=:user")
	public Jardin selectjardinbyId(@Param("user") UserType u);
	
	@Query("SELECT count(*) as nbr FROM Jardin")
	int getNombreJardin();

}
