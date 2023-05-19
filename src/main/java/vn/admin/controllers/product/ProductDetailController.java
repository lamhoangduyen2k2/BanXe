package vn.admin.controllers.product;

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

@WebServlet(urlPatterns = ("/admin/product/detail"))
public class ProductDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService modelService = new ProductServiceImpl();
	ImageProductService imageService = new ImageProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("_id"));
		Product model = modelService.findProductByID(id);
		List<ListImagesProduct> imageList = imageService.findAllImage(id);
		req.setAttribute("model", model);
		req.setAttribute("imageList", imageList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/product/product_detail.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
