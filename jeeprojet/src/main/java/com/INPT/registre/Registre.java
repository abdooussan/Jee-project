package com.INPT.registre;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;




/**
 * Servlet implementation class Projet
 */
@WebServlet("/registre")
public class Registre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("fname");
		String secondname = request.getParameter("sname");
		String email = request.getParameter("email");
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		String Cpassword = request.getParameter("cpword");
		if (firstname == null) firstname = "";
		if (secondname == null) secondname = "";
		if (username == null) username = "";
		if (email == null) email = "";
		if (password == null) password = "";
		HttpSession session = request.getSession( true );
		session.setAttribute("firstname", firstname);
		session.setAttribute("secondname", secondname);
		session.setAttribute("username", username);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		session.setAttribute("Cpassword", Cpassword);
		request.getRequestDispatcher("/registre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("fname");
		String secondname = request.getParameter("sname");
		String email = request.getParameter("email");
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		String Cpassword = request.getParameter("cpword");
		
		HttpSession session = request.getSession( true );
		session.setAttribute("firstname", firstname);
		session.setAttribute("secondname", secondname);
		session.setAttribute("username", username);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		session.setAttribute("Cpassword", Cpassword);

		RegistreDao signDao = new RegistreDao();
		RegistreBean sign = new RegistreBean();
		sign.setFirstname(firstname);
		sign.setSecondname(secondname);
		sign.setEmail(email);
		sign.setUsername(username);
		sign.setPassword(password);;
		try {
			String error = signDao.validate(sign);
			if(password.length() < 6) error = error + "<br>*password too short ( 6 caracters at least)";
			if(!request.getParameter("cpword").equals(password)) error = error + "<br>*password doesn't match<h1>hello</h1>";
			session.setAttribute("error", error);
			if (error != "") {
				System.out.println("failed");
				System.out.println(error);
				System.out.println(request.getParameter("cpword"));
				System.out.println(request.getParameter("pword"));
				System.out.println(request.getParameter("cpword"));
				System.out.println(request.getParameter("pword"));
				request.getRequestDispatcher("/registre.jsp").forward(request, response);
				session.setAttribute("isConnected", false);
			} else {
				try {
					signDao.registre(sign);
					request.getRequestDispatcher("home").forward(request, response);
					session.setAttribute("isConnected", true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
