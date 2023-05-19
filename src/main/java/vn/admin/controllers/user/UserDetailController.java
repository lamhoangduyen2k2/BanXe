package vn.admin.controllers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.models._User;
import vn.service._UserService;
import vn.service.impl._UserServiceImpl;

@WebServlet(urlPatterns = ("/admin/user/detail"))
public class UserDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	_UserService userService = new _UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("_id"));
		_User user = userService.findUserByID(id);
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/user/user_detail.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
