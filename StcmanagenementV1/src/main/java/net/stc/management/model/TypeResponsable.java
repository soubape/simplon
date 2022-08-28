package net.stc.management.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Embeddable
//@JsonIdentityInfo(scope = TypeResponsable.class, generator = ObjectIdGenerators.PropertyGenerator.class)
public class TypeResponsable {

	private String type;

	

}
