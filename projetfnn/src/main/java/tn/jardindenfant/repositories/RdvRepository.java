package tn.jardindenfant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.jardindenfant.entities.Rendez_vous;
@Repository
public interface RdvRepository extends JpaRepository<Rendez_vous, Long> {
	

}
