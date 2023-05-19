package vn.vendor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.dao.*;
import vn.models.*;
@WebServlet(urlPatterns = {"/seller/order"})
public class OrderController extends HttpServlet{
	private static final long serialVersionUID = 648921828710437788L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập Tiếng Việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//Khởi tạo đối tượng Dao
		ViewOrderDao viewOrderDao = new ViewOrderDao();
		
		//
		List<ViewOrderModel> listAllViewOrder = viewOrderDao.getAllViewOrder(); 
		//
		req.setAttribute("listAllViewOrder", listAllViewOrder);
		req.getRequestDispatcher("/WEB-INF/views/vendor/Orders.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
