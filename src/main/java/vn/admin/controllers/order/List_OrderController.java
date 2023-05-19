package vn.admin.controllers.order;

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


@WebServlet(urlPatterns = ("/admin/order"))
public class List_OrderController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	_OrderService modelService = new _OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<_Order> modelList = modelService.findAll_Order();
		req.setAttribute("modelList", modelList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/order_list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("ids")) {
					String ids = item.getString();
					modelService.delete(Integer.parseInt(ids));
				} 
			}
			resp.sendRedirect(req.getContextPath() + "/admin/order");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	