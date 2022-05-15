package tn.jardindenfant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.jardindenfant.entities.*;
import tn.jardindenfant.repositories.*;
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
public class ReponseServiceImpl implements ReponseServices{
	
	@Autowired
	ReponseRepository reponseRepository;
	
	@Autowired
	SujetRepository sujetRepository;

	@Override
	public void save(Reponse rep) {
		// TODO Auto-generated method stub
		reponseRepository.save(rep);
	}

	@Override
	public Reponse addReponse(Reponse rep) {
		// TODO Auto-generated method stub
		reponseRepository.save(rep);
		return rep;
	}

	@Override
	public void suppReponse(int id_rep) {
		// TODO Auto-generated method stub
		reponseRepository.deleteById(id_rep);
	}

	@Override
	public Reponse affecterReponseToSujet(int sujet_id, Reponse rep) {
		Sujet S = sujetRepository.findById(sujet_id).get();
		rep.setSujet(S);
		reponseRepository.save(rep);
		return rep;
	}

	@Override
	public Reponse getReponseById(int id_rep) {
		// TODO Auto-generated method stub
		return reponseRepository.findById(id_rep).get();
	}

	@Override
	public List<Reponse> getAllReponses() {
		// TODO Auto-generated method stub
		List<Reponse> reponses = new ArrayList<Reponse>();
		reponseRepository.findAll().forEach(rep -> reponses.add(rep));
		return reponses;
	}

	@Override
	public long getNombresReponses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reponse> Allreponseinsujet(int sujet_id) {
		List<Reponse> reponses = new ArrayList<Reponse>();
		reponseRepository.findAllBySujetId(sujet_id).forEach(rep -> reponses.add(rep));
		return reponses;
		
		
		
	}

	

}
