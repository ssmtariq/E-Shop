package com.ecommerce.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUtil {
	public static boolean sendEmail(String userName, String userPassword, String toEmail, String subject, String body, String keyword) {
		String host = "smtp.gmail.com";
		final String user = userName;// change accordingly
		final String password = userPassword;
		String emailBody = "";
		if(body.equals(ApplicationConstants.REGISTRATION_EMAIL_BODY)){
			emailBody += "<div>Dear User,</div><br>"
					+ "<div>Please go to the following address to confirm your registration:</div>"
					+ "<a href='"+keyword+"'>"+keyword+"</a>"
					+ "<br><br><div>Best Regards<br>E-Shop Bangladesh Limited<br>House: 7, Baridhara, Dhaka-1212<br>Bangladesh</div>";
		}
		if(body.equals(ApplicationConstants.RECOVERY_EMAIL_BODY)){
			emailBody += "<div>Dear User,</div><br>"
					+ "<div>Please use the following password to sign in:</div>"
					+ ""+keyword
					+ "<br><br><div>Best Regards<br>E-Shop Bangladesh Limited<br>House: 7, Baridhara, Dhaka-1212<br>Bangladesh</div>";
		}
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session); 
			message.setFrom(new InternetAddress("E-Shop Bangladesh<"+user+">"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					toEmail));
			message.setSubject(subject);
			message.setContent(emailBody, "text/html; charset=utf-8");
			// send the message
			Transport.send(message);

			System.out.println("Email sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}
}
