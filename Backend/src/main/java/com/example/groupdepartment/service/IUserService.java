package com.example.groupdepartment.service;


import com.example.groupdepartment.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface IUserService extends UserDetailsService {

	void createUser(User user);

	User findUserByEmail(String email);


	User findUserByUserName(String username);

	void activeUser(String token);

	void sendConfirmUserRegistrationViaEmail(String email);

	boolean existsUserByEmail(String email);

	boolean existsUserByUserName(String userName);

	void resetPasswordViaEmail(String email);

	void resetPassword(String token, String newPassword);

	void sendResetPasswordViaEmail(String email);
}
