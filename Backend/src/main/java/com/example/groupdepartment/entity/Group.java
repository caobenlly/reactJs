package com.example.groupdepartment.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "`name`", length = 50, nullable = false, unique = true)
	private String name;

	@Column(name = "total_member")
	private short totalMember;

	public Group(String name) {
		this.name = name;
	}

	public Group() {
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public short getTotalMember() {
		return totalMember;
	}
}
