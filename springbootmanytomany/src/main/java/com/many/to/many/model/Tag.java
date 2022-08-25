package com.many.to.many.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "Tag")
@Table( name = "tags")
public class Tag {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tags")
	private List<Post> posts = new ArrayList<Post>();

	
	public Tag(String name) {
		super();
		this.name = name;
	}


	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}