package tn.jardindenfant.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.jardindenfant.entities.Forum;

import tn.jardindenfant.entities.*;
import tn.jardindenfant.repositories.ForumRepository;
import tn.jardindenfant.repositories.SujetRepository;
import tn.jardindenfant.services.*;

@Service
public class ForumServicesImpl implements ForumServices{
 
	@Autowired
	ForumRepository ForumRepository;
	@Autowired
	SujetRepository SujetRepository;
	@Override
	public Forum AjouterForum(Forum f) {
		return ForumRepository.save(f);
		
	}

	@Override
	public Forum updateForum(Forum f) {
		// TODO Auto-generated method stub
		return ForumRepository.save(f);
	}

	@Override
	public void deleteForum(Forum f) {
		// TODO Auto-generated method stub
		ForumRepository.delete(f);
	}

	@Override
	public void deleteForumById(Integer id) {
		// TODO Auto-generated method stub
		
		ForumRepository.deleteById(id);
	}

	@Override
	public Forum getForum(Integer id) {
		// TODO Auto-generated method stub
		return ForumRepository.findById(id).get();
	}

	@Override
	public List<Forum> getAllForum() {
		// TODO Auto-generated method stub
		return (List<Forum>) ForumRepository.findAll();
	}

	@Override
	public int ajouterSujetForum(int forum_id, int sujet_id) {
Sujet s = SujetRepository.findById(sujet_id).get();
		
		Forum f = ForumRepository.findById(forum_id).get();
		Set<Sujet> sujets  = new HashSet<Sujet>();
		sujets.add(s);
		f.setSujets(sujets);
		ForumRepository.save(f);
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Forum> findBynomforum(String type_forum) {
		return ForumRepository.findBynomforum(type_forum);
	}

	

}