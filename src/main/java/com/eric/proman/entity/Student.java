package com.eric.proman.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Student extends UserSuper{

	@OneToOne
	@JoinColumn(name = "projectId", referencedColumnName = "id")
	private Project projectId;
}
