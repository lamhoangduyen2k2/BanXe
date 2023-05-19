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

import org.apache.tomcat.util.http.fileupload.FileItem; 
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory; 
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import vn.service.*;
import vn.service.impl.*;


@WebServlet(urlPatterns = ("/admin/delivery/delete"))
public class DeliveryDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DeliveryService modelService = new DeliveryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("_id");
		modelService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/delivery");
	}

}
