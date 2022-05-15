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
import tn.jardindenfant.services.ReponseServiceImpl;
import tn.jardindenfant.entities.Reponse;

@RestController
@CrossOrigin("*")
public class ReponseController {
	
	@Autowired
	ReponseServiceImpl reponseService;
	
	@Autowired
	SujetServicesImpl sujetserviceImpl;
	
	@PostMapping("/sujets/{sujet_id}/reponses/add-reponse")
	@ResponseBody
	public Reponse ajouterReponse(@PathVariable("sujet_id")int sujet_id,@RequestBody Reponse reponse) {
		reponseService.affecterReponseToSujet(sujet_id, reponse);
		return reponse;
	}
	@GetMapping("/sujets/{sujet_id}/reponses")
	public List<Reponse> getAllReponsesBySujet(@PathVariable("sujet_id") int sujet_id){
		return reponseService.Allreponseinsujet(sujet_id);
	}
	
	@PutMapping("/sujets/{sujet_id}/reponses/add-reponse")
	@ResponseBody
	public Reponse modifierReponse(@PathVariable("forum_id") int forum_id,@PathVariable("sujet_id")int sujet_id,@RequestBody Reponse reponse) {
		reponseService.affecterReponseToSujet(sujet_id, reponse);
		return reponse;
	}
	


	@GetMapping("/get-reponses")
	public List<Reponse> getAllReponses(){
		return reponseService.getAllReponses();
	}
	
	
	@GetMapping("/reponses/{reponse_id}")
	public Reponse getReponseById(@PathVariable("reponse_id") int reponse_id) {
		return reponseService.getReponseById(reponse_id);		
	}
	

	@DeleteMapping("/reponses/{reponse_id}")
	public void deleteReponse(@PathVariable("reponse_id") int reponse_id) {
		reponseService.suppReponse(reponse_id);
	}
}
