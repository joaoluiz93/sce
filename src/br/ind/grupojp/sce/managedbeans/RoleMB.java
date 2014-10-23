package br.ind.grupojp.sce.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.ind.grupojp.sce.business.RoleBusiness;
import br.ind.grupojp.sce.entities.Role;


@ManagedBean
public class RoleMB {

	 @EJB
	 private RoleBusiness roleBusiness;
	 
	 private List<Role> roles;

	public RoleMB() {
		super();
		roles = new ArrayList<Role>();
	}

	public RoleBusiness getRoleBusiness() {
		return roleBusiness;
	}


	public List<Role> getRoles() {
		
		roles = roleBusiness.getRoles();
		
		return roles;
	}

	 
	
	
	 
	 
	
}
