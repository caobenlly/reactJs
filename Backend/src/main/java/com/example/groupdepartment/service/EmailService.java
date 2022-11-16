package com.example.groupdepartment.service;


import com.example.groupdepartment.entity.RegistrationUserToken;
import com.example.groupdepartment.entity.User;
import com.example.groupdepartment.repository.RegistrationUserTokenRepository;
import com.example.groupdepartment.repository.ResetPasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmailService implements IEmailService {

	@Autowired
	private IUserService userService;

	@Autowired
	private RegistrationUserTokenRepository registrationUserTokenRepository;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ResetPasswordTokenRepository resetPasswordTokenRepository;
	@Override
	public void sendRegistrationUserConfirm(String email) {

		User user = userService.findUserByEmail(email);
		RegistrationUserToken tokenEntity= registrationUserTokenRepository.findFirstByUserId(user.getId());
		String token = tokenEntity.getToken();
		String confirmationUrl = "http://localhost:8080/api/v1/users/activeUser?token=" + token;

		String subject = "Xác Nhận Đăng Ký Account";
		String content = "Bạn đã đăng ký thành công. Click vào link dưới đây để kích hoạt tài khoản \n"
				+ confirmationUrl;

		sendEmail(email, subject, content);

	}

	@Override
	public void sendResetPassword(String email) {

		User user = userService.findUserByEmail(email);
		String token = resetPasswordTokenRepository.findByUserId(user.getId());

		String confirmationUrl = "http://localhost:3000/auth/new-password/" + token;

		String subject = "Thiết lập lại mật khẩu";
		String content = "Click vào link dưới đây để thiết lập lại mật khẩu (nếu không phải bạn xin vui lòng bỏ qua).\n"
				+ confirmationUrl;

		sendEmail(email, subject, content);
	}

	private void sendEmail(final String recipientEmail, final String subject, final String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject(subject);
		message.setText(content);

		mailSender.send(message);
	}

}
