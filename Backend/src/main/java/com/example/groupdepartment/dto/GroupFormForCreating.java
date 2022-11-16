package com.example.groupdepartment.dto;


import com.example.groupdepartment.entity.Group;

public class GroupFormForCreating {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group toEntity() {
		return new Group(name);
	}

}
