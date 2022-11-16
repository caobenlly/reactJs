package com.example.groupdepartment.repository;


import com.example.groupdepartment.entity.User;
import com.example.groupdepartment.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);

	@Modifying
	@Query("	SELECT 	status 		"
			+ "	FROM 	User 		"
			+ " WHERE 	email = :email")
	public UserStatus findStatusByEmail(@Param("email") String email);

	public User findByUsername(String username);
	
	public User findByEmail(String email);
}
