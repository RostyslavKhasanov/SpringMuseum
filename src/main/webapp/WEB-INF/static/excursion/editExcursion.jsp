<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Katay
  Date: 29.07.2019
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excursion</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        <%@include file="../../../resources/index.css"%>
    </style>
    <title>Title</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-4"></div>
        <form action="/excursion/update" method="post" class="col-4" id="excursionForm">
            <input type="hidden" name="id" value="${excursion.id}">
            <label for="startTime">Start:</label>
            <input id="startTime" type="datetime-local" class="form-control" name="begin" value="${excursion.begin}"/><br>
            <label for="endTime">End:</label>
            <input id="endTime" type="datetime-local" class="form-control" name="end" value="${excursion.end}"/><br>
            <label for="price">Price</label>
            <input type="number" class="form-control" value="100" min="0" step="0.1"
                   data-number-to-fixed="2" data-number-stepfactor="100" class="currency" id="price" name="price"
                   value="${excursion.price}"/>
            <select name="workerId" class="custom-select" required style="margin-top: 10%">
                <c:forEach var="worker" items="${workers}">
                    <option
                            <c:if test="${worker.id == hall.worker.id}">selected</c:if>
                            value="${worker.id}">${worker.firstName} ${worker.secondName}</option>
                </c:forEach>
            </select>
            <br><br>
            <input type="submit" class="btn btn-primary" value="Save"/>
        </form>
    </div>
</div>

</body>
</html>
