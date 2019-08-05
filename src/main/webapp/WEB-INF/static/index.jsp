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
<footer
        class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge"
        style="background-color: gainsboro">
    <!-- Footer Links -->
    <div class="container">

        <!-- Grid row-->
        <div class="row text-center d-flex justify-content-center pt-5 mb-3">

            <!-- Grid column -->
            <div class="col-md-2 mb-3">
                <h6 class="text-uppercase font-weight-bold">
                    <a href="#!">About us</a>
                </h6>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-2 mb-3">
                <h6 class="text-uppercase font-weight-bold">
                    <a href="#!">Awards</a>
                </h6>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-2 mb-3">
                <h6 class="text-uppercase font-weight-bold">
                    <a href="#!">Help</a>
                </h6>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-2 mb-3">
                <h6 class="text-uppercase font-weight-bold">
                    <a href="#!">Contact</a>
                </h6>
            </div>
            <!-- Grid column -->

        </div>

        <div class="footer-copyright text-center text-black-50 py-3">© 2018 Copyright:
            <a class="dark-grey-text" href="#!"> Museum.com</a>
        </div>

    </div>
    <!-- Footer Links -->
</footer>
<!-- Footer -->

</body>

</html>
