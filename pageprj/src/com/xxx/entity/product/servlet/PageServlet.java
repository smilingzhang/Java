package com.xxx.entity.product.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxx.entity.entity.Page;
import com.xxx.entity.entity.Product;
import com.xxx.entity.product.dao.ProductPageDao;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=0;
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}else {
			num=Integer.parseInt(pageNum);
		}
		ProductPageDao pd=new ProductPageDao();
		List<Product> list=pd.findAll(num, 2);
		int count=pd.findCount();
		Page<Product> page=new Page<Product>(2,num);
		page.setList(list);
		page.setTotalCount(count);
		page.setTotalPageNum(count);
		page.setPrePageNum(num-1);
		page.setNextPageNum(num+1);
		request.setAttribute("page", page);
		request.getRequestDispatcher("page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
