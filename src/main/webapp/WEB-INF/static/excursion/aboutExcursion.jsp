<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
  Created by IntelliJ IDEA.
  User: Katay
  Date: 02.08.2019
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excursion Information</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <div class="info">
                <c:set var="beginI" value="${excursion.begin}"/>
                <c:set var="begin" value="${fn:replace(beginI, 'T', ' ')}"/>
                <c:set var="endI" value="${excursion.end}"/>
                <c:set var="end" value="${fn:replace(endI, 'T', ' ')}"/>
                <div>Start: ${begin}</div>
                <div>End: ${end}</div>
                <div>Price, UAH: ${excursion.price}</div>
            </div>
            <div class="worker">
                Responsible worker:
                <a href="/worker?id=${excursion.worker.id}">${excursion.worker.firstName} ${excursion.worker.secondName}</a>
            </div>
        </div>

        <div class="buttons col-1">
            <a href="/excursion/edit?id=${excursion.id}" class="btn btn-primary">Edit</a>
            <button type="button" class="btn btn-primary" onclick="deleteExcursion(${excursion.id})"
                    style="margin-top: 10px">Delete this
                excursion
            </button>
        </div>

    </div>
</div>

</body>
<script>
    function deleteExcursion(id) {
        var isDelete = confirm("Do you really want to delete this excursion?");
        if (isDelete) {
            window.location.href = "http://localhost:8080/excursion/delete?id=" + id;
        }
    }
</script>
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
