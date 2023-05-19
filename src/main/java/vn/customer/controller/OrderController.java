package vn.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.dao.CartDao;
import vn.dao.DeliveryDAO;
import vn.dao.OrderItemDAO;
import vn.dao._OrderDAO;
import vn.dao.impl.DeliveryDaoImpl;
import vn.dao.impl.OrderItemDaoImpl;
import vn.dao.impl._OrderDaoImpl;
import vn.models.*;

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CartDao cartDao = new CartDao();
	CartItem cartItem = new CartItem();
	DeliveryDAO deliveryDAO = new DeliveryDaoImpl();
	_OrderDAO orderDAO = new _OrderDaoImpl();
	OrderItemDAO orderItemDAO = new OrderItemDaoImpl();
	_Order order = new _Order();
	Delivery delivery = new Delivery();
	OrderItem orderItem = new OrderItem();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		int uid = Integer.parseInt(req.getParameter("uid"));
		int caid = cartDao.findcartId(uid);
		int total = 0;
		List<CartItem> listcartItems = cartDao.getAllCartItemByCartId(caid);
		for (CartItem cartItem : listcartItems) {
			total += cartItem.getCount_SP() * cartItem.getProduct().getPrice();
		}
		List<Delivery> deliveries = deliveryDAO.findAllDelivery();
		req.setAttribute("total", total);
		req.setAttribute("listcartitems", listcartItems);
		req.setAttribute("deliveries", deliveries);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/customer/order.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			int caid = 0;
			int toalprice = 0;
			int oid = 0;
			for (FileItem item : items) {
				if(item.getFieldName().equals("uid")) {
					//uid = Integer.parseInt(item.getString());
					caid = cartDao.findcartId(Integer.parseInt(item.getString()));
					order.setUserId(Integer.parseInt(item.getString()));
					//cartItemModel.setCartId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("delivery")) {
					delivery = deliveryDAO.findDeliveryByID(Integer.parseInt(item.getString()));
					order.setDeliveryId(Integer.parseInt(item.getString()));
					//cartItemModel.setProductId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("address")) {
					order.setAddress(item.getString());
					//cartItemModel.setCount_SP(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("phone")) {
					order.setPhone(item.getString());
				} else if (item.getFieldName().equals("total")) {
					toalprice = Integer.parseInt(item.getString());
				}
			}
			toalprice += delivery.getPrice();
			order.setAmountFromUser(toalprice);
			//Them order 
			oid = orderDAO.insertOrder(order);
			insertOrderItems(oid, caid);
			resp.sendRedirect(req.getContextPath() + "/donhangdetail?oid=" + oid);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertOrderItems(int oid, int caid) {
		List<CartItem> cartItems = cartDao.getAllCartItemByCartId(caid);
		for (CartItem cartItem : cartItems) {
			orderItem.setOrderId(oid);
			orderItem.setProductId(cartItem.getProductId());
			orderItem.setCount_SP(cartItem.getCount_SP());
			orderItemDAO.insert(orderItem);
			cartDao.remove(cartItem);
		}
	}

}
