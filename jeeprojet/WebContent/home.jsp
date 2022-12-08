<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.INPT.registre.RegistreDao" %>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="style2.css" />
</head>
<body>
	<%String username = (String)request.getSession().getAttribute("username");
	RegistreDao signDao = new RegistreDao();
	String firstname="",secondname="";
	try {
		firstname = signDao.getInfo(username).getFirstname();
		secondname = signDao.getInfo(username).getSecondname();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	if(firstname == null) firstname ="no one";
	if(secondname == null) secondname ="no one";%>
	<div class="header">
	  <img src="S.png" alt="logo" />
	  <h1> Welcome <%=firstname + " " + secondname%></h1>
	</div><br><br><br>
	<%String select = (String)request.getSession().getAttribute("selected");
	if(select == null) select = "";
	String all="",users="",titles="",articles="",myarticles="";
	if(select.equals("all")) all = "selected";
	if(select.equals("users")) users = "selected";
	if(select.equals("titles")) titles = "selected";
	if(select.equals("articles")) articles = "selected";
	if(select.equals("myarticles")) myarticles = "selected";
	System.out.println("select is "+select);
	System.out.println("titles is "+titles);
	%>
	<form action="home" id='search'>
		<input type='search' name='search' value='${search}'>
		<select name="select" id="select">
		  <option value="all" <%=all%>>All</option>
		  <option value="users" <%=users%>>Users</option>
		  <option value="titles" <%=titles%>>Titles</option>
		  <option value="articles" <%=articles%>>Articles</option>
		  <option value="myarticles" <%=myarticles%>>My articles</option>
		</select>
		<input type='submit' value='Search' id="button"><br><br>
		<button type="submit" name="button" value="newarticle" id="button2">Create new article</button><br><br>
		<button type="submit" name="button" formaction="projet" id="button">logout</button>
	</form><br><br>
	${html}
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>