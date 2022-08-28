package net.stc.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
@Data
@Entity
@Table(name="activite")
//@JsonIdentityInfo(scope = Activite.class, generator = ObjectIdGenerators.PropertyGenerator.class,
//property = "id")
public class Activite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_activite")
	private Long id;
	@Column
	private String titre;
	@Column
	private String description;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Column
	private boolean etat;
	
	
//	@ManyToMany(mappedBy="activites")
//    private List<Participant> participants = new ArrayList<Participant>();

	
	@Embedded
	//@Transient
	@AttributeOverrides({
		@AttributeOverride(name = "type", column = @Column(name = "type_activite")) }	   )
	 @JsonIgnore
	private TypeActivite typeactivite;

	
	 @ManyToOne
	 @JsonIgnore

	    @JoinColumn( name = "id_responsable" )
	    private Responsable responsable;
//
	 @ManyToOne
	 @JsonIgnore

	    @JoinColumn( name = "id_exercice" )
	    private Exercice exercice;
	 
	 @ManyToOne
	    @JoinColumn( name = "id_participant" )
	    private Participant participant;
//	 
		public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}
