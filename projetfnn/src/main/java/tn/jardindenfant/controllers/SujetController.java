package tn.jardindenfant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.jardindenfant.entities.Forum;
import tn.jardindenfant.entities.Sujet;
import tn.jardindenfant.repositories.*;
import tn.jardindenfant.services.SujetServicesImpl;
import tn.jardindenfant.services.ForumServicesImpl;

@RestController
@CrossOrigin("*")
public class SujetController {
	
	@Autowired
	SujetServicesImpl sujetserviceImpl;
	
	@Autowired
	ForumServicesImpl forumServiceImpl;
	
	
	@PostMapping("/forum/{forum_id}/sujets/addsujet")
	@ResponseBody
	public Sujet ajouterSujet(@PathVariable("forum_id") int forum_id,@RequestBody Sujet sujet) {
		sujetserviceImpl.ajouterSujetToForum(forum_id, sujet);
		return sujet;
	}
	
	
	
	@PutMapping("/forum/{forum_id}/sujets/updatesujet")
	@ResponseBody
	public Sujet modifierSujet(@PathVariable("forum_id") int forum_id,@RequestBody Sujet sujet) {
		sujetserviceImpl.ajouterSujetToForum(forum_id, sujet);
		return sujet;
	}
	
	@PutMapping("/updatesujet")
	@ResponseBody
	public Sujet updateForum(@RequestBody Sujet sujet) {
		sujetserviceImpl.update(sujet);
		return sujet;
	}
	
	@GetMapping("/forum/{forum_id}/sujets")
	public List<Sujet> getAllSujetINForum(@PathVariable("forum_id") int forum_id){
		return sujetserviceImpl.getAllSujetInForum(forum_id);
	}
	
	
	@GetMapping("/sujets")
	public List<Sujet> getAllSujet(){
		return sujetserviceImpl.getAllSujet();
	}
	

	@GetMapping("/sujets/{sujet_id}")
	public Sujet getSujetById(@PathVariable("sujet_id") int sujet_id) {
		return sujetserviceImpl.getSujetbyId(sujet_id);
		
	}
	

	@DeleteMapping("/sujet/{sujet_id}")
	public void deleteSujet(@PathVariable("sujet_id") int sujet_id) {
		sujetserviceImpl.deleteSujet2(sujet_id);
	}
	
	@GetMapping("/sujets/nbr")
	public Long NBRSujets(){
		return sujetserviceImpl.getNombresSujet();
	}
	@GetMapping("{forum_id}/sujets/nbr")
	public Long NBRSujets2(@PathVariable("forum_id") int forum_id){
		return sujetserviceImpl.getNombresSujet2(forum_id);
	}
	

}
