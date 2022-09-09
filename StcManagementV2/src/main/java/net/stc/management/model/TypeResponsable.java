package net.stc.management.model;

import javax.persistence.Embeddable;

@Embeddable
public class TypeResponsable {

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
