package br.ind.grupojp.sce.business;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.ind.grupojp.sce.entities.Role;
import br.ind.grupojp.sce.entities.User;
import br.ind.grupojp.sce.repository.RoleRepository;
import br.ind.grupojp.sce.repository.UserRepository;

@Stateless
public class UserBusiness {

	@EJB
	private UserRepository userRepository;

	@EJB
	private RoleRepository roleRepository;

	private User user;

	private List<String> namesRoles;

	private List<User> users;

	private List<Role> roles = new ArrayList<Role>();

	@RolesAllowed({ "ADMIN" })
	public void save(User user) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(user.getPassword().getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String passwordEncrypted = hash.toString(16);

		while (passwordEncrypted.length() < 32) {

			passwordEncrypted = "0" + passwordEncrypted;

		}

		user.setPassword(passwordEncrypted);

		userRepository.save(user);
		user = new User();
		users = null;

	}

	public void update(User user) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(user.getPassword().getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String passwordEncrypted = hash.toString(16);

		while (passwordEncrypted.length() < 32) {

			passwordEncrypted = "0" + passwordEncrypted;

		}

		user.setPassword(passwordEncrypted);

		userRepository.update(user);
	

	}
	
	public void delete(User user){
		
		
		userRepository.delete(user.getName(), User.class);
		
	}

	public String logout() {

		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.invalidate();

		return "/pages/public/login";

	}

	public User getSessionUser() {

		if (user == null) {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			String name = context.getUserPrincipal().getName();

			user = userRepository.findUserByLogin(name);
		}
		return user;
	}

	public User findUserByLogin(String name) {

		return userRepository.findUserByLogin(name);
	}

	public boolean isAdmin() {

		User user = userRepository.findUserByLogin(getRequest()
				.getUserPrincipal().getName());

		if (user.getRole().getName().equals("ADMIN")) {

			return true;

		} else {

			return false;

		}

	}
	
	
	public boolean isDeactivate() {

		User user = userRepository.findUserByLogin(getRequest()
				.getUserPrincipal().getName());

		if (user.getRole().getName().equals("DEACTIVATE")) {

			return true;

		} else {

			return false;

		}

	}


	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getNamesRoles() {
		return namesRoles;
	}

	public void setNamesRoles(List<String> namesRoles) {
		this.namesRoles = namesRoles;
	}

	public List<User> getUsers() {

			this.users = this.userRepository.findAll();
		
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Role> getRoles() {

		if (this.roles == null) {
			this.roles = this.roleRepository.findAll();
		}

		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
