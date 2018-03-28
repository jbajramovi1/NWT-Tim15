package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Role(String name) {
		this.name = name;
	}
}
