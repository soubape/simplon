package com.sous.health.pharmacie.entities;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private URole name;

  public Role() {

  }

  public Role(URole name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public URole getName() {
    return name;
  }

  public void setName(URole name) {
    this.name = name;
  }

@Override
public int hashCode() {
	return Objects.hash(id, name);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Role other = (Role) obj;
	return Objects.equals(id, other.id) && name == other.name;
}
  
}