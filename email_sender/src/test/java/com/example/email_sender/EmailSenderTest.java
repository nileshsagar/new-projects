package com.example.email_sender;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.email_sender.service.EmailService;

@SpringBootTest
public class EmailSenderTest {

	@Autowired
	EmailService emailService;
	
//	@Test
//	void emailSendTest()
//	{
//		System.out.println("Sending email...");
//		
//		emailService.sendEmail("nileshsagar@dmdgoldprosperity.com","Email From SpringBoot","this Email Send by SpringBoot for creating small project");
//		
//		
//	}
	
//	@Test
//	void sendEmailWithHtml(){
//		
//		System.out.println("Sending email.....");
//		
//		String html=""+"<h1 style='color:red;border:7px solid green'> Hello My Name is Nilesh and i am fullstack developer</h1>";
//		
//		emailService.sendEmailWithHtml(" nileshsagar@dmdgoldprosperity.com","Email From SpringBoot",html);
		
	@Test
	void sendEmailWithFile() {
		
		System.out.println("Sending email...");
		
		emailService.sendEmailWithFile(" nileshsagar@dmdgoldprosperity.com","checking email","Hello please check",new File("C:\\Users\\niles\\Downloads\\email_sender\\src\\main\\resources\\static\\1_0T0J42lP1v1J44y0d1lwCQ.png"));
		
		
		
		}
		
		
		
	}

