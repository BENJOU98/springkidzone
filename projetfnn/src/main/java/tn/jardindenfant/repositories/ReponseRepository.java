package tn.jardindenfant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import  tn.jardindenfant.entities.*;
import  tn.jardindenfant.services.*;
@EnableJpaRepositories
@Repository
public interface ReponseRepository extends CrudRepository<Reponse,Integer>{

	List<Reponse> findAllBySujetId(int sujet_id);
	
}