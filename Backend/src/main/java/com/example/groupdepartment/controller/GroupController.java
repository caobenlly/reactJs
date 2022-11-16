package com.example.groupdepartment.controller;


import com.example.groupdepartment.dto.GroupFormForCreating;
import com.example.groupdepartment.dto.filter.GroupFilter;
import com.example.groupdepartment.entity.Group;
import com.example.groupdepartment.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/groups")

public class GroupController {

	@Autowired
	private IGroupService service;

	@GetMapping()
	public ResponseEntity<?> getAllGroups(
			Pageable pageable, 
			GroupFilter filter,
			@RequestParam(required = false) String search) {
		Page<Group> entities = service.getAllGroups(pageable, filter, search);
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createGroup(@RequestBody GroupFormForCreating form) {
		service.createGroup(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}
}
