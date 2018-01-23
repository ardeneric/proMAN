package com.eric.proman.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Supervisor extends UserSuper implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "roleId", referencedColumnName = "id")
	@JsonBackReference
	private Role roleId;

	public Supervisor(Integer id, String firstname, String lastname, String username, String address, String city,
			String country, String postalcode, String password, Integer createdBy, Role roleId) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.address = address;
		this.city = city;
		this.country = country;
		this.contact = postalcode;
		this.password = password;
		this.createdBy = createdBy;
		this.roleId = roleId;
	}

	public Supervisor() {

	}

	@Override
	public String getUsername() {
		return username;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority(roleId.getRoleName()));

		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
