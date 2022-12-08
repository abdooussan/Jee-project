<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create account</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div class="header">
	  <img src="S.png" alt="logo" />
	  <h1>Sign up to ShareK</h1>
	</div>
	<h3> share your lessons with your friends and classmates in different formats (pdf, link, image, video ...)</h3><br><br>
	<form method='post' action='registre' id='registre'>
		<p>${error}</p>
		<label for='uname'>First name :</label>
		<input type='text' name='fname' value='${firstname}'><br><br>
		<label for='uname'>Second name :</label>
		<input type='text' name='sname'value='${secondname}'><br><br>
		<label for='uname'>Username :</label>
		<input type='text' name='uname'value='${username}'><br><br>
		<label for='uname'>Email :</label>
		<input type='text' name='email'value='${email}'><br><br>
		<label for='uname'>Password :</label>
		<input type='text' name='pword'value='${password}'><br><br>
		<label for='uname'>Confirm password :</label>
		<input type='text' name='cpword'value='${Cpassword}'><br><br>
		<input type='submit' value='Sign in'  id="button">
	</form><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>