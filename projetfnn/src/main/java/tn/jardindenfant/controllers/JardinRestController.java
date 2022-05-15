package tn.jardindenfant.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.usertype.UserType;
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


import tn.jardindenfant.entities.Jardin;
import tn.jardindenfant.services.JardinService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Jardin")

public class JardinRestController {
	
	@Autowired
	JardinService jardinService;
	
	// http://localhost:8088/Jardin/retrieve-all-jardin
			@GetMapping("/retrieve-all-jardin")
			@ResponseBody
			public List<Jardin> getJardin() {
				System.out.println("ggggg");
				
				List<Jardin> list = jardinService.getAllJardins();
				System.out.println(list);
				return list;
			}


			// http://localhost:8088/Jardin/ajouterJardin
			@PostMapping("/ajouterJardin")
			@ResponseBody
			public Jardin ajouterjardin(@RequestBody Jardin jard) {
				
				Jardin jard1 = jardinService.ajouterJardin(jard);
				return jardinService.ajouterJardin(jard1);
				
			}
			
			// http://localhost:8088/Evenement/updateJardin
			@PutMapping("/updateJardin")
			@ResponseBody
			public Jardin updateJardin(@RequestBody Jardin jard) {
				
				Jardin jard1 = jardinService.updateJardin(jard);
				return jardinService.updateJardin(jard1);
			}

			// http://localhost:8088/Jardin/remove-jardin{id}
			@DeleteMapping("/remove-jardin/{id}")
			@ResponseBody
			public void deleteJardin(@PathVariable("id") Long Id) {
				jardinService.deleteJardinById(Id);
			}
			
			// http://localhost:8088/Jardin/retrieve-Jardinbyuser
			@GetMapping("/retrieve-Jardinbyuser/{user-id}")
			@ResponseBody
			public Jardin searchjardinbyId(@PathVariable("user-id") UserType user) {
			return jardinService.selectjardinbyId(user);
			}

			
			// http://localhost:8088/Jardin/NombreJardin
			@GetMapping("/NombreJardin")
			@ResponseBody
			public int getNombreJardin() {
				return jardinService.getNombreJardin();
			}
			
			// http://localhost:8088/Evenement/retrieve-EventById
						@GetMapping("/retrieve-EventById")
						@ResponseBody
						public Optional <Jardin>  findEventById(int idjard) {
							System.out.println("ggggg");
					
							
							Optional<Jardin> list = jardinService.findEventById(idjard);
							System.out.println(list);
							return list;
						}
	}


