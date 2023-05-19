package vn.admin.controllers.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.models.Category;
import vn.service.CategoryService;
import vn.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = ("/admin/category/detail"))
public class CategoryDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("_id"));
		Category cate = cateService.findCategoryByID(id);
		req.setAttribute("cate", cate);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/category/category_detail.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
