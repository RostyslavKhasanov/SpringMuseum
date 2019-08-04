<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="row no-gutter" style="margin-left: 1px">
    <div class="col-md-10">
        <c:choose>
            <c:when test="${not empty excursions}">
                <button type="button" id="openModal" class="btn btn-primary">Show statistic</button>
                <h4 id="modal">Count of excursions at this period: ${excursionsStatistic}</h4>
                <div class="list-group">
                    <c:forEach items="${excursions}" var="item">

                        <a href="/excursion?id=${item.id}"
                           class="list-group-item list-group-item-action disabled">${item.description}
                        </a>

                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <h3 class="w3-wide" style="margin: 20px;">Not found any excursions!</h3>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="col-md-2">
        <div class="col-10">
            <a href="/excursion/add" class="btn btn-primary" style="float: right">Add new
                excursion</a>

            <a href="/excursion/byPeriodForm" class="btn btn-primary" style="float: right; margin-top: 15px">Find
                by period</a>
        </div>
    </div>
</div>
<script>
getInfoAboutCount();

function getInfoAboutCount() {

var modal = document.getElementById("modal");

var btn = document.getElementById("openModal");

btn.onclick = function () {
        $(modal).slideToggle();
        modal.style.display = "block";
        };
        }
        </script>
        </body>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        </html>
