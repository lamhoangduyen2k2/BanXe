package vn.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.dao._OrderDAO;
import vn.dao.impl._OrderDaoImpl;
import vn.models.OrderItem;
import vn.models._Order;
@WebServlet(urlPatterns = {"/donhangdetail"})
public class OrderedDetailController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		int oid = Integer.parseInt(req.getParameter("oid"));
		
		_OrderDAO orderDAO = new _OrderDaoImpl();
		_Order order = orderDAO.find_OrderByID(oid);
		List<OrderItem> orderItems = orderDAO.getAllOrderItemByOrderId(oid);
		
		req.setAttribute("order", order);
		req.setAttribute("orderItems", orderItems);
		
		req.getRequestDispatcher("/WEB-INF/views/customer/ordereddetail.jsp").forward(req, resp);
	}
	
}
