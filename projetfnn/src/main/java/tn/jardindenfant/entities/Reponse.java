package tn.jardindenfant.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import tn.jardindenfant.entities.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Reponse")
public class Reponse implements Serializable {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="message")
	private String message;
	
	
	private LocalDate dateCreation = LocalDate.now();
	


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="sujet_id")
	Sujet sujet;
	
	
	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Reponse(int id, String message, LocalDate dateCreation, Sujet sujet) {
		super();
		this.id = id;
		this.message = message;
		this.dateCreation = dateCreation;
		this.sujet = sujet;
	}


	public Reponse(int id, String message, LocalDate dateCreation) {
		super();
		this.id = id;
		this.message = message;
		this.dateCreation = dateCreation;
	}
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Reponses [id_reponse=" + id + ", message=" + message + ", dateCreation=" + dateCreation
				+ ", sujet=" + sujet + "]";
	}


	public Sujet getSujet() {
		return sujet;
	}


	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}
	
	
	


}
