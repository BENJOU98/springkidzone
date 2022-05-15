package tn.jardindenfant.services;

import java.util.List;

import tn.jardindenfant.entities.Consultation;
import tn.jardindenfant.entities.Enfant;

public interface ConsultationService {

	List<Consultation> retrieveAllConsultation();
	Consultation addConsultation(Consultation c);
	void deleteConsultation(String id);
	Consultation updateConsultation(Consultation c);
	Consultation retrieveConsultation(String id);
	Consultation affecterConsultationToEnfant(int id_enfant, Consultation consultation);
	public List<Consultation> Search(String word);
	public int getnbConsultation();
	//public int getnbConsultationByEnfant(String id_enfant);
	//public List<Consultation> Search(String word);
}

