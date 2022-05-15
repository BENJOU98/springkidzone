package tn.jardindenfant.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.jardindenfant.repositories.JardinRepository;
import tn.jardindenfant.entities.Jardin;


@Service
public class JardinServiceImpl implements JardinService {

	@Autowired
	JardinRepository jardinRepository;
	
	
	public Jardin selectjardinbyId(UserType u) {
		return	jardinRepository.selectjardinbyId(u);
	}
	
	@Override
	public Jardin ajouterJardin (Jardin jard) {
		return jardinRepository.save(jard);
	}
	
	@Override
	public Jardin saveJardin(Jardin jard) {
		return jardinRepository.save(jard);
	}

	@Override
	public Jardin updateJardin(Jardin jard) {
		return jardinRepository.save(jard);
	}

	@Override
	public void deleteJardin(Jardin jard) {
		jardinRepository.delete(jard);
		
	}

	@Override
	public void deleteJardinById (Long id) {
		jardinRepository.deleteById(id);
		
	}

	@Override
	public Jardin getJardin(Long id) {
		return jardinRepository.findById(id).get();
	
	}

	@Override
	public List<Jardin> getAllJardins() {
		return jardinRepository.findAll();
	}

	@Override
	public int getNombreJardin() {
		return jardinRepository.getNombreJardin();
	}

	public Optional<Jardin> findEventById(int idjard) {
		return jardinRepository.findById((long) idjard);
	}
}
