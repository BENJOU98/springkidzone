package tn.jardindenfant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;

import tn.jardindenfant.entities.Evenement;

public interface EvenementService {
	

	Evenement saveEvenement(Evenement event);
	Evenement updateEvenement(Evenement event);
	void deleteEvenement(Evenement event);
	void deleteEvenementById(int idEvent);
	Evenement getEvenement(Long id);
	List <Evenement> getAllEvenements();
	Evenement ajouterEvenement(Evenement event);
	List<Evenement> Search(String word);
	List<Evenement> findAllEvent();
	List<Evenement> findArchivedEvent();
	Optional<Evenement> findEventById(int idEvent);
	List<Evenement> stats();
	void archiveEvent(int eventId);

	
	
}
