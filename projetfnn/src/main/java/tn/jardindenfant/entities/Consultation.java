package tn.jardindenfant.entities;

import java.util.Date;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Consultation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateconsultation;
	private String maladie;
	private double prix;
	@Enumerated(EnumType.STRING)
	private TypeCons typecons;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_enfant")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	Enfant enfant;
}

