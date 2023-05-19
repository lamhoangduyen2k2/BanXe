package vn.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.dao.ProductDAO;
import vn.dao.impl.CategoryDaoImpl;
import vn.dao.impl.ProductDaoImpl;
import vn.models.Category;
import vn.models.ListImagesProduct;
import vn.models.Product;
import vn.service.ImageProductService;
import vn.service.ProductService;
import vn.service.impl.ImageProductServiceImpl;
import vn.service.impl.ProductServiceImpl;



@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String pname = req.getParameter("pname");
		//thiet lap tieng viet
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
	
		
		//buoc 1: Khai tao DAO
		ProductService modelService = new ProductServiceImpl();
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		
		//buoc 2: Su dung doi tuong list de chua danh sach tu ProductDao
		List<Product> list = modelService.getTop5Product();
		Product list2 = modelService.getTop1Product();
		List<Product> list3 = modelService.Top5Seller();
		//List<Product> listName = productDao.searchbyName(pname);
		List<Category> listC = categoryDao.findAllCategory();
		//buoc 3: Thiet lap du lieu len JSP
		req.setAttribute("list4product", list);
		req.setAttribute("list1product", list2);
		req.setAttribute("list4last", list3);
		req.setAttribute("listcate", listC);
		
		//buoc 4 tra ve trang JSP nao
		RequestDispatcher rq =req.getRequestDispatcher("/WEB-INF/views/customer/home.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd =req.getRequestDispatcher("/WEB-INF/views/customer/home.jsp"); 
		  rd.forward(req, resp);
		
	}

}
