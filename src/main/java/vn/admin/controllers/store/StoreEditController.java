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

@WebServlet(urlPatterns = ("/admin/store/edit"))
public class StoreEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreService modelService = new StoreServiceImpl();
	_UserService userService = new _UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("_id");
		Store model = modelService.findStoreByID(Integer.parseInt(id));
		req.setAttribute("model", model);
		List<_User> userList = userService.findAllUser();
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/store/store_edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Store model = new Store();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("_name")) {
					model.set_name(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("bio")) {
					model.setBio(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("ids")) {
					model.setOwnerId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("avatar")) {
					if (item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/store/" + fileName);
						item.write(file);
						model.setAvatar("store/" + fileName);
					} else {
						model.setAvatar(null);
					}
				} else if (item.getFieldName().equals("isActive")) {
					model.setActive(Boolean.parseBoolean(item.getString()));
				} else if (item.getFieldName().equals("isOpen")) {
					model.setOpen(Boolean.parseBoolean(item.getString()));
				} else if (item.getFieldName().equals("point")) {
					model.setPoint(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("e_wallet")) {
					model.setE_wallet(Double.parseDouble(item.getString()));
				} else if (item.getFieldName().equals("_id")) {
					model.set_id(Integer.parseInt(item.getString()));
				} 
			}
			modelService.edit(model);
			resp.sendRedirect(req.getContextPath() + "/admin/store");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
