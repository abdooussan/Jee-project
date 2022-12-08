<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div class="header">
	  <img src="S.png" alt="logo" />
	  <h1>Sign up to ShareK</h1>
	</div>
	<h3> share your knowledge with our community</h3><br><br>
	<form method='post' action='projet' id='login'>
		${loginerror}
		<label for='uname'>Username :</label>
		<input type='text' name='uname' value="${login}"><br><br>
		<label for='uname'>Password :</label>
		<input type='password' name='pword' value="${password}"><br><br>
		<input type='submit' value='Sign up' id="button"><br><br>
	</form>
	<form action="registre" id='createAccount'>
		
		you don't have account?<button id="textButton"><h4>Create an account</h4></button>
	    
	</form><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	
</body>
</html>