package br.ind.grupojp.sce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="user")
@NamedQueries ({
	@NamedQuery(name="User.findUserByLogin",  query="select n from User n where n.name = :name"),
})
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static final String FIND_LOGIN = "User.findUserByLogin";
	
	
	@Id
	private String name;
		
	private String password;
	
	@ManyToOne
	private Role role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", role="
				+ role + "]";
	}
	
	

}
