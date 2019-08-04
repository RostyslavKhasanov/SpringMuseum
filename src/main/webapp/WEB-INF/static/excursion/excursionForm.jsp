<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Katay
  Date: 20.07.2019
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        <%@include file="../../../resources/index.css"%>
    </style>
    <title>Excursion</title>
    <link rel="stylesheet" href="../../../resources/index.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-4"></div>
        <pre id="main-text">Please, enter the period you want to visit
            excursion in our museum.</pre>
        <div class="excursionForm col-4" style="margin-left: 32%">
            <label for="startTime">Start:</label>
            <input id="startTime" type="datetime-local" name="begin" class="form-control" aria-label="Begin" aria-describedby="basic-addon2" required><br>
            <label for="endTime">End:</label>
            <input id="endTime" type="datetime-local" name="end" class="form-control" aria-label="End" aria-describedby="basic-addon2" required><br>
            <button type="button" class="btn btn-primary" onclick="submitAction()">Submit</button>
        </div>
    </div>
</div>
</body>
<script>
    function submitAction() {
        var start = document.getElementById("startTime").value;
        var end = document.getElementById("endTime").value;

        // Check if empty of not
        if (start.length < 1 || end.length < 1) {
            alert('Please, write in all fields');
            return false;
        }
        // alert(start);
        document.location.href = "http://localhost:8080//excursion/byPeriod?start=" + start + "&end=" + end;
    }

</script>
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
