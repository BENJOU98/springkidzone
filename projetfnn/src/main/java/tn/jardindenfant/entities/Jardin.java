package tn.jardindenfant.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jardin {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idjardin;
	private String adresse;
	private int capacite;
	private String name;
	private String email;
	private int tel;
	private int delegue_id;
	private int directeur_id;
	private int responsable_garderie;
	private int medecin_id;
	
	
	
	
	public Jardin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Jardin(String adresse, int capacite, String name, String email, int tel, int delegue_id, int directeur_id,
			int responsable_garderie, int medecin_id) {
		super();
		this.adresse = adresse;
		this.capacite = capacite;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.delegue_id = delegue_id;
		this.directeur_id = directeur_id;
		this.responsable_garderie = responsable_garderie;
		this.medecin_id = medecin_id;
	}



	public long getIdjardin() {
		return idjardin;
	}
	
	
	
	public void setIdjardin(long idjardin) {
		this.idjardin = idjardin;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getDelegue_id() {
		return delegue_id;
	}
	public void setDelegue_id(int delegue_id) {
		this.delegue_id = delegue_id;
	}
	public int getDirecteur_id() {
		return directeur_id;
	}
	public void setDirecteur_id(int directeur_id) {
		this.directeur_id = directeur_id;
	}
	public int getResponsable_garderie() {
		return responsable_garderie;
	}
	public void setResponsable_garderie(int responsable_garderie) {
		this.responsable_garderie = responsable_garderie;
	}
	public int getMedecin_id() {
		return medecin_id;
	}
	public void setMedecin_id(int medecin_id) {
		this.medecin_id = medecin_id;
	}



	@Override
	public String toString() {
		return "Jardin [idjardin=" + idjardin + ", adresse=" + adresse + ", capacite=" + capacite + ", name=" + name
				+ ", email=" + email + ", tel=" + tel + ", delegue_id=" + delegue_id + ", directeur_id=" + directeur_id
				+ ", responsable_garderie=" + responsable_garderie + ", medecin_id=" + medecin_id + "]";
	}



	public void setname() {
		// TODO Auto-generated method stub
		
	}
	
	

}
