package net.stc.management.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@ToString
@Table(name="exercice")
//@JsonIdentityInfo(scope = Activite.class, generator = ObjectIdGenerators.PropertyGenerator.class,
//property = "id")
public class Exercice  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_exercice")
	private Long id;
	@Column
	private int annee;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Column
	private boolean statut;
	
	/*@JoinColumn(name = "idAdmin")
    @OneToOne(fetch = FetchType.LAZY)
    private Administrateur administrateur;
	*/

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "exercice")
//	private List<Activite> activites = new ArrayList<Activite>();

	@OneToMany
	//@Transient
	@JoinColumn( name = "id_activite")
	List<Activite> activites = new ArrayList<>();

	
}
