package tn.jardindenfant.services;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import tn.jardindenfant.entities.Enfant;
import tn.jardindenfant.repositories.EnfantRepository;

@Service
public class EnfantServiceImpl implements EnfantService {
	private final Path root = Paths.get("C:/Users/MSI/Desktop/PI/Kidzone/src/assets/img/EnfantPic");


	@Autowired
	EnfantRepository enfantRepository;
	
	@Override
	public List<Enfant> retrieveAllEnfant() {
		return (List<Enfant>) enfantRepository.findAll() ;
	}

	
	@Override
	public Enfant addEnfant(Enfant e) {
    enfantRepository.save(e) ;
		return e;
	}

	@Override
	public void deleteEnfant(String id) {
		enfantRepository.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public Enfant updateEnfant(Enfant e) {
		enfantRepository.save(e) ;
		return e;
	}

	@Override
	public Enfant retrieveEnfant(String id) {
		return	enfantRepository.findById(Integer.parseInt(id)).orElse(null);
	}



	@Override
	public List<Enfant> Search(String word) {
		return (List<Enfant>) enfantRepository.searchEnfant(word);
	}


	@Override
	public int getnbEnfant() {
		return enfantRepository.getNombresEnfant();
	}


	@Override
	public int getnbG() {
		return enfantRepository.getNombresGarçon();
	}
	
	@Override
	public int getnbF() {
		return enfantRepository.getNombresFille();
	}


	@Override
	public void saveImage(MultipartFile  file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	
	
}
