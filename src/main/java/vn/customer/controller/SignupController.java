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
 * Servlet implementation class SignupController
 */
@WebServlet(urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("/decorators/login.jsp");
		 * rd.forward(req, resp);
		 */
		//doPost(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String idcard = req.getParameter("idcard");
		String phone= req.getParameter("phone");
	    Float e_wallet = Float.parseFloat((req.getParameter("e_wallet")));
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		String repass = req.getParameter("repass");
		if(!password.equals(repass))
		{
			resp.sendRedirect("login");
		}
		else
		{
			UserDao userDao = new UserDao();
			_User account = userDao.checkuser(username);
			if(account==null)
			{
				userDao.signup(firstname, lastname, idcard, username,phone,password,e_wallet);
				resp.sendRedirect("login");
				//req.getRequestDispatcher("WEB-INF/views/customer/login.jsp").forward(req, resp);
				//req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
			}
			else
			{
				req.setAttribute("message", "Da ton tai");
				req.getRequestDispatcher("WEB-INF/views/customer/login.jsp").forward(req, resp);
			}
		}

	}

}
