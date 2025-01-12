package com.example.email_sender.service;

import java.io.File;

public interface EmailService {

	// Send Email To Single Person
	
	void sendEmail(String to,String sub,String message);
	
	//Send Email Multiple Person
	
	void sendEmail(String[] to,String subject,String message);
	
	//Send Email WithHtml
	void sendEmailWithHtml(String to,String subject,String htmlContent);
	
	//void Send emailWithFile
	
	void sendEmailWithFile(String to,String sub,String message,File file);
	
}
