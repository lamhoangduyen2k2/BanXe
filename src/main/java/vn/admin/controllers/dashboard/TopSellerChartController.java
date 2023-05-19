package vn.admin.controllers.dashboard;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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


@WebServlet(urlPatterns = ("/admin/dashboard/topseller"))
public class TopSellerChartController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService modelService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> topProduct = modelService.Top5Seller();
		req.setAttribute("topProduct", topProduct);
		double[] topPercent = modelService.PercentOfTop();
		req.setAttribute("topPercent", topPercent);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/dashboard/topseller.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
	