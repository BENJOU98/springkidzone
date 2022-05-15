package tn.jardindenfant.entities;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="publication")
public class Publication  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	


	
	private String imagepub;
	
	private String title;
	private LocalDate createdAt = LocalDate.now();
	@LastModifiedDate
	private LocalDate updatedAt = LocalDate.now();








	@Column
	private String publication_txt;
	
	
	
	@ManyToOne()
	User user;
	
	@OneToMany(mappedBy="pub",cascade=CascadeType.ALL)
	private List<LikePosts> likes;
	@OneToMany(mappedBy = "pub_id",cascade=CascadeType.ALL)
	private List<Comments> comments;

	
	


	




	

	
}
