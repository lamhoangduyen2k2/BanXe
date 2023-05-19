package vn.admin.controllers.order;

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

@WebServlet(urlPatterns = ("/admin/order/edit"))
public class _OrderEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreService storeService = new StoreServiceImpl();
	_OrderService modelService = new _OrderServiceImpl();
	_UserService userService = new _UserServiceImpl(); 
	DeliveryService deliveryService = new DeliveryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("_id");
		_Order model = modelService.find_OrderByID(Integer.parseInt(id));
		req.setAttribute("model", model);
		List<Store> storeList = storeService.findAllStore();
		req.setAttribute("storeList", storeList);
		List<_User> userList = userService.findAllUser();
		req.setAttribute("userList", userList);
		List<Delivery> deliveryList = deliveryService.findAllDelivery();
		req.setAttribute("deliveryList", deliveryList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/order/order_edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_Order model = new _Order();
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
					model.setUserId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("storeId")) {
					model.setStoreId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("deliveryId")) {
					model.setDeliveryId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("address")) {
					model.setAddress(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("phone")) {
					model.setPhone(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("status")) {
					model.setStatus(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("isPaidBefore")) {
					model.setPaidBefore(Boolean.parseBoolean(item.getString()));
				} else if (item.getFieldName().equals("amountFromUser")) {
					model.setAmountFromUser(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("amountFromStore")) {
					model.setAmountFromStore(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("amountToStore")) {
					model.setAmountToStore(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("amountToGD")) {
					model.setAmountToGD(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("_id")) {
					model.set_id(Integer.parseInt(item.getString()));
				} 
			}
			modelService.edit(model);
			resp.sendRedirect(req.getContextPath() + "/admin/order");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
