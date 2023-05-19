package vn.admin.controllers.delivery;

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

@WebServlet(urlPatterns = ("/admin/delivery/add"))
public class DeliveryAddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DeliveryService deliveryService = new DeliveryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/delivery/delivery_add.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Delivery model = new Delivery();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					model.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("description")) {
					model.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("price")) {
					model.setPrice(Double.parseDouble(item.getString()));
				} 
			}
			deliveryService.insert(model);
			resp.sendRedirect(req.getContextPath() + "/admin/delivery");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
