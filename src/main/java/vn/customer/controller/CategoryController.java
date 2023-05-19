package vn.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.dao.*;
import vn.dao.impl.CategoryDaoImpl;
import vn.dao.impl.ProductDaoImpl;
import vn.models.*;
import vn.service.ImageProductService;
import vn.service.ProductService;
import vn.service.impl.ImageProductServiceImpl;
import vn.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/category"})
public class CategoryController extends HttpServlet{

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
		
		//buoc 1: Khai tao DAO
		ProductService productService = new ProductServiceImpl();
		ImageProductService imgService = new ImageProductServiceImpl();
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();		
		//List<CategoryModel> listallCategory = categoryDao.getAllCategory()
		//buoc 2: Su dung doi tuong list de chua danh sach tu ProductDao
		Product list2 = productService.getTop1Product();
		//List<ProductModel> list3 = productDao.getlast4Product();
		List<Category> listcate =categoryDao.findAllCategory();
		
		String indexPage = req.getParameter("index");
		String indexPage1 = req.getParameter("index1");
		String cid = req.getParameter("cid");
		if(cid==null)
		{
			cid="0";
		}
		int id=Integer.parseInt(cid);
		if(indexPage==null)
		{
			indexPage="1";
		}
		int index = Integer.parseInt(indexPage);
		int index1 = Integer.parseInt(indexPage1);
		
			int countP = productService.getTotalProduct();
		int countCid = productService.coutbyId(id);
		int endPage=countP/3;
		if(countP%3!=0)
		{
			endPage++;
		}
		if("-1".equals(indexPage1))
		{
			List<Product> list4 = productService.findAllProduct();
			req.setAttribute("listall", list4);
		}
		else if("-2".equals(indexPage1))
		{
			List<Product> listCID = productService.findAllProductByCategoryId(cid);
			req.setAttribute("listall", listCID);
		}
		else
		{
			List<Product> listPage = productService.pagingProduct(index,index1);
			req.setAttribute("listall",listPage);
		}
		
		req.setAttribute("list1product", list2);
		req.setAttribute("tagactive",cid);
		req.setAttribute("endPage",endPage);
		req.setAttribute("tag",index);
		req.setAttribute("tag1",index1);
		req.setAttribute("indexP2",indexPage1);
		req.setAttribute("listcate",listcate);
		if(id==0)
		{
			req.setAttribute("countProductAll",countP);
		}
		else
		{
			req.setAttribute("countProductAll",countCid);
		}
		//buoc 4 tra ve trang JSP nao
		RequestDispatcher rq =req.getRequestDispatcher("/WEB-INF/views/customer/category.jsp");
		rq.forward(req, resp);
	}

}
