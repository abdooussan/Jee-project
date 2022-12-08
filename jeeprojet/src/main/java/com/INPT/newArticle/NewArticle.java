package com.INPT.newArticle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.INPT.registre.RegistreDao;



/**
 * Servlet implementation class NewArticle
 */
@WebServlet("/newarticle")
public class NewArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
           /**
     * @see HttpServlet#HttpServlet()
     */
    public NewArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String article = request.getParameter("article");
		String tags = request.getParameter("tags");
		if (title == null) title = "";
		if (article == null) article = "";
		if (tags == null) tags = "";
		HttpSession context = request.getSession( true );
		context.setAttribute("title", title);
		context.setAttribute("article", article);
		context.setAttribute("tags", tags);
		request.getRequestDispatcher("/newArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String article = request.getParameter("article");
		String tags = request.getParameter("tags");
		HttpSession context = request.getSession( true );
		String username = (String)context.getAttribute("username");
		RegistreDao signDao = new RegistreDao();
		int id=1;
		try {
			id = signDao.getInfo(username).getID();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		context.setAttribute("title", title);
		context.setAttribute("article", article);
		context.setAttribute("tags", tags);
		
		NewArticleDao newAricleDao = new NewArticleDao();
		NewArticleBean newArticle = new NewArticleBean();
		
		newArticle.setTitle(title);
		newArticle.setArticle(article);
		newArticle.setTags(tags);
		newArticle.setId(id);
		try {
			if(article == null) {
				request.getRequestDispatcher("/newArticle.jsp").forward(request, response);
			} else {
				newAricleDao.createArticle(newArticle);
				request.getRequestDispatcher("/home").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
