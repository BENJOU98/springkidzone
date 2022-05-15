package tn.jardindenfant.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Evenement {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idevent;
	private String description_event;
	private String nom_event;
	private Date date_event;
	private Date heure_event;
	private String lieu_event;
	@Column(columnDefinition = "integer default 2", name = "etat")
	private int etat;
	
	
	public int getEtat() {
		return etat;
	}



	public void setEtat(int etat) {
		this.etat = etat;
	}



	public long getIdevent() {
		return idevent;
	}



	public void setIdevent(long idevent) {
		this.idevent = idevent;
	}



	public String getDescription_event() {
		return description_event;
	}


	public void setDescription_event(String description_event) {
		this.description_event = description_event;
	}

	public String getNom_event() {
		return nom_event;
	}

	public void setNom_event(String nom_event) {
		this.nom_event = nom_event;
	}

	public Date getDate_event() {
		return date_event;
	}



	public void setDate_event(Date date_event) {
		this.date_event = date_event;
	}



	public Date getHeure_event() {
		return heure_event;
	}



	public void setHeure_event(Date heure_event) {
		this.heure_event = heure_event;
	}



	public String getLieu_event() {
		return lieu_event;
	}



	public void setLieu_event(String lieu_event) {
		this.lieu_event = lieu_event;
	}

	


public Evenement() {
	super();
	// TODO Auto-generated constructor stub
	
	
}


public Evenement(String description_event, String nom_event, Date date_event, Date heure_event, String lieu_event) {
	super();
	this.description_event = description_event;
	this.nom_event = nom_event;
	this.date_event = date_event;
	this.heure_event = heure_event;
	this.lieu_event = lieu_event;
	this.etat= etat;
	
}



@Override
public String toString() {
	return "Evenement [idevent=" + idevent + ", description_event=" + description_event + ", nom_event=" + nom_event
			+ ", date_event=" + date_event + ", heure_event=" + heure_event + ", lieu_event=" + lieu_event + "]";
}
}

