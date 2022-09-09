package net.stc.management.model;

import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class Statut {
	
	private String statut_activite;
	private String statut_exercice;


	}
