package vn.admin.controllers.store;

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


@WebServlet(urlPatterns = ("/admin/store/staff/add"))
public class StaffAddController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	_UserService userService = new _UserServiceImpl();
	Store_StaffService modelService = new Store_StaffServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<_User> userList = userService.findAllUser();
		int id = Integer.parseInt(req.getParameter("_id"));
		req.setAttribute("userList", userList);
		req.setAttribute("storeId", id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/store/staff_add.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Store_Staff model = new Store_Staff();
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
					model.setStaffId(Integer.parseInt(ids));
					model.setStoreId(id);
					modelService.insert(model);
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
	