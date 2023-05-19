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
 * Servlet implementation class ProfileController
 */
@WebServlet(urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/WEB-INF/views/customer/profile.jsp").forward(req, resp);
		
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
		String username = req.getParameter("user");
		String phone= req.getParameter("phone");
		String hashed_password = req.getParameter("hashed_password");
		String addresses = req.getParameter("addresses");
		String avatar = req.getParameter("avatar");
		String cover= req.getParameter("cover");
		int point = Integer.parseInt(req.getParameter("point"));
	    Float e_wallet = Float.parseFloat((req.getParameter("e_wallet")));
		int id =Integer.parseInt( req.getParameter("id"));
		UserDao userDao = new UserDao();
		_User acc = userDao.checkuserbyId(id);
		if(acc==null)
		{
			req.getRequestDispatcher("/WEB-INF/views/customer/profile.jsp").forward(req, resp);
			//req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		}
		else
		{
			
			_User account = new _User(id, firstname,lastname,idcard, username,phone,
			  hashed_password,addresses, avatar, cover, point, e_wallet );
			  userDao.editUser(account); 
			  HttpSession session = req.getSession();
			  //session hien thong tin thay doi 
			  session.setAttribute("account", account); 
			  RequestDispatcher rq =req.getRequestDispatcher("/WEB-INF/views/customer/profile.jsp"); 
			  rq.forward(req, resp);
			 
		}
		       
	

	}

}
