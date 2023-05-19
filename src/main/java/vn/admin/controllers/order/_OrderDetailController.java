package vn.admin.controllers.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.models.*;
import vn.service.*;
import vn.service.impl.*;

@WebServlet(urlPatterns = ("/admin/order/detail"))
public class _OrderDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	_OrderService modelService = new _OrderServiceImpl();
	OrderItemService itemService = new OrderItemServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("_id"));
		_Order model = modelService.find_OrderByID(id);
		List<OrderItem> itemList = itemService.findAllOrderItem(id);
		req.setAttribute("model", model);
		req.setAttribute("itemList", itemList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/order_detail.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
