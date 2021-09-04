<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/style.css">
	<title>Condominium  |  info</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		
		response.setHeader("Expires", "0"); //Proxies
		
		session.getAttribute("condCode");
		session.getAttribute("cond");
		
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("index.jsp");
		}
		
	%>

	<!-- NAVBAR -->
	<header>
		<nav id="navbar">
			<div class="container">
				<h1 class="logo">
					<a href="Logout">Logout</a>
				</h1>
				
				<ul>
					<li> <a href="HomePage.jsp">Home</a> </li>
					<li> <a href="Profile.jsp"> Profile</a> </li>
					<li> <a class="current" href="cond-info.jsp">Condominium</a> </li>
				</ul>
			</div>
		</nav>				
	</header>
		
	<!-- SECTION -->
	<section id="condominium-showcase">
	
		<div class="condominium-container">
			<div class="condominium-img">
				<img alt="condominium" src="./img/utente.jpg">
			<p> ${role}</p>
			</div>
			<div class="condominium-info">
				<p>Condominio : ${cond}</p>
				<p>Code: ${condCode}</p>
			</div>
		</div>
		


	</section>
	
</body>
</html>