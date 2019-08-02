<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.time.format.DateTimeFormatter" %>
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

<a href="/excursion/add" class="btn btn-primary" style="float: right; margin-top: 5px; margin-right: 5px">Add new
    excursion</a> <br><br>

<a href="/excursion/byPeriodForm" class="btn btn-primary" style="float: right; margin-top: 5px; margin-right: 5px">Find
    by period</a>

<div class="w3-container w3-content w3-center w3-padding-64 w3-card-8"
style="max-width: 800px; margin: 30px">
<h2 class="w3-wide">Excursions in given time period:</h2>
<c:choose>
    <c:when test="${not empty excursions}">
        <button type="button" id="openModal" class="btn btn-primary">Show statistic</button>
        <div class="container">
            <div class="row">

                <div class="col-1"></div>

                    <div class="author-exhibits col-10">

                        <div class="info">
                            <div>Start: ${excursion.begin.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))}</div>
                            <div>End: ${excursion.end.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))}</div>
                            <div>Price, UAH: ${excursion.price}</div>
                        </div>
                            <div class="worker">
                                Responsible worker:
                                <a href="/worker?id=${hall.worker.id}">${hall.worker.firstName} ${hall.worker.secondName}</a>
                            </div>

                    </div>


            <div class="buttons col-1">
                <a href="/author/edit?id=${excursion.id}" class="btn btn-primary">Edit</a>

                    <button type="button" class="btn btn-primary" onclick="deleteExcursion(${excursion.id})">Delete this
                    excursion
                    </button>
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
