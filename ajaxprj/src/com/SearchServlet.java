package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word=request.getParameter("searchword");
		ArrayList<String> list=new ArrayList<String>();
		list.add("java");
		list.add("javahello");
		list.add("javaword");
		list.add("jhello");
		list.add("jahello");
//		JSON数组形式
		String rs="[";
		for(String temp:list) {
			if(temp.startsWith(word)) {
				rs+="\""+temp+"\",";
			}
			}
		rs=rs.substring(0, rs.length()-1);
		rs+="]";
		response.getWriter().print(rs);
		 //json调函数直接把数组变字符串
//		Gson gs=new Gson();
//		String result=gs.toJson(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
