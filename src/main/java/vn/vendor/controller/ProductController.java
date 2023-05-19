package vn.vendor.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.dao.*;
import vn.models.*;
import vn.service.*;
import vn.service.impl.*;

@WebServlet(urlPatterns = {"/seller/product", "/seller/san-pham"})
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = -851668681469603695L;
	
	ProductService modelService = new ProductServiceImpl();
	ImageProductService imgService = new ImageProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//String cid = req.getParameter("cid");
		//Khởi tạo đối tượng Dao
		
		//CategoryDao categoryDao = new CategoryDao();
		//
		List<Product> listallProduct = modelService.findAllProduct();
		List<ListImagesProduct> listallImages = imgService.getAllImage();
		//List<CategoryModel> listallCategory = categoryDao.getAllCategory();
		//
		req.setAttribute("listallProduct", listallProduct);
		//req.setAttribute("listallCategory", listallCategory);
		req.setAttribute("listallImages", listallImages);
		//req.setAttribute("tagactive", cid);
		req.getRequestDispatcher("/WEB-INF/views/vendor/Product.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			
			for (FileItem item : items) {
				if(item.getFieldName().equals("id")) {
					p.set_id(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("quantity")) {
					p.setQuantity(Integer.parseInt(item.getString()));
				}
			}
			modelService.editQuantity(p);
			resp.sendRedirect(req.getContextPath() + "/seller/san-pham");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
