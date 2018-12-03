package com;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream is=request.getInputStream();
		BufferedInputStream bis=new BufferedInputStream(is);
		String realpath=getServletContext().getRealPath("/upload");
		File file=new File(realpath+"/"+System.currentTimeMillis()+".txt");
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		BufferedOutputStream bos=new BufferedOutputStream(fileOutputStream);
		int read=bis.read();
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		bos.flush();
		bos.close();
		fileOutputStream.flush();
		fileOutputStream.close();
		response.getWriter().write("successful!");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
