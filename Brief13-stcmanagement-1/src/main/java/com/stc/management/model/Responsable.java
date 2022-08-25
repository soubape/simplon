package com.stc.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="responsable")
public class Responsable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_responsable")
	private Long id;
	@Column
	private String name;
	@Column
	private String telephone;
	@Column
	private String domaine;
	@Column
	private boolean etat;
	private TypeResponsable typeresponsable;
	
//	@OneToMany(mappedBy = "responsable", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Participant> participants;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_responsable_participant", referencedColumnName = "id_responsable")
	List<Participant> participants = new ArrayList<>();
//	@OneToMany
//	List<Participant> participants = new ArrayList<>();

	
}
