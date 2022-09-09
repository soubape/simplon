package com.example.demo.entities;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employe_Id")
	private Long id;
	@Column(name="employe_nom")
	private String nom;


	
}
