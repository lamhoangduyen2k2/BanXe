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

import org.apache.tomcat.util.http.fileupload.FileItem; 
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory; 
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import vn.models._User; 
import vn.service._UserService; 
import vn.service.impl._UserServiceImpl;
import vn.util.Constant;

@WebServlet(urlPatterns = ("/admin/user/delete"))
public class UserDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	_UserService userService = new _UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("_id");
		userService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/WEB-INF/views/admin/user/user_list.jsp");
	}

}
