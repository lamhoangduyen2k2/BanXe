package vn.admin.controllers.store;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.models.*;
import vn.service.*;
import vn.service.impl.*;

@WebServlet(urlPatterns = ("/admin/store/detail"))
public class StoreDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreService modelService = new StoreServiceImpl();
	Store_StaffService staffService = new Store_StaffServiceImpl();
	ImageStoreService imageService = new ImageStoreServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("_id"));
		Store model = modelService.findStoreByID(id);
		List<Store_Staff> StaffList = staffService.findAllStaff(id);
		List<ListImagesStore> imageList = imageService.findAllImage(id);
		req.setAttribute("model", model);
		req.setAttribute("stafflist", StaffList);
		req.setAttribute("imageList", imageList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/store/store_detail.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
