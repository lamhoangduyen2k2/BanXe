package vn.vendor.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.dao.*;
import vn.models.*;
import vn.service._OrderService;
import vn.service.impl._OrderServiceImpl;

@WebServlet(urlPatterns = {"/seller/orderdetail"})
public class OrderDetailController extends HttpServlet{

	private static final long serialVersionUID = -4034686964964917793L;
	ViewOrderDao viewOrderDao = new ViewOrderDao();
	_OrderService modelService = new _OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập Tiếng Việt
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				
				String oid = req.getParameter("oid");
				
				//Khởi tạo đối tượng Dao
				
				
				List<OrderInformation> listOrderInfoByID = viewOrderDao.getOrderInfoById(oid);
				List<OrderDetailModel> listOrderDetailByID = viewOrderDao.getAllOrderById(oid);
				_Order order = modelService.find_OrderByID(Integer.parseInt(oid));
				
				req.setAttribute("listOrderInfoByID", listOrderInfoByID);
				req.setAttribute("listOrderDetailByID", listOrderDetailByID);
				req.setAttribute("order", order);
				
				req.getRequestDispatcher("/WEB-INF/views/vendor/orderdetail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_Order o = new _Order();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if(item.getFieldName().equals("id")) {
					o.set_id(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("status")) {
					o.setStatus(item.getString("UTF-8"));
				}
			}
			viewOrderDao.edit(o);
			if (o.getStatus().equals("delivered")) {
				viewOrderDao.update_quantity(o);
				
			}
			resp.sendRedirect(req.getContextPath() + "/seller/order");
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
