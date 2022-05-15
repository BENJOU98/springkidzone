package tn.jardindenfant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.jardindenfant.entities.Consultation;
import tn.jardindenfant.services.ConsultationService;

@CrossOrigin("http://localhost:4200")
@RestController
@Api(tags = "Gestion des consultations")
@RequestMapping("/Consultation")
public class ConsultationController {

	@Autowired
	ConsultationService ConsultationService;
	
	// http://localhost:8070/Consultation/retrieveAllConsultation
	@GetMapping("/retrieveAllConsultation")
	@ResponseBody
	public ResponseEntity<List<Consultation>> getAllConsultations( ) {

		return new ResponseEntity<>(ConsultationService.retrieveAllConsultation(),HttpStatus.OK) ;
		}
	
	// http://localhost:8070/Consultation/retrieve-Consultation/{Consultation-id}
	@GetMapping("/retrieve-Consultation/{Consultation-id}")
	@ResponseBody
	public Consultation retrieveConsultation(@PathVariable("Consultation-id") String ConsultationId) {
	return ConsultationService.retrieveConsultation(ConsultationId);
	} 
	

	
	// http://localhost:8070/Consultation/add-consultation
	@PostMapping("/add-consultation")
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Consultation> addConsultation(@RequestBody Consultation c) {
	//ConsultationService.affecterConsultationToEnfant(c);
	return new ResponseEntity<>(ConsultationService.addConsultation(c), HttpStatus.CREATED);
	}
	
	
	// http://localhost:8070/Consultation/remove-Consultation/{Consultation-id}
	@DeleteMapping("/remove-Consultation/{Consultation-id}")
	@ResponseBody
	public void deleteConsultation(@PathVariable("Consultation-id") String ConsultationId) {
	ConsultationService.deleteConsultation(ConsultationId);
	}

	// http://localhost:8070/Consultation/modify-Consultation
	@PutMapping("/modify-Consultation")
	@ResponseBody
	public Consultation updateConsultation(@RequestBody Consultation Consultation) {
	return ConsultationService.updateConsultation(Consultation);
	}
	
	// http://localhost:8070/Consultation/NbreConsultation
	@GetMapping("/NbreConsultation")
	@ResponseBody
	public int getNombreConsultation() {
		return ConsultationService.getnbConsultation();
	}	
	
	// http://localhost:8070/Consultation/Recherche/{maladie}
	@GetMapping("/recherche/{nomenfant}")
	@ResponseBody
	public List<Consultation> findByConsByMaladie(@PathVariable("maladie") String maladie) {
		return ConsultationService.Search(maladie);
	}
	/*
	// http://localhost:8070/Consultation/{id_enfant}/NbreConsultation
	@GetMapping("{id_enfant}/NbreConsultation")
	@ResponseBody
	public int NombreConsultationEnfant(@PathVariable("id_enfant") String idenfant) {
		return ConsultationService.getnbConsultationByEnfant(idenfant);
	}
	*/
	
 
}
