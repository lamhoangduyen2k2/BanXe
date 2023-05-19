package vn.admin.controllers.delivery;

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

@WebServlet(urlPatterns = ("/admin/delivery/detail"))
public class DeliveryDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DeliveryService modelService = new DeliveryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("_id"));
		Delivery model = modelService.findDeliveryByID(id);
		req.setAttribute("model", model);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/delivery/delivery_detail.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
