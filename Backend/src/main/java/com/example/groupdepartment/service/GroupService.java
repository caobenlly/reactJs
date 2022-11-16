package com.example.groupdepartment.service;


import com.example.groupdepartment.dto.GroupFormForCreating;
import com.example.groupdepartment.dto.filter.GroupFilter;
import com.example.groupdepartment.entity.Group;
import com.example.groupdepartment.repository.GroupRepository;
import com.example.groupdepartment.specification.GroupSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GroupService implements IGroupService {

	@Autowired
	private GroupRepository repository;

	public Page<Group> getAllGroups(Pageable pageable, GroupFilter filter, String search) {

		GroupSpecificationBuilder specification = new GroupSpecificationBuilder(filter, search);

		return repository.findAll(specification.build(), pageable);
	}

	@Override
	public void createGroup(GroupFormForCreating form) {
		repository.save(form.toEntity());
	}

}
