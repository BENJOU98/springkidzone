package tn.jardindenfant.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Rendez_vous implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idRdv;
	private String ObjetMeeting ;
	private Date dateMeeting ;
	
	public Rendez_vous() {
		super();
		
	}

	public Rendez_vous(String objetMeeting, Date dateMeeting) {
		super();
		ObjetMeeting = objetMeeting;
		this.dateMeeting = dateMeeting;
	}

	public long getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(long idRdv) {
		this.idRdv = idRdv;
	}

	public String getObjetMeeting() {
		return ObjetMeeting;
	}

	public void setObjetMeeting(String objetMeeting) {
		ObjetMeeting = objetMeeting;
	}

	public Date getDateMeeting() {
		return dateMeeting;
	}

	public void setDateMeeting(Date dateMeeting) {
		this.dateMeeting = dateMeeting;
	}

	@Override
	public String toString() {
		return "Rendez_vous [idRdv=" + idRdv + ", ObjetMeeting=" + ObjetMeeting + ", dateMeeting=" + dateMeeting + "]";
	}
	
	
	

}
