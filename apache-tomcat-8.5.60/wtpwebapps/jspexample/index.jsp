<%--
  Created by IntelliJ IDEA.
  User: mastro
  Date: 21/11/20
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="loginBean" scope="request" class="jspexample.LoginBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="loginBean" property="*"/>

<%
    if (request.getParameter("login") != null) {
        if (loginBean.validate()) {
%>
        <jsp:forward page="HomePage.jsp"/>
<%
        } else {
%>
<p style="color: red">Dati errati</p>
<%
        }
    }
%>
<html>
<head>
    <title>Login page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="index.jsp" name="myform" method="POST" >
        <div class="row">
            <div class="col-lg-4 form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" autocomplete="off">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 form-group">
                <input type="submit" name="login" value="login">
            </div>
        </div>
    </form>
</div>

</body>
</html>
