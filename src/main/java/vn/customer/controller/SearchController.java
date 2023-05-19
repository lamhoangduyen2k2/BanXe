package vn.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.dao.*;
import vn.dao.impl.CategoryDaoImpl;
import vn.models.*;
import vn.service.ImageProductService;
import vn.service.ProductService;
import vn.service.impl.ImageProductServiceImpl;
import vn.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//lay tham so tu JSP
		String txtSearch = req.getParameter("txt");
		//buoc 1: Khai tao DAO
		ProductService modelService = new ProductServiceImpl();
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		//buoc 2: Su dung doi tuong list de chua danh sach tu ProductDao
		List<Product> list = modelService.searchbyName(txtSearch);
		Product list2 = modelService.getTop1Product();
		List<Category> listC = categoryDao.findAllCategory();
		//buoc 3: Thiet lap du lieu len JSP
		req.setAttribute("listall", list);
		req.setAttribute("list1product", list2);
		req.setAttribute("listcate", listC);
		req.setAttribute("txtS", txtSearch);
		//buoc 4 tra ve trang JSP nao
		req.getRequestDispatcher("/WEB-INF/views/customer/category.jsp").forward(req, resp);
	}

}
