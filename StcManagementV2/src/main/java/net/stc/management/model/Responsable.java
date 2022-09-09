package net.stc.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@ToString
@Table(name="responsable")
@JsonIdentityInfo(scope = Activite.class, generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class Responsable  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_responsable")
	private Long id;
	@Column
	private String name;
	@Column
	private String telephone;
	@Column
	private String domaine;
	@Column
	private boolean etat;
	
	@Embedded
//	@Transient
	@AttributeOverrides( {
		   @AttributeOverride(name="type", column = @Column(name="type_responsable") )
		}
		   )
	private TypeResponsable typeresponsable;
	
	@OneToMany
	//@Transient
	@JoinColumn(name="id_activite")
	private List<Activite> activites = new ArrayList<Activite>();
	
	@OneToMany
	@JoinColumn(name="id_participant")
	private List<Participant> participants = new ArrayList<>();
	
	
	
}
