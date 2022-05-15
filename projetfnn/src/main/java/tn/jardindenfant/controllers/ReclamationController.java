package tn.jardindenfant.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.jardindenfant.entities.Reclamation;
import tn.jardindenfant.services.EmailSenderService;
import tn.jardindenfant.services.ReclamationService;


@RestController
@CrossOrigin("*")
public class ReclamationController {
	
	@Autowired
	private ReclamationService reclamationService;
	@Autowired
	EmailSenderService emailSenderService ;
	
	// http://localhost:8070/SpringMVC/Reclamation/retrieve-all-Reclamation
	@GetMapping("/retrieve-all-Reclamation")
	//@ResponseBody
	public List <Reclamation>  getReclamation(Model model, @Param("keyword") String keyword) {
	List <Reclamation> listReclamation = reclamationService.getAllReclamation(keyword);
	model.addAttribute("listeReclamations", listReclamation);
    model.addAttribute("keyword", keyword);
	return listReclamation;
	}
	
	@GetMapping("/page/{pageNum}")
	public List <Reclamation> viewPage(Model model,  @PathVariable(name = "pageNum") int pageNum) {
		 Page <Reclamation> page = reclamationService.listAll(pageNum);
		
	     
	    List<Reclamation> listReclamation = page.getContent();
	     
	    model.addAttribute("currentPage", pageNum);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("listReclamation", listReclamation);
	     
	    return listReclamation;
	}
	
	// http://localhost:8089/SpringMVC/Reclamation/retrieve-operateur/8
	@GetMapping("/retrieve-Reclamation/{Reclamation-id}")
	@ResponseBody
	public Reclamation retrieveReclamation(@PathVariable("Reclamation-id") Long idReclamation) {
	return reclamationService.getReclamation(idReclamation);
	}

	// http://localhost:8070/SpringMVC/Reclamation/add-Reclamation
	@PostMapping("/add-Reclamation")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation o)
	{
		Reclamation reclamation = reclamationService.saveReclamation(o);
		emailSenderService.SendEmail("oussema.benjabli@esprit.tn", "Reclamation", "votre reclamation est bien recu");
	return reclamation;
	}
	// http://localhost:8089/SpringMVC/Reclamation/remove-Reclamation/{Reclamation-id}
	@DeleteMapping("/remove-Reclamation/{Reclamation-id}")
	@ResponseBody
	public void removeReclamation(@PathVariable("Reclamation-id") Long idReclamation) {
		reclamationService.deleteReclamationById(idReclamation);
	}

	// http://localhost:8089/SpringMVC/operateur/modify-operateur
	@PutMapping("/modify-operateur")
	@ResponseBody
	public Reclamation modifyReclamation(@RequestBody Reclamation rec) {
	return reclamationService.updateReclamation(rec);
	}

}
