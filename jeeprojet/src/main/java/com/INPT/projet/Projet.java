package com.INPT.projet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.INPT.registre.RegistreDao;




/**
 * Servlet implementation class Projet
 */
@WebServlet("/projet")
public class Projet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Projet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String login = request.getParameter("uname");
		String password = request.getParameter("pword");
		if (login == null) login = "";
		if (password == null) password = "";
		HttpSession session = request.getSession( true );
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		session.setAttribute("loginerror", "");
		request.getRequestDispatcher("/projet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("uname");
		String password = request.getParameter("pword");
		
		HttpSession session = request.getSession( true );
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		session.setAttribute("loginerror", "");

		LoginDao loginDao = new LoginDao();
		LoginBean sign = new LoginBean();
		sign.setUsername(login);
		sign.setPassword(password);
		try {
			boolean status = loginDao.validate(sign);
			
			if (status) {
				System.out.println("connected");
				RegistreDao signDao = new RegistreDao();
				session.setAttribute("username", signDao.getInfo(login).getUsername());
				request.getRequestDispatcher("/home").forward(request, response);
				session.setAttribute("isConnected", true);
			} else {
				System.out.println("failed");
				if(((login != null)&&(login != "")) && ((password!=null)&&(password!="")))session.setAttribute("loginerror", "<p>*login failed</p>");
				request.getRequestDispatcher("/projet.jsp").forward(request, response);
				session.setAttribute("isConnected", false);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
