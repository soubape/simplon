package com.stc.management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="typeactivite")
public class TypeActivite {
	@Id
	@Column(name="idTypeActivite")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String type;
	
	@OneToMany(mappedBy = "typeactivite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activite> activites;

	
	public TypeActivite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Activite> getActivites() {
		return activites;
	}


	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}


	
	
	
	
	

}
