package vn.admin.controllers.user;

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

import vn.models._User; 
import vn.service._UserService; 
import vn.service.impl._UserServiceImpl;
import vn.util.Constant;

@WebServlet(urlPatterns = ("/admin/user/edit"))
public class UserEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	_UserService userService = new _UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("_id");
		_User user = userService.findUserByID(Integer.parseInt(id));
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/user/user_edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_User user = new _User();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("_id")) {
					user.set_id(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("firstname")) {
					user.setFirstname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("lastname")) {
					user.setLastname(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("id_card")) {
					user.setId_card(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("salt")) {
					user.setSalt(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("hashed_password")) {
					user.setHashed_password(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("_role")) {
					user.set_role(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("addresses")) {
					user.setAddresses(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("avatar")) {
					if (item.getSize() == 0) {
						user.setAvatar(item.getString("UTF-8"));
					} else {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/user/" + fileName);
						item.write(file);
						user.setAvatar("user/" + fileName);
					}
				} else if (item.getFieldName().equals("point")) {
					user.setPoint(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("e_wallet")) {
					user.setE_wallet(Double.parseDouble(item.getString()));
				}
			}
			userService.edit(user);
			resp.sendRedirect(req.getContextPath() + "/admin/user");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
