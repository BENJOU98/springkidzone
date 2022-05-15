package tn.jardindenfant.services;
import tn.jardindenfant.services.*;
import tn.jardindenfant.entities.*;
import tn.jardindenfant.repositories.*;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;



public interface IPublicationService {
	
	
	public List<Publication> RetrievePublication();
	public void UpdatePublicationById(Publication pub, int id);
	public void DeletePublication(int id);
	public Publication GetPubById(int pubId);
	void saveImage(MultipartFile file);
	
	String AddPublication(Publication pub);
			
}
