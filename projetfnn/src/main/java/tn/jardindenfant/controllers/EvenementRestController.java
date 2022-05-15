package tn.jardindenfant.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import tn.jardindenfant.entities.Evenement;
import tn.jardindenfant.services.EvenementService;
import tn.jardindenfant.services.JardinService;


@CrossOrigin("*")
@RestController
@RequestMapping("/Evenement")
public class EvenementRestController {

	
	@Autowired
	EvenementService evenementService;
	JardinService jardinService;
	
	// http://localhost:8088/Evenement/retrieve-all-evenement
				@CrossOrigin("http://localhost:4200")
				@GetMapping("/retrieve-all-evenement")
				@ResponseBody
				public List<Evenement> getAllEvenements() {
					System.out.println("ggggg");
					
					List<Evenement> list = evenementService.getAllEvenements();
					System.out.println(list);
					return list;
				}
				
				
				// http://localhost:8088/Evenement/Search-by-titre-description-prix
				@GetMapping("/Searchbyall")
				@ResponseBody
				public List<Evenement> Search(String word) {			
					List<Evenement> list = evenementService.Search(word);
					return list;
				}
				/*
				// http://localhost:8088/Evenement/retrieve-all-archivedEvent
				@GetMapping("/retrieve-all-archivedEvent")
				@ResponseBody
				public List<Evenement> findArchivedEvent() {
					System.out.println("ggggg");
			
					
					List<Evenement> list = evenementService.findArchivedEvent();
					System.out.println(list);
					return list;
				}
				*/
				// http://localhost:8088/Evenement/retrieve-EventById
				@GetMapping("/retrieve-EventById")
				@ResponseBody
				public Optional <Evenement>  findEventById(int idEvent) {
					System.out.println("ggggg");
			
					
					Optional<Evenement> list = evenementService.findEventById(idEvent);
					System.out.println(list);
					return list;
				}
				
				
				// http://localhost:8088/Evenement/remove-evenement/{id}
				@CrossOrigin("http://localhost:4200")
				@DeleteMapping("/remove-evenement/{id}")
				@ResponseBody
				public void deleteEvenement(@PathVariable("id") int idEvent ) {
					
					evenementService.deleteEvenementById(idEvent);
				}
				
				// http://localhost:8088/Evenement/ajouterEvenement
				@PostMapping("/ajouterEvenement")
				@ResponseBody
				public Evenement ajouterEvenement(@RequestBody Evenement event) {
					
					Evenement event1 = evenementService.ajouterEvenement(event);
					return evenementService.ajouterEvenement(event1);
					
				}
				
				// http://localhost:8088/Evenement/updateEvenement
				@CrossOrigin("http://localhost:4200")
				@PutMapping("/updateEvenement")
				@ResponseBody
				public Evenement updateEvenement(@RequestBody Evenement event) {
					
					Evenement event1 = evenementService.updateEvenement(event);
					return evenementService.updateEvenement(event1);
				}


}
