package com.abc.cakeonline.order.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.cakeonline.cake.service.CakeDetailService;
import com.abc.cakeonline.entity.Cake;
import com.abc.cakeonline.entity.Cart;
import com.abc.cakeonline.entity.Order;
import com.abc.cakeonline.entity.OrderDetail;
import com.abc.cakeonline.entity.User;
import com.abc.cakeonline.order.service.OrderService;
import com.abc.cakeonline.user.service.UserService;

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	@Resource
	private CakeDetailService cakeDetailService;
	@Resource
	private UserService userService;

	@RequestMapping("/OrderServlet")
	public String insertOrder(@RequestParam("mail") String mail, @RequestParam("cakeid") String requestCakeid,
			@RequestParam("count") String requestCount, HttpServletRequest request) {
		Integer cakeid = 0;
		Integer count = 0;
		// 用户在登录的情况下结算购物车，先获取用户的mail
		if (mail == null || mail.equals("")) {
			return "requestlogin";
		} else {
			// 获取此蛋糕的id
			// 获取购买的此蛋糕的数量
			if (requestCakeid == null || requestCakeid.equals("")) {
				return "cartnull";
			} else {
				cakeid = Integer.parseInt(requestCakeid);
			}
			count = Integer.parseInt(requestCount);

			Order order = new Order();
			User user = userService.find(mail);
			order.setUser(user);
			order.setPhone("15623866666");

			Cake cake = this.cakeDetailService.findId(cakeid);

			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setCake(cake);
			orderDetail.setCount(count);

			Set<OrderDetail> hSet2 = new HashSet<OrderDetail>();
			hSet2.add(orderDetail);
			order.setOrderDetails(hSet2);
			this.orderService.insertOrderService(order);
			Cart cart = null;
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("cart");
			// 结算的时候把商品从购物车清走
			if (obj == null) {
				return "cartnull";
			} else {
				cart = (Cart) obj;
				Set<Integer> hSet = cart.gethMap().keySet();
				Iterator<Integer> iterator = hSet.iterator();
				while (iterator.hasNext()) {
					int id = (int) iterator.next();
					if (cakeid == id) {
						iterator.remove();
					}
				}
			}
			session.setAttribute("cart", cart);
			return "checkout";
		}
	}

}
