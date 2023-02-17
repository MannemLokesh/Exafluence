<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body style="background-color: #b5aeb0;">
	<h1 style="color:white; text-align: center;">Opps...</h1>
    <h3 style="color:white; text-align: center;">Sorry, an error occurred.</h3>
    <h4 style="color:#e03669; ">Here is the exception stack trace: </h4>
    <pre style="color:red;"><% exception.printStackTrace(response.getWriter()); %></pre>
</body>
</html>