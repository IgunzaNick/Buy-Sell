package com.example.buyandsell.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer role_id;
	@Column(nullable = false, unique = true)
	@NotEmpty
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Integer getId() {
		return role_id;
	}
	public void setId(Integer id) {
		this.role_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role(Integer id) {
		
		this.role_id = id;
		
	}
public Role( @NotEmpty String name) {
		
		this.name = name;
	}
	public Role(Integer id, @NotEmpty String name) {
		
		this.role_id = id;
		this.name = name;
	}
	public Role() {
		
	}
	

	

	

}
