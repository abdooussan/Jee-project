package com.INPT.newArticle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewArticleDao {
	public void createArticle(NewArticleBean newArticleBean) throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "7GK30hj)=))");
				Statement stmt = connection.createStatement();){
			String sql = "INSERT INTO articles (id_user , title, article, tags) VALUES ('"+newArticleBean.getId()+"', '"+newArticleBean.getTitle()+"', '"+newArticleBean.getArticle()+"', '"+newArticleBean.getTags()+"')";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			printSQLException(e);
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
