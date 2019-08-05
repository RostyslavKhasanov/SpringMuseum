<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 7/16/19
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/resources/images/main.jpg" var="main"/>
<html>
<head>
    <title>Museum</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        <%@include file="../../resources/index.css"%>
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/static/menu.jsp"/>

<div class="firstPage">
    <img src="${main}" style="width: 100%">

    <div class="textMainPage">
        <h1 class="w3-wide" id="welcome-text">WELCOME TO THE MUSEUM</h1>
    </div>
</div>

<p class="w3-justify" id="text-about">Browse this museum for a quick
    history of the<br>
    city that you are about to visit. There are three floors, each<br>
    dedicated to several aspects of the city from economic development,<br>
    social development, and city development to the history of Brussels’<br>
    favourite mascot the Peeing Boy. For only €3, there is a great deal<br>
    to see – just to see the 100 costumes for the Mannekin Pis is
    already worth it.
</p>

<!-- Footer -->
<footer class="page-footer font-small blue" style="background-color: gainsboro">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2018 Copyright:
        <a href="/"> Museum.com</a>
    </div>


</footer>


</body>

</html>
