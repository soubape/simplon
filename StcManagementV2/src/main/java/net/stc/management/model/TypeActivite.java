package net.stc.management.model;

import javax.persistence.Embeddable;

@Embeddable
//@JsonIdentityInfo(scope = TypeActivite.class, generator = ObjectIdGenerators.PropertyGenerator.class)
public class TypeActivite {
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	


	}
