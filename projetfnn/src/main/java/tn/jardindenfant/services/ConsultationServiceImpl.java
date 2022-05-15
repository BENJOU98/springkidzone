package tn.jardindenfant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.jardindenfant.entities.Consultation;
import tn.jardindenfant.entities.Enfant;
import tn.jardindenfant.repositories.ConsultationRepository;
import tn.jardindenfant.repositories.EnfantRepository;

@Service
public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	ConsultationRepository consultationRepository;
	@Autowired
	EnfantRepository enfantRepository;
	
	@Override
	public List<Consultation> retrieveAllConsultation() {
		return (List<Consultation>) consultationRepository.findAll() ;
	}

	/*
	@Override
	public void affecterchildAparent(int childId, int parentId) {
		User p = userRepository.findById(parentId).get();
		Child c =  childRepository.findById(childId).get() ;
		
		p.getChildren().add(c);
		userRepository.save(p) ;
		
	} */
	
	@Override
	public Consultation addConsultation(Consultation c) {
		consultationRepository.save(c) ;
    //affecterchildAparent(c.getId(),id);
		return c;
	}

	@Override
	public void deleteConsultation(String id) {
		consultationRepository.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public Consultation updateConsultation(Consultation c) {
		consultationRepository.save(c) ;
		return c;
	}

	@Override
	public Consultation retrieveConsultation(String id) {
		return	consultationRepository.findById(Integer.parseInt(id)).orElse(null);
	}
	
	@Override
	public Consultation affecterConsultationToEnfant(int id_enfant, Consultation consultation) {
		Enfant E = enfantRepository.findById(id_enfant).get();
		consultation.setEnfant(E);
		consultationRepository.save(consultation);
		return consultation;
	}

	@Override
	public List<Consultation> Search(String word) {
		return (List<Consultation>) consultationRepository.searchConsultation(word);
	}

	@Override
	public int getnbConsultation() {
		return consultationRepository.getNombresConsultation();
	}
/*
	@Override
	public int getnbConsultationByEnfant(String id_enfant) {
		return consultationRepository.getNombresConsultationByEnfant(id_enfant);
	}

	
	
	@Override
	public List<Consultation> Search(String word) {
		return (List<Consultation>) consultationRepository.searchEnfant(word);
	}
	*/


}
