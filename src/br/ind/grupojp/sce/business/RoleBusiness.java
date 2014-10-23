package br.ind.grupojp.sce.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ind.grupojp.sce.entities.Role;
import br.ind.grupojp.sce.repository.RoleRepository;


@Stateless
public class RoleBusiness {
	
	@EJB
	private RoleRepository roleRepository;
	
	private List<Role> roles = new ArrayList<Role>();
	
	
	
	
	public RoleRepository getRoleRepository() {
		return roleRepository;
	}




	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}




	public List<Role> getRoles() {
		
		
		roles = roleRepository.findAll();
		
	
		
		return roles;
	}




	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}




	public void save(Role role){
				
		this.roleRepository.save(role);
		
	}
	
	
	
	
	
	
	

}
