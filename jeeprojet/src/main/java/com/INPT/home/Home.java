package com.INPT.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String select = request.getParameter("select");
		String username = (String) request.getSession(true).getAttribute("username");
		String newArticle = request.getParameter("button");
		if("newarticle".equals(newArticle)) {
		request.getSession( true ).setAttribute("username", username);
		request.getRequestDispatcher("newarticle").forward(request, response);
		}
		if(select == null) select="all";
		
		String html = "<h1></h1>";
		System.out.println("result is"+request.getParameter("recherche"));
		if(search == null) search = request.getParameter("recherche");
		if(search == null) search = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "7GK30hj)=))");
					// Step 2:Create a statement using connection object
					Statement stmt = connection.createStatement();) {
				String sql="";
				if (request.getParameter("recherche") == null || request.getParameter("recherche") == "") {
					if ("all".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and (username like '%"
								+ search + "%' or article like '%" + search + "%' or title like '%" + search
								+ "%' or tags like '%" + search + "%') order by date desc";
					if ("users".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and (username like '%"
								+ search + "%') order by date desc";
					if ("titles".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and (title like '%"
								+ search + "%') order by date desc";
					if ("articles".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and (article like '%"
								+ search + "%') order by date desc";
					if ("myarticles".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and username like '%"
								+ username + "%' and (article like '%" + search + "%' or title like '%" + search
								+ "%') order by date desc";
				}else {
					sql = "select username, article, date, title, tags from articles, users where id_user=id and (tags like '%#"
							+ search + "#%' or tags like '%#"+ search + "' or tags like '%#"+ search + " ' or tags like '%#"+ search + " #') order by date desc";
				}
				System.out.println("requet is "+sql);
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					html = html + "<hr>";
					html = html + "<h3 id='username'>"+rs.getString("username")+"</h3>";
					html = html + "<h2 id='title'>"+rs.getString("title")+"</h2> <h5 id='date'>"+rs.getString("date")+"</h5>";
					html = html + "<h3 id='article'>"+rs.getString("article")+"</h3><br>";
					if (!(rs.getString("tags")==null ||  rs.getString("tags")=="")) {
						for (String a : rs.getString("tags").substring(1).split("#")) {
							html = html + "<a href='home?recherche=" + a + "'>#" + a + " </a>";
						} 
					}
					html = html + "<br><hr>";
				}
				
			} catch (SQLException e) {
				// process sql exception
				printSQLException(e);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getSession( true ).setAttribute("html", html);
		request.getSession( true ).setAttribute("search", search);
		request.getSession( true ).setAttribute("selected", select);
		request.getSession( true ).setAttribute("username", username);
		System.out.println(username);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		String select = request.getParameter("select");
		String username = (String) request.getSession(true).getAttribute("username");
		String newArticle = request.getParameter("button");
		if(select == null) select="all";
		
		String html = "";
		System.out.println("result is"+request.getParameter("recherche"));
		if(search == null) search = request.getParameter("recherche");
		if(search == null) search = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "7GK30hj)=))");
					// Step 2:Create a statement using connection object
					Statement stmt = connection.createStatement();) {
				String sql="";
				
				if (request.getParameter("recherche") == null || request.getParameter("recherche") == "") {
					if ("all".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and (username like '%"
								+ search + "%' or article like '%" + search + "%' or title like '%" + search
								+ "%' or tags like '%" + search + "%') order by date desc";
					if ("users".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and (username like '%"
								+ search + "%') order by date desc";
					if ("titles".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and (title like '%"
								+ search + "%') order by date desc";
					if ("articles".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and (article like '%"
								+ search + "%') order by date desc";
					if ("myarticles".equals(select))
						sql = "select username, article, date, title, tags from articles, users where id_user=id and username like '%"
								+ username + "%' and (article like '%" + search + "%' or title like '%" + search
								+ "%') order by date desc";
				}else {
					sql = "select username, article, date, title, tags from articles, users where id_user=id and (tags like '%#"
							+ search + "#%' or tags like '%#"+ search + "' or tags like '%#"+ search + " ' or tags like '%#"+ search + " #') order by date desc";
				}
				System.out.println("requete is "+sql);
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					html = html + "<hr>";
					html = html + "<h3 id='username'>"+rs.getString("username")+"</h3>";
					html = html + "<h2 id='title'>"+rs.getString("title")+"</h2> <h5 id='date'>"+rs.getString("date")+"</h5>";
					html = html + "<h3 id='article'>"+rs.getString("article")+"</h3><br>";
					if (!(rs.getString("tags")==null ||  rs.getString("tags")=="")) {
						for (String a : rs.getString("tags").substring(1).split("#")) {
							html = html + "<a href='home?recherche=" + a + "'>#" + a + " </a>";
						} 
					}
					html = html + "<br><hr>";
				}
				
			} catch (SQLException e) {
				// process sql exception
				printSQLException(e);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getSession( true ).setAttribute("html", html);
		request.getSession( true ).setAttribute("search", search);
		request.getSession( true ).setAttribute("selected", select);
		request.getSession( true ).setAttribute("username", username);
		System.out.println(select);
		
		if("newarticle".equals(newArticle)) {
			request.getSession( true ).setAttribute("username", username);
			request.getRequestDispatcher("newarticle").forward(request, response);
			}else {
		request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
