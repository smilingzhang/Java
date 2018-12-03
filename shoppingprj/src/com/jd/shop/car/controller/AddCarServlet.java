package com.jd.shop.car.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jd.shop.car.service.Car;
import com.jd.shop.entity.Product;
import com.jd.shop.product.service.ProductService;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		if(id!=null&&!id.equals("")) {
			Car car=null;
			ProductService p=new ProductService();
			Product pro=p.listById(id);
			//把购物车这个集合存到seesion中，只有用户自己可以看见，但要先判断session 里是否有车
			HttpSession session=request.getSession();
			Object obj=session.getAttribute("car");
			if(obj==null) {
				car=new Car();
			}else {
				car=(Car)obj;
			}
			car.add(pro);
			session.setAttribute("car",car);
			response.sendRedirect("ProductServlet");
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
