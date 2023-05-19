package vn.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import vn.dao.*;
import vn.models.*;

/**
 * Servlet implementation class CartController
 */
@WebServlet(urlPatterns = { "/cart/cart-list", "/cart/cart-addtoCart", "/cart/cart-delete", "/cart/cart-increase", "/cart/cart-remove" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CartDao cartDao = new CartDao();
	CartItem cartItem = new CartItem();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession(true);
		if(session.getAttribute("account")==null)
		{
			req.getRequestDispatcher("/WEB-INF/views/customer/login.jsp").forward(req, resp);
		}
		else
		{
			if (url.contains("cart-increase")) {
				increase(req, resp);
			} else if (url.contains("cart-delete")) {
				descrease(req, resp);
			}
			findAll(req, resp);
			req.getRequestDispatcher("/WEB-INF/views/customer/cart.jsp").forward(req, resp);
		}

	}

	
	protected void findAll(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {

		try {
			int total = 0;
			int uid = Integer.parseInt(req.getParameter("uid"));
			int caid = cartDao.findcartId(uid);
			List<CartItem> listallcartitems = cartDao.getAllCartItemByCartId(caid);
			for (CartItem cartItem : listallcartitems) {
				total += cartItem.getCount_SP() * cartItem.getProduct().getPrice();
			}
			req.setAttribute("total", total);
			req.setAttribute("caid", caid);
			req.setAttribute("listcartitems", listallcartitems);
			


		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

	}
	
	protected void increase(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {

		try {
			int caItemId = Integer.parseInt(req.getParameter("caItemId"));
			cartItem = cartDao.findCartItemById(caItemId);
			if(cartDao.checkCountSP(cartItem.getCount_SP(), cartItem.getProduct().getQuantity())) {
			cartDao.increaseitem(cartItem); }
		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

	}
	protected void descrease(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {

		try {
			String message = null;
			int caItemId = Integer.parseInt(req.getParameter("caItemId"));
			cartItem = cartDao.findCartItemById(caItemId);
			if(cartItem.getCount_SP() == 1 ) {
				cartDao.remove(cartItem);
				message = "Đã xóa sản phẩm ra khỏi giỏ hàng";
				req.setAttribute("message", message);
			} else {
				cartDao.descreaseitem(cartItem);
			}
		} catch (Exception e) {

			e.printStackTrace();

			req.setAttribute("error", "Eror: " + e.getMessage());

		}

	}
	private int isExisting(int productId, List<CartItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().get_id() == productId) {
				return i;
			}
		}
		return -1;
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		/*
		 * CartDao cartDao = new CartDao(); String cartid = "1";
		 */
		if(url.contains("cart-addtoCart"))
		{
			cartItem = new CartItem();
			int caid = 0;
			int uid = 0;
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			servletFileUpload.setHeaderEncoding("UTF-8");
			try {
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				List<FileItem> items = servletFileUpload.parseRequest(req);
				
				for (FileItem item : items) {
					if(item.getFieldName().equals("uid")) {
						uid = Integer.parseInt(item.getString());
						caid = cartDao.findcartId(Integer.parseInt(item.getString()));
						cartItem.setCartId(caid);
						//cartItemModel.setCartId(Integer.parseInt(item.getString()));
					} else if (item.getFieldName().equals("productid")) {
						cartItem.setProductId(Integer.parseInt(item.getString()));
						//cartItemModel.setProductId(Integer.parseInt(item.getString()));
					} else if (item.getFieldName().equals("quantity")) {
						cartItem.setCount_SP(Integer.parseInt(item.getString()));
						//cartItemModel.setCount_SP(Integer.parseInt(item.getString()));
					}
				}
				//cartDao.insertCartItem(cartItemModel);
				cartDao.addCartItem(cartItem);
				resp.sendRedirect(req.getContextPath() + "/cart/cart-list?uid=" + uid);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);*/
		}
	}
	
}
