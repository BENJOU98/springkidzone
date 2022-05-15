package tn.jardindenfant.services;
import tn.jardindenfant.services.*;
import tn.jardindenfant.entities.*;
import tn.jardindenfant.repositories.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class PublicationService implements IPublicationService {

	@Autowired
	PublicationRepository publicationRep;

	@Autowired
	UserRepository userRep;
	private final Path root = Paths.get("C:/Users/MSI/Desktop/Versionle29sansmodule/Versionle29sansmodule/miniprojet4/src/assets/img/PubPic");



	
	
	@Override
	public String AddPublication(Publication pub) {
		
		//retrieveUser
		
		
	

			publicationRep.save(pub);
			
	
		return "pub added successfully";


	}


	@Override
	public List<Publication> RetrievePublication() {
		// TODO Auto-generated method stub
		List<Publication> pub = (List<Publication>) publicationRep.findAll();
		return pub;
	}

	@Override
	public void UpdatePublicationById(Publication pub, int id) {
		// TODO Auto-generated method stub

		this.publicationRep.save(pub);
	}


	@Override
	public void DeletePublication(int id) {
		// TODO Auto-generated method stub

		this.publicationRep.deleteById(id);

	}


	@Override
	public Publication GetPubById(int pubId) {
		// TODO Auto-generated method stub

		return publicationRep.findById(pubId).get();

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
