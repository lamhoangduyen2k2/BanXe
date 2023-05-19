package vn.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.dao.impl.CategoryDaoImpl;
import vn.dao.impl.ProductDaoImpl;
import vn.models.Category;
import vn.models.Product;


@WebServlet(urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//thiet lap tieng viet
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//lay tham so tu JSP
		int pid = Integer.parseInt(req.getParameter("pid"));
		//buoc 1: Khai tao DAO
		ProductDaoImpl productDao = new ProductDaoImpl();
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		//buoc 2: Su dung doi tuong list de chua danh sach tu ProductDao
		Product list1 = productDao.findProductByID(pid);
		List<Product> list2 = productDao.findAllProduct();
		List<Category> listC = categoryDao.findAllCategory();
		Product list3 = productDao.getTop1Product();
		//buoc 3: Thiet lap du lieu len JSP
		req.setAttribute("pdetail", list1);
		req.setAttribute("listall", list2);
		req.setAttribute("listcate", listC);
		req.setAttribute("list1product", list3);
		//buoc 4 tra ve trang JSP nao
		RequestDispatcher rq =req.getRequestDispatcher("/WEB-INF/views/customer/chitietsp.jsp");
		rq.forward(req, resp);
	}

}
