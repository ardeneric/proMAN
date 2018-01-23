package com.eric.proman.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "roleName")
	private String roleName;

	@OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Supervisor> supervisor = new ArrayList<>();

	public Role(Integer id, String roleName, List<Supervisor> supervisor) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.supervisor = supervisor;
	}

	public Role() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Supervisor> getUser() {
		return supervisor;
	}

	public void setUser(List<Supervisor> supervisor) {
		this.supervisor = supervisor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
