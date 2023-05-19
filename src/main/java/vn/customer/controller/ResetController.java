package vn.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.dao.UserDao;
import vn.models.*;

/**
 * Servlet implementation class ResetController
 */
@WebServlet(urlPatterns = {"/reset-password"})
public class ResetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/customer/editprofile.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("user");
		String hashed_password = req.getParameter("opass");
		String newpass = req.getParameter("pass");
		UserDao userDao = new UserDao();
		_User acc = userDao.checkuser(username);
		if(acc==null)
		{
			req.getRequestDispatcher("/WEB-INF/views/customer/editprofile.jsp").forward(req, resp);
			
		}
		else
		{
			_User account = new _User(username,newpass);
		    userDao.change(account);
		    HttpSession session = req.getSession();
			session.setAttribute("account", account);
			RequestDispatcher rq =req.getRequestDispatcher("/WEB-INF/views/customer/home.jsp");
			rq.forward(req, resp);
		}
	}
	

}
