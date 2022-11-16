package com.example.groupdepartment.service;


import com.example.groupdepartment.dto.GroupFormForCreating;
import com.example.groupdepartment.dto.filter.GroupFilter;
import com.example.groupdepartment.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface IGroupService {

	Page<Group> getAllGroups(Pageable pageable, GroupFilter filter, String search);
	void createGroup(GroupFormForCreating form);
}
