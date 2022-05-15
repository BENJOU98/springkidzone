package tn.jardindenfant.controllers;


import tn.jardindenfant.entities.*;
import tn.jardindenfant.repositories.*;
import tn.jardindenfant.services.*;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;





@RestController
@RequestMapping("/pi")
@CrossOrigin("*")
public class PublicationControllerImp  {
	
	@Autowired
	IPublicationService pub_service;
	@Autowired
	UserRepository user_rep;
	@Autowired
	PublicationRepository pub_rep;
	@Autowired
	CommentsRepository com_rep;
	private byte[] bytes;
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	@GetMapping("/RetrievePublication")
	public List<Publication> retrieveAllPublications(){
		List<Publication> pub = pub_service.RetrievePublication();
		return pub;
	}
	

	
	@PostMapping("/AddPublication")
	public String AddPub(@RequestBody Publication pub) throws Exception{
		this.bytes = null;
		
		
		
		
		
		return pub_service.AddPublication(pub);
		
		
		
	}
	
	@PutMapping("/UpdatePublication/{id}")
	public String UpdatePub(@PathVariable("id") int id ,@RequestBody Publication pub) {
		pub.setId(id);
		
			this.pub_service.UpdatePublicationById(pub, id);	
			
		
		return "pub Update successfully";
	}
	
	@DeleteMapping("remove-publication/{id}")
	public void DeletePub(@PathVariable("id") int id){
		this.pub_service.DeletePublication(id);
	}
	
	@GetMapping("RetrievePublication/{id}")
	public Publication getPubByID(@PathVariable(value = "id")int id){
		
		
		return pub_service.GetPubById(id);
		
	}
	
	@GetMapping("RetrieveComments/{id}")
	public List<Comments> retrieveCOmmentsById(@PathVariable(value = "id")int id){
		
		return com_rep.RelevantComments(id);
	}
	
	
	@PostMapping("/uploadImage")
	  public void uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      pub_service.saveImage(file);
	    System.out.print( message = "Uploaded the file successfully: " + file.getOriginalFilename());
	    } catch (Exception e) {
	    	
	    	System.out.print(  message = "Could not upload the file: " + file.getOriginalFilename() + "!");
	    }
	}
	
	@GetMapping("/retrieve-all-reclamationsByUser/{user-id}")
	@ResponseBody
    public List<Publication> getReclamationsByUser(@PathVariable("user-id") Long id) {
		System.out.println("azz");
		List<Publication> r =  pub_service.RetrievePublication();
		System.out.println("ffff");
		List<Publication> ru =new ArrayList<>();
		System.out.println("yyyy");
		for (Publication re : r) {
			System.out.println("wwww");
			System.out.println(re.getUser());
			if (re.getUser().getIdUser()==id) {
				ru.add(re);
				System.out.println("zied");
			}
		}

		return ru ;
	}

}
