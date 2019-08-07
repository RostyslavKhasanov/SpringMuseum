<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Exhibits of ${(worker.getFirstName())}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        <%@include file="../../../resources/index.css"%>
    </style>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<div class="row">
    <div class="col-4"></div>
    <div class="col-4" align="center">
        <c:choose>
            <c:when test="${not empty halls}">
                <br><br>
                <h4>Exhibits of <a
                        href="/worker?id=${worker.id}">${(worker.getFirstName())} ${(worker.getSecondName())}</a></h4>
                <br>
                <div>
                    <c:forEach items="${halls}" var="item">
                        <c:forEach items="${item.getExhibits()}" var="item1">
                            <h6><a href="/exhibit?id=${item1.id}" class="list-group-item list-group-item-action disabled">${item1.name}</a></h6>
                        </c:forEach>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <br><br>
                <h2><a
                        href="/worker?id=${worker.id}">${(worker.getFirstName())} ${(worker.getSecondName())}</a>
                    doesn't serve any exhibits!</h2>
            </c:otherwise>
        </c:choose>
        <div class="col-4"></div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
