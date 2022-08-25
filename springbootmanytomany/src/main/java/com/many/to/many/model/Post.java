package com.many.to.many.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "title")
    private String title;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "content")
    private String content;
	
	@Column(name = "posted_at")
    private Date postedAt = new Date();
	
	@Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "post_tags",
		joinColumns = { @JoinColumn(name = "post_id")},
		inverseJoinColumns = { @JoinColumn (name = "tag_id")})
	private List<Tag> tags = new ArrayList<Tag>();
	
	

	public Post(String title, String description, String content, Date postedAt, Date lastUpdatedAt, List<Tag> tags) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
		this.postedAt = postedAt;
		this.lastUpdatedAt = lastUpdatedAt;
		this.tags = tags;
	}



	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Post(String title, String description, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}
	
	
}