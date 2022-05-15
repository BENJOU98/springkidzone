package tn.jardindenfant.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
	private String 	nom;
	private String 	prenom;
	private String numero;
	private Date dateNaissance;
	private String email;
	private String password;
	private String urlpicture;
	private String token;
	
	
	@Enumerated(EnumType.STRING)
	Badge badge;
	//zied 
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE) 
	@JsonIgnore
	List<Publication> publications = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade = CascadeType.REMOVE,fetch=FetchType.EAGER)
	List<Comments> comments= new ArrayList<>();
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE) 
	@JsonIgnore
	List<Enfant> enfants = new ArrayList<>();
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE) 
	@JsonIgnore
	List<Enfant> reclamations = new ArrayList<>();
	





	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", email=" + email + ", password=" + password + ", badge =" + badge
				+ "]";
	}
	//zied

	//zied
	
}
