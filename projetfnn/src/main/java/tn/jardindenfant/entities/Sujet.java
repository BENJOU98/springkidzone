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
@Table(name="Sujet")
public class Sujet implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="titre")
	private String titre;
	@Column(name="description")
	private String description;
	
	
	private LocalDate dateCreation = LocalDate.now();
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_forum")
	Forum forum;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="sujet")
	@Column(name="Reponses")
	private Set<Reponse> reponse;

	public Sujet() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sujet(int id, String titre, String description, LocalDate dateCreation, Forum forum) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dateCreation = dateCreation;
		this.forum = forum;
	}


	public Sujet(int id, String titre, String description, LocalDate dateCreation) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dateCreation = dateCreation;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Forum getForum() {
		return forum;
	}


	public void setForum(Forum forum) {
		this.forum = forum;
	}


	@Override
	public String toString() {
		return "Sujet [id=" + id + ", titre=" + titre + ", description=" + description + ", dateCreation="
				+ dateCreation + ", forum=" + forum + "]";
	}


	
	



	
	
	
	

}

