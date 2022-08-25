package com.stc.management.model;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "participant_activities")
public class ParticipantActivity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Statut status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_participant")
	private Participant participants;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_activite")
	private Activite activites;
	
}