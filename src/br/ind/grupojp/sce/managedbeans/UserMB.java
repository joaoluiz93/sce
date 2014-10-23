package br.ind.grupojp.sce.managedbeans;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ind.grupojp.sce.business.RoleBusiness;
import br.ind.grupojp.sce.business.UserBusiness;
import br.ind.grupojp.sce.entities.Role;
import br.ind.grupojp.sce.entities.User;

@ManagedBean
@RequestScoped
public class UserMB extends AbstractMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private UserBusiness userBusiness;

	@EJB
	private RoleBusiness roleBusiness;

	private User user;

	private List<User> users;

	private List<Role> roles;

	private Role role;

	private String roleName;

	public UserMB() {

		super();
		this.user = new User();
		this.users = new ArrayList<User>();
		this.roles = new ArrayList<Role>();
		this.role = new Role();

	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@SuppressWarnings("finally")
	@RolesAllowed({ "ADMIN" })
	public String save() {

		try {

			Role role = new Role();
			role.setName(roleName);
			user.setRole(role);

			userBusiness.save(user);

			user.setName("");

			menssagemInfo("Cadastrado com Sucesso");

		} catch (NoSuchAlgorithmException e) {

			menssagemErro("O Usuário já existe, tente novamente.");

		} finally {

			return "/pages/protected/admin/createUser.xhtml";

		}

	}

	public String update() {

		try {

			Role role = new Role();
			role.setName(roleName);
			user.setRole(role);

			System.out.println("Nome do Usuário: " + user.getName());
			System.out.println("Senha do Usuário: " + user.getPassword());
			System.out.println("Nome da role: " + user.getRole().getName());

			userBusiness.update(user);
			menssagemInfo("Atualizado com Sucesso!");

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			menssagemErro("Erro ao atualizar usuário.");

		}

		return "/pages/protected/admin/users.xhtml";

	}

	public String delete(User user) {

		userBusiness.delete(user);
		menssagemInfo("Deletado com Sucesso");

		return null;

	}

	public String logout() {

		return this.userBusiness.logout();

	}

	// Verifico se o usuário é um admin
	public boolean isAAdmin() {

		System.out.println("Verificando o isadmin: " + userBusiness.isAdmin());

		return userBusiness.isAdmin();

	}

	public User getUser() {

		user = userBusiness.getSessionUser();

		return user;
	}

	public User getUser2() {

		return user;
	}

	public List<User> getUsers() {

		users = userBusiness.getUsers();

		return users;
	}

	public List<Role> getRoles() {

		roles = roleBusiness.getRoles();

		return roles;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setUser(User user) {

		this.user = user;

	}

	public void setUser2(User user) {

		this.user = user;
		System.out.println("Name!!!!!!!!!! " + user.getName());

	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public RoleBusiness getRoleBusiness() {
		return roleBusiness;
	}

	public void setRoleBusiness(RoleBusiness roleBusiness) {
		this.roleBusiness = roleBusiness;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
