package tn.jardindenfant.controllers;


import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.itextpdf.text.DocumentException;

import tn.jardindenfant.entities.pdf;

import tn.jardindenfant.entities.Rendez_vous;
import tn.jardindenfant.services.RdvService;
@CrossOrigin("*")
@RestController
public class RdvController {
	
	@Autowired
	RdvService rdvService;
	
	
		@GetMapping("/retrieve-all-Rendez_vous")
		@ResponseBody
		public List <Rendez_vous> getRendez_vous() {
		List <Rendez_vous> listRdv = rdvService.getAllRendez_vous();
		return listRdv;
		}
		
		
		@GetMapping("/retrieve-Rendez_vous/{Rendez_vous-id}")
		@ResponseBody
		public Rendez_vous retrieveRendez_vous(@PathVariable("Rendez_vous-id") Long idRdv) {
		return rdvService.getRendez_vous(idRdv);
		}

	
		@PostMapping("/add-Rendez_vous")
		@ResponseBody
		public Rendez_vous addRendez_vous(@RequestBody Rendez_vous o)
		{
			Rendez_vous Rendez_vous = rdvService.saveRendez_vous(o);
		return Rendez_vous;
		}
		
		
		@DeleteMapping("/remove-Rendez_vous/{Rendez_vous-id}")
		@ResponseBody
		public void removeRendez_vous(@PathVariable("Rendez_vous-id") Long idRdv) {
			rdvService.deleteRendez_vousById(idRdv);
		}

		
		@PutMapping("/modify-Rendez_vous")
		@ResponseBody
		public Rendez_vous modifyRendez_vous(@RequestBody Rendez_vous rdv) {
		return rdvService.updateRendez_vous(rdv);
		}
		
        
         @GetMapping("/export/pdf")
         public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
             response.setContentType("application/pdf");
             DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
             String currentDateTime = dateFormatter.format(new Date());
              
             String headerKey = "Content-Disposition";
             String headerValue = "attachment; filename=meetings_" + currentDateTime + ".pdf";
             response.setHeader(headerKey, headerValue);
              
             List <Rendez_vous> listRdv = rdvService.getAllRendez_vous();
              
             pdf exporter = new pdf(listRdv);
             exporter.export(response);
              
         }

		
		

}
