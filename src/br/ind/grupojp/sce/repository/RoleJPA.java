package br.ind.grupojp.sce.repository;

import javax.ejb.Stateless;

import br.ind.grupojp.sce.entities.Role;

@Stateless
public class RoleJPA extends RepositoryJPA<Role, Long> implements RoleRepository{

	public RoleJPA() {
		super(Role.class);
	}

}
