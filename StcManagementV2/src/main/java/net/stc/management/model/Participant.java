package net.stc.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@ToString
@Table(name="participant")
//@JsonIdentityInfo(scope = Participant.class, generator = ObjectIdGenerators.PropertyGenerator.class,
//property = "id")
public class Participant  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_participant")
	private Long id;
	@Column
	private String name;
	@Column
	private String telephone;
	@Column
	private String fullname;
	@Column
	private String structure;
	
	@ManyToOne
	//@Transient
    @JoinColumn(name = "id_responsable")
    private Responsable responsable;

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Activite> activites = new ArrayList<Activite>();
	
	@OneToMany
	@JoinColumn( name = "id_activite")
	List<Activite> activites = new ArrayList<>();

}
