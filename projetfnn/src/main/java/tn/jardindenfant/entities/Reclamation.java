package tn.jardindenfant.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Reclamation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idReclamation;
	private String description;
	private Date dateReclamation ;
	private String etatRecalmation;
	
	@ManyToOne()
	User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reclamation(String description, Date dateReclamation, String etatRecalmation) {
		super();
		
		this.description = description;
		this.dateReclamation = dateReclamation;
		this.etatRecalmation = etatRecalmation;
	}
	public long getIdRecmation() {
		return idReclamation;
	}
	public void setIdRecmation(long idRecmation) {
		this.idReclamation = idRecmation;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateReclamation() {
		return dateReclamation;
	}
	public void setDateReclamation(Date dateReclamation) {
		this.dateReclamation = dateReclamation;
	}
	public String getEtatRecalmation() {
		return etatRecalmation;
	}
	public void setEtatRecalmation(String etatRecalmation) {
		this.etatRecalmation = etatRecalmation;
	}
	@Override
	public String toString() {
		return "Reclamation [idReclamation=" + idReclamation + ", description=" + description + ", dateReclamation="
				+ dateReclamation + ", etatRecalmation=" + etatRecalmation + "]";
	}
	
	
	
}
