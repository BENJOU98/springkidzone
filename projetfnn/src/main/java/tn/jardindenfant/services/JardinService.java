package tn.jardindenfant.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.usertype.UserType;

import tn.jardindenfant.entities.Jardin;

public interface JardinService {

		Jardin saveJardin(Jardin jard);
		Jardin updateJardin(Jardin jard);
		void deleteJardin(Jardin jard);
		void deleteJardinById(Long id);
		Jardin getJardin(Long id);
		List <Jardin> getAllJardins();
		Jardin ajouterJardin(Jardin jard);
		Jardin selectjardinbyId(UserType user);
		public int getNombreJardin();
		Optional<Jardin> findEventById(int idjard);
		
}
