package tn.jardindenfant.services;

import java.util.List;

import tn.jardindenfant.entities.Sujet;

public interface SujetServices {
	public void update(Sujet sujet);
	public Sujet ajouterSujet(Sujet sujet);
	public Sujet ajouterSujetToForum(int id_forum,Sujet sujet);
	public void deleteSujet(int id_sujet);
	public void deleteSujetById(Integer id);
	public Sujet getSujetbyId(int id_sujet);
	
	public List<Sujet> getAllSujet();
	
	public List<Sujet> getAllSujetInForum(int id_forum);
	void deleteSujet2(int s);
	long getNombresSujet();
	long getNombresSujet2(Integer id);

	
	
	
}

