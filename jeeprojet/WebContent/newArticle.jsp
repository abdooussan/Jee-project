<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create an article</title>
<link rel="stylesheet" href="style3.css" />
</head>
<body>
	<div class="header">
	  <img src="S.png" alt="logo" />
	  <h1> Create an article</h1>
	</div><br><br><br>
	<form method='post' action='newarticle'>
		<label for='title'>Title :</label>
		<input type='text' name='title'><br><br>
		<label for='article'>Create new article :</label><br>
		<textarea name="article">write your article here</textarea><br><br>
		<label for='tags'>Tags :</label>
		<input type='text' name='tags'><br><br><br>
		<input type='submit' value='finish'id="button">
	</form><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>