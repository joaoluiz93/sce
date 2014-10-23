package br.ind.grupojp.sce.repository;

import br.ind.grupojp.sce.entities.User;

  public interface UserRepository extends GenericRepository<User, String>{

	  public User findUserByLogin(String name);
	  

}