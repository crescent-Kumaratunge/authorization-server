package com.crescent.rentcloud.authorizationserver.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")

public class User implements Serializable {
	public User() {}
	
	public User(User user) {
		this.username=user.username;
		this.password=user.password;
		this.email=user.email;
		this.enabled=user.enabled;
		this.accountNonExpired=user.accountNonExpired;
		this.credentialsNonExpired=user.credentialsNonExpired;
		this.accountNonLocked=user.accountNonLocked;
		this.roles=user.roles;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "accountNonExpired")
	private boolean accountNonExpired;
	
	@Column(name = "credentialsNonExpired")
	private boolean credentialsNonExpired;
	
	@Column(name = "accountNonLocked")
	private boolean accountNonLocked;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="role_user", joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")}
				)
	private List<Role> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accoundNonExpired) {
		this.accountNonExpired = accoundNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
}
