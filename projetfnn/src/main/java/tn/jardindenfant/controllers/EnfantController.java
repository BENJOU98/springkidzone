package tn.jardindenfant.controllers;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.service.EnfantService;*/

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import io.swagger.annotations.Api;
import tn.jardindenfant.entities.*;
import tn.jardindenfant.repositories.EnfantRepository;
import tn.jardindenfant.services.*;

@CrossOrigin("http://localhost:4200")
@RestController
@Api(tags = "Gestion des enfants")
@RequestMapping("/enfant")
public class EnfantController {
	public static String uploadDirectory = System.getProperty("user.home") + "/Downloads/";
	
	
	@Autowired
	EnfantService EnfantService;
	
	@Autowired
	EnfantRepository EnfantRepo;

	private List<Enfant> enfants;
	private String word;
	// http://localhost:8070/enfant/retrieveAllEnfant
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/retrieveAllEnfant")
	@ResponseBody
	public List<Enfant> getAllEnfants( ) {
		return EnfantService.retrieveAllEnfant();
		}
	
	// http://localhost:8070/enfant/retrieve-enfant/{enfant-id}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/retrieve-enfant/{enfant-id}")
	@ResponseBody
	public Enfant retrieveEnfant(@PathVariable("enfant-id") String EnfantId) {
	return EnfantService.retrieveEnfant(EnfantId);
	}

	private byte[] bytes;
	// http://localhost:8070/enfant/add-enfant
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/add-enfant")
	@ResponseBody
	public Enfant addEnfant(@RequestBody Enfant e) throws Exception {
		this.bytes = null;
		return EnfantService.addEnfant(e);

	}


	@PostMapping("/uploadImage")
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			EnfantService.saveImage(file);
			System.out.print( message = "Uploaded the file successfully: " + file.getOriginalFilename());
		} catch (Exception e) {

			System.out.print(  message = "Could not upload the file: " + file.getOriginalFilename() + "!");
		}
	}

	// http://localhost:8070/enfant/remove-enfant/{enfant-id}
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/remove-enfant/{enfant-id}")
	@ResponseBody
	public void deleteEnfant(@PathVariable("enfant-id") String enfantId) {
	EnfantService.deleteEnfant(enfantId);
	}

	// http://localhost:8070/enfant/modify-enfant
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/modify-enfant")
	@ResponseBody
	public Enfant updateEnfant(@RequestBody Enfant enfant) {
	return EnfantService.updateEnfant(enfant);
	}
	
	// http://localhost:8070/enfant/Recherche/{nomenfant}
	@GetMapping("/recherche/{nomenfant}")
	@ResponseBody
	public List<Enfant> findBynomenfant(@PathVariable("nomenfant") String nomenfant) {
		return EnfantService.Search(nomenfant);
	}
	
	

	
	
	// http://localhost:8070/enfant/NbreEnfant
	@GetMapping("/NbreEnfant")
	@ResponseBody
	public int getNombreEnfant() {
		return EnfantService.getnbEnfant();
	}
	
	// http://localhost:8070/enfant/NbreGarçons
	@GetMapping("/NbreGarçons")
	@ResponseBody
	public int getNombreGarçon() {
		return EnfantService.getnbG();
	}
	
	// http://localhost:8070/enfant/NbreFilles
	@GetMapping("/NbreFilles")
	@ResponseBody
	public int getNombreFille() {
		return EnfantService.getnbF();
	}
	
	
	 @GetMapping("/export/excel")
	 @ResponseBody
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	    	System.out.println("Export to Excel ...");
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Enfant_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	        List<Enfant> listenfant = EnfantService.retrieveAllEnfant();
	        EnfantExcel excel = new EnfantExcel(listenfant);
	        excel.export(response);    
	    }  

		@ResponseBody
	    @RequestMapping(value = "/export/pdf", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> exportToPdf() {

	        List<Enfant> enfants = (List<Enfant>) EnfantService.retrieveAllEnfant();

	        ByteArrayInputStream bis = EnfantPdf.Enfants(enfants);
		    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		    String currentDateTime = dateFormatter.format(new Date());
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=Enfant_list_"+ currentDateTime +".pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }


/*		
	    @PostMapping("/upload/image")
	    public ResponseEntity uplaodImage(@RequestParam("image") MultipartFile file)
	            throws IOException {

	    	EnfantService.addEnfant(Enfant.builder().image(EnfantImage.compressImage(file.getBytes())).build());
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(file.getOriginalFilename());
	    }

	    @GetMapping(path = {"/get/image/info/{name}"})
	    public Enfant getImageDetails(@PathVariable("name") String name) throws IOException {

	        final Optional<Enfant> dbImage = imageRepository.findByName(name);

	        return Image.builder()
	                .name(dbImage.get().getName())
	                .type(dbImage.get().getType())
	                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
	    }

	    @GetMapping(path = {"/get/image/{name}"})
	    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

	        final Optional<Image> dbImage = imageRepository.findByName(name);

	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.valueOf(dbImage.get().getType()))
	                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
	    }
	    */
		
		/*
	    // define a location
	    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/";

	    // Define a method to upload files
	    @PostMapping("/upload")
	    @ResponseBody
	    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
	        List<String> filenames = new ArrayList<>();
	        for(MultipartFile file : multipartFiles) {
	            String filename = StringUtils.cleanPath(file.getOriginalFilename());
	            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
	            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
	            filenames.add(filename);
	        }
	        return ResponseEntity.ok().body(filenames);
	    }*/
		
		@GetMapping("/retrieve-all-reclamationsByUser/{user-id}")
		@ResponseBody
	    public List<Enfant> getReclamationsByUser(@PathVariable("user-id") Long id) {
			System.out.println("azz");
			List<Enfant> r =  EnfantService.retrieveAllEnfant();
			System.out.println("ffff");
			List<Enfant> ru =new ArrayList<>();
			System.out.println("yyyy");
			for (Enfant re : r) {
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
