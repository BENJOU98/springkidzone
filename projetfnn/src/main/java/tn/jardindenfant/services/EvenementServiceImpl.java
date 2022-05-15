package tn.jardindenfant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.jardindenfant.repositories.EvenementRepository;
import tn.jardindenfant.entities.Evenement;

@Service
public class EvenementServiceImpl implements EvenementService {

	
	@Autowired
	EvenementRepository evenementRepository;
	
	
	@Override
	public Evenement saveEvenement(Evenement event) {
		return evenementRepository.save(event);
	}

	@Override
	public Evenement updateEvenement(Evenement event) {
		return evenementRepository.save(event);
	}

	@Override
	public void deleteEvenement(Evenement event) {
		evenementRepository.delete(event);
		
	}

	@Override
	public void deleteEvenementById(int idEvent) {
		evenementRepository.deleteById((long)  idEvent);
		
	}

	@Override
	public Evenement getEvenement(Long id) {
		return evenementRepository.findById(id).get();
	}

	@Override
	public List<Evenement> getAllEvenements() {
		return evenementRepository.findAll();
	}

	@Override
	public Evenement ajouterEvenement(Evenement event) {
		return evenementRepository.save(event);
		
	}
	

	@Override
	public List<Evenement> Search(String word) {

		return (List<Evenement>) evenementRepository.searchEvent(word);

	}

	@Override
	public List<Evenement> findAllEvent() {
		return (List<Evenement>) evenementRepository.findAll();
	}
/*
	@Override
	public List<Evenement> findArchivedEvent() {
		return (List<Evenement>) evenementRepository.findArchivedEvent();

	}

	*/

	@Override
	public Optional<Evenement> findEventById(int idEvent) {
		return evenementRepository.findById((long) idEvent);
	}

	@Override
	public List<Evenement> stats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveEvent(int eventId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Evenement> findArchivedEvent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
