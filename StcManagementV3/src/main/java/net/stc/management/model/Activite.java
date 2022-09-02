package net.stc.management.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@ToString
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

	


}
