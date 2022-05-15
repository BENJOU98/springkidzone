package tn.jardindenfant.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import  tn.jardindenfant.entities.Reclamation;
import tn.jardindenfant.repositories.ReclamationRepository;
@Service
public class ReclamationServiceImpl implements ReclamationService {
	@Autowired
	ReclamationRepository recalamationRepository;
	
	@Override
	public Reclamation saveReclamation(Reclamation rec) {
		
		return recalamationRepository.save(rec);
	}

	@Override
	public Reclamation updateReclamation(Reclamation rec) {
		return recalamationRepository.save(rec);
	}

	@Override
	public void deleteReclamation(Reclamation rec) {
		recalamationRepository.delete(rec);
		
	}

	@Override
	public void deleteReclamationById(Long id) {
		recalamationRepository.deleteById(id);
		
	}

	@Override
	public Reclamation getReclamation(Long id) {
		return recalamationRepository.findById(id).get();
		
	}

	@Override
	public List<Reclamation> getAllReclamation(String keyword) {
		
		if (keyword != null) {
            return recalamationRepository.search(keyword);
        }
	
		return recalamationRepository.findAll();
		}

	

	@Override
	public Page<Reclamation> listAll(int pageNum) {
		 int pageSize = 3;
	     
		    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		     
		    return recalamationRepository.findAll(pageable);
		
	}
	
	


}
