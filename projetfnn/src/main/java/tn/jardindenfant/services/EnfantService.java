package tn.jardindenfant.services;

import java.util.List;
import java.util.Map;


import org.springframework.web.multipart.MultipartFile;
import tn.jardindenfant.entities.Enfant;


public interface EnfantService {
	List<Enfant> retrieveAllEnfant();
	Enfant addEnfant(Enfant e);
	void deleteEnfant(String id);
	Enfant updateEnfant(Enfant e );
	Enfant retrieveEnfant(String id);
	public List<Enfant> Search(String word);
	public int getnbEnfant();
	public int getnbG();
	public int getnbF();
	public void saveImage(MultipartFile file);
	//public List<Enfant>pdf();
	/*void affecterEnfantAparent(int EnfantId, int parentId) ;*/

}
