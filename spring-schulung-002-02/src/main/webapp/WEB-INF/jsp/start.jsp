<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                      "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	<h2>---COUNTER----</h2>
	<p>${hallowelt_counter}</p>
	<p>---------------------------</p>

	<h2>Links</h2>
	<a href="request_session">session</a>
	<a href="request_session_increment">session increment</a>
	<br>
	<a href="request_request">request</a>
	<a href="request_request_increment">request increment</a>
	<br>
	<a href="request_global">requestglobal</a>
	<a href="request_global_increment">requestglobal increment<br>
	<br>
	<a href="invalidate_session">invalidate session</a>
</body>
</html>
