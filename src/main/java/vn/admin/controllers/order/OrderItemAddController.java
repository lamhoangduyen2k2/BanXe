package vn.admin.controllers.order;

import java.io.File; 
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.models.*;
import vn.service.*;
import vn.service.impl.*;
import vn.util.Constant;

@WebServlet(urlPatterns = ("/admin/order/item/add"))
public class OrderItemAddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrderItemService modelService = new OrderItemServiceImpl();
	_OrderService orderService = new _OrderServiceImpl(); 
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> productList = productService.findAllProduct();
		req.setAttribute("productList", productList);
		int ido = Integer.parseInt(req.getParameter("ido"));
		req.setAttribute("ido", ido);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/item_add.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderItem model = new OrderItem();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		int ido = 0;
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("ido")) {
					ido = Integer.parseInt(item.getString());
					model.setOrderId(ido);
				} else if (item.getFieldName().equals("ids")) {
					model.setProductId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("count_SP")) {
					model.setCount_SP(Integer.parseInt(item.getString()));
				}
			}
			modelService.insert(model);
			resp.sendRedirect(req.getContextPath() + "/admin/order/item?ido=" + ido);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
