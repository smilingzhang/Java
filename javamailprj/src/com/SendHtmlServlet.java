package com;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendHtmlServlet
 */
@WebServlet("/SendHtmlServlet")
public class SendHtmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendHtmlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties pros=System.getProperties();
		pros.put("mail.smtp.host", "smtp.163.com");
		pros.put("mail.smtp.auth", "true");
		Session session=Session.getInstance(pros,new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("15226502915", "123456!");
			} 
		});
		MimeMessage msg=new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("15226502915@163.com"));
			msg.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("1509488088@qq.com"));
			msg.setSubject("hi");

//			MimeBodyPart mimeBodyPart=new MimeBodyPart();
//			mimeBodyPart.setContent("<a href='www.baidu.com'>跳转到百度</a>","text/html;charset=gb2312");
			
			MimeBodyPart mimeBodyPart2=new MimeBodyPart();
			mimeBodyPart2.setContent("网易鼓励企业用户在遵守互联网标准的前提下，向网易邮箱用户发送已经许可的邮件","text/plain;charset=gb2312");
			
//			MimeBodyPart mimeBodyPart3=new MimeBodyPart();
//			mimeBodyPart3.setContent("<span>网易鼓励企业用户在遵守互联网标准的前</span>","text/html;charset=gb2312");
			
//			MimeBodyPart mbp2 = new MimeBodyPart();
//			FileDataSource fds = new FileDataSource("D:\\1.jpg");
//			mbp2.setDataHandler(new DataHandler(fds));
//			mbp2.setFileName("soft.jpg");
			
			MimeMultipart mimeMultipart=new MimeMultipart();
			mimeMultipart.addBodyPart(mimeBodyPart2);
//			mimeMultipart.addBodyPart(mimeBodyPart);
//		mimeMultipart.addBodyPart(mimeBodyPart3);
//			mimeMultipart.addBodyPart(mbp2);
//			
			msg.setContent(mimeMultipart);
			Transport.send(msg);
			response.getWriter().print("ok!");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
