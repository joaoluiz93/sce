package br.ind.grupojp.sce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="role")
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
