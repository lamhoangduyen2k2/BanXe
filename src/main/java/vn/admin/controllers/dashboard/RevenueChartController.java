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


@WebServlet(urlPatterns = ("/admin/dashboard/revenue"))
public class RevenueChartController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	_OrderService modelService = new _OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long millis=System.currentTimeMillis();
		Date now = new Date(millis);
		LocalDate localNow = now.toLocalDate();
		int[] dayList = modelService.RevenueDay(localNow.getMonthValue(),localNow.getYear());
		req.setAttribute("dayList", dayList);
		int[] monthList = modelService.RevenueMonth(localNow.getYear());
		req.setAttribute("monthList", monthList);
		int[] yearList = modelService.RevenueYear();
		req.setAttribute("yearList", yearList);
		int totalOfMonth = modelService.TotalRevenueDay(localNow.getMonthValue(),localNow.getYear());
		req.setAttribute("totalOfMonth", totalOfMonth);
		int totalOfYear = modelService.TotalRevenueMonth(localNow.getYear());
		req.setAttribute("totalOfYear", totalOfYear);
		int totalOf5year = modelService.TotalRevenueYear();
		req.setAttribute("totalOf5year", totalOf5year);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/dashboard/revenue.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
	