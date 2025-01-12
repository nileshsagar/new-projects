package com.example.email_sender.serviceimp;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.email_sender.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
	

@Service
public class EmailServiceImp implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	private Logger logger=LoggerFactory.getLogger(EmailServiceImp.class);

	@Override
	public void sendEmail(String to, String sub, String message) {
		// TODO Auto-generated method stub

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(to);
		mailMessage.setSubject(sub);
		mailMessage.setText(message);
		mailMessage.setFrom("sagarnileshdattatray@gmail.com");
		mailMessage.setReplyTo(to);
		logger.info("Email has been send...");
		

		mailSender.send(mailMessage	);

	}

	@Override
	public void sendEmail(String[] to, String subject, String message) {
		// TODO Auto-generated method stub
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailMessage.setFrom("sagarnileshdattatray@gmail.com");
		logger.info("Email has been send...");
		

		mailSender.send(mailMessage	);

	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
		MimeMessage message=mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message,true,"UTF-8");
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("sagarnileshdattatray@gmail.com");
			helper.setText(htmlContent,true);
			mailSender.send(message);
			logger.info("Email has been sent....");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void sendEmailWithFile(String to, String sub, String message, File file) {
		// TODO Auto-generated method stub
		
		    MimeMessage mimeMessage =mailSender.createMimeMessage();

		    try {
				MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
				
				helper.setTo(to);
				helper.setSubject(sub);
				helper.setText(message);
				helper.setFrom("sagarnileshdattatray@gmail.com");
		
				FileSystemResource systemResource=new FileSystemResource(file);
				helper.addAttachment(systemResource.getFilename(),file);
				mailSender.send(mimeMessage);
				logger.info("Email has been sent....");
				
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		    
	}

}
