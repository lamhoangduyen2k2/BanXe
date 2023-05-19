package vn.admin.controllers.store;

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


@WebServlet(urlPatterns = ("/admin/store/staff"))
public class ListStaffController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Store_StaffService modelService = new Store_StaffServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("_id"));
		List<Store_Staff> modelList = modelService.findAllStaff(id);
		req.setAttribute("modelList", modelList);
		req.setAttribute("storeId", id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/store/staff_list.jsp");
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
					modelService.delete(id, Integer.parseInt(ids));
				} else if (item.getFieldName().equals("_id")) {
					id = Integer.parseInt(item.getString());
				} 
			}
			resp.sendRedirect(req.getContextPath() + "/admin/store/staff?_id=" + id);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	