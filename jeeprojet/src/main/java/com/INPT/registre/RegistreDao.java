package com.INPT.registre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class RegistreDao {
	public RegistreBean getInfo(String username) throws ClassNotFoundException {
		RegistreBean user = new RegistreBean();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "7GK30hj)=))");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from users where username = ? ")) {
			preparedStatement.setString(1, username);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				user.setID(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setSecondname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return user;
		}
	public String validate(RegistreBean registreBean) throws ClassNotFoundException {
		String error = "";

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "7GK30hj)=))");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select firstname, lastname from users where firstname = ? and lastname = ? ")) {
			preparedStatement.setString(1, registreBean.getFirstname());
			preparedStatement.setString(2, registreBean.getSecondname());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) error=error+"<br>*firstname and secondname are already exist";

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "7GK30hj)=))");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select username from users where username = ?")) {
			preparedStatement.setString(1, registreBean.getUsername());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) error=error+"<br>*username already exist";

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return error;
	}

	public void registre(RegistreBean registreBean) throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "7GK30hj)=))");
				Statement stmt = connection.createStatement();){
			String sql = "INSERT INTO users (firstname, lastname, username, email, password) VALUES ('"+registreBean.getFirstname()+"', '"+registreBean.getSecondname()+"', '"+registreBean.getUsername()+"', '"+registreBean.getEmail()+"', '"+registreBean.getPassword()+"')";

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
