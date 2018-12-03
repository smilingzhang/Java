package com;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiveServlet
 */
@WebServlet("/ReceiveServlet")
public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveServlet() {
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
		Session session =Session.getDefaultInstance(pros,null);
		URLName urln = new URLName("pop3", "pop.163.com", 110, null, "账号", "密码");
		Store store;
		try {
		//	使用session得到store，并连接
			store = session.getStore(urln);
			store.connect();
			//从store中取收件箱并打开
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			Message message[] = folder.getMessages();
			for(int i=0;i<message.length;i++) {
				message[i].getContent();
			}
			
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
