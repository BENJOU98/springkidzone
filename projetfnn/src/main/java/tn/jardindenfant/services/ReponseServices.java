package tn.jardindenfant.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.jardindenfant.entities.Reponse;
import tn.jardindenfant.entities.Sujet;

public interface ReponseServices {
	
	public void save(Reponse rep);
	public Reponse addReponse(Reponse rep);
	public void suppReponse(int id_rep);
	public Reponse affecterReponseToSujet(int sujet_id, Reponse rep);
	public Reponse getReponseById(int id_rep);
	public List<Reponse> getAllReponses();
	public long getNombresReponses();
	public List<Reponse> Allreponseinsujet(int id_sujet);
}