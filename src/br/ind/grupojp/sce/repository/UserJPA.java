package br.ind.grupojp.sce.repository;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.ind.grupojp.sce.entities.User;

@Stateless
public class UserJPA extends RepositoryJPA<User, String> implements UserRepository{
	
	public UserJPA() {
		super(User.class);
	}

	@Override
	public User findUserByLogin(String name) {
		
		Query query = getEm().createNamedQuery(User.FIND_LOGIN);
		query.setParameter("name", name);
		
		return (User) query.getSingleResult();
	}
	

}
