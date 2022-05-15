package tn.jardindenfant.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.jardindenfant.entities.Forum;

import tn.jardindenfant.entities.Sujet;
import tn.jardindenfant.repositories.ForumRepository;
import tn.jardindenfant.repositories.SujetRepository;

@Service
public class SujetServicesImpl implements SujetServices {

	@Autowired
	ForumRepository ForumRepository;
	@Autowired
	SujetRepository SujetRepository;
	@Override
	public void update(Sujet sujet) {
		// TODO Auto-generated method stub
 SujetRepository.save(sujet);
	}

	@Override
	public Sujet ajouterSujet(Sujet sujet) {
		// TODO Auto-generated method stub
		return SujetRepository.save(sujet);
	
	}

	@Override
	public Sujet ajouterSujetToForum(int id_forum, Sujet sujet) {
		Forum F = ForumRepository.findById(id_forum).get();
		sujet.setForum(F);
		SujetRepository.save(sujet);
		return sujet;
	}
	
	

	@Override
	public void deleteSujet(int id_sujet) {
		// TODO Auto-generated method stub
		SujetRepository.deleteById(id_sujet);
		
	}

	@Override
	public void deleteSujet2(int sujet_id) {
		// TODO Auto-generated method stub
		Sujet s = SujetRepository.findById(sujet_id).get();
		SujetRepository.delete(s);
		
	}
	@Override
	public Sujet getSujetbyId(int id_sujet) {
		// TODO Auto-generated method stub
		return SujetRepository.findById(id_sujet).get();		
	}

	@Override
	public List<Sujet> getAllSujet() {
		return (List<Sujet>) SujetRepository.findAll();
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sujet> getAllSujetInForum(int id_forum) {
		// TODO Auto-generated method stub
		List<Sujet> sujets = new ArrayList<Sujet>();
		SujetRepository.findAllByForumId(id_forum).forEach(sujet -> sujets.add(sujet));
		return sujets;
	}

	@Override
	public void deleteSujetById(Integer id) {
		// TODO Auto-generated method stub
		SujetRepository.deleteById(id);
	}
	
	@Override
	public long getNombresSujet() {
		return Long.valueOf(SujetRepository.getNombresSujet());
	}
	@Override
	public long getNombresSujet2(Integer id) {
		return Long.valueOf(SujetRepository.getNombresSujet2(id));
	}

	
	
}
