package com.example.groupdepartment.repository;

import com.example.groupdepartment.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface GroupRepository extends JpaRepository<Group, Short>, JpaSpecificationExecutor<Group> {

	public Group findByName(String name);

	public boolean existsByName(String name);
}
