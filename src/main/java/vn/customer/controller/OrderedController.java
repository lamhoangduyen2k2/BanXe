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
import vn.models._Order;

@WebServlet(urlPatterns = {"/dondat"})
public class OrderedController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		_OrderDAO orderDAO = new _OrderDaoImpl();
		List<_Order> listordered = orderDAO.getAllOrderByUserId(uid);
		
		req.setAttribute("listordered", listordered);
		
		req.getRequestDispatcher("/WEB-INF/views/customer/orded.jsp").forward(req, resp);
	}
	

}
