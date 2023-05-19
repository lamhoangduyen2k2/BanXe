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


@WebServlet(urlPatterns = ("/admin/order/item"))
public class ListOrderItemController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrderItemService modelService = new OrderItemServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("ido"));
		List<OrderItem> modelList = modelService.findAllOrderItem(id);
		req.setAttribute("modelList", modelList);
		req.setAttribute("ido", id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/item_list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		int id = 0;
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("ids")) {
					String ids = item.getString();
					modelService.delete(Integer.parseInt(ids));
				} else if (item.getFieldName().equals("ido")) {
					id = Integer.parseInt(item.getString());
				}
			}
			resp.sendRedirect(req.getContextPath() + "/admin/order/item?ido=" + id);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	