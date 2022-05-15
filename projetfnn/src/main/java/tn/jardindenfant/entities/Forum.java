package tn.jardindenfant.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Forum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String titre;
	
	private String description;
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "forum")
	@Column(name="sujets")
	private Set<Sujet> sujets;

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

	public Set<Sujet> getSujets() {
		return sujets;
	}

	public void setSujets(Set<Sujet> sujets) {
		this.sujets = sujets;
	}

	public String getDescription() {
		return description;
	}

	public Forum(int id, String titre, String description, Set<Sujet> sujets) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.sujets = sujets;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Forum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Forum(int id, String titre, String description) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Forum [id=" + id + ", titre=" + titre + ", description=" + description + "]";
	}

}
