<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workers</title>
    <style>
        <%@include file="../../../resources/index.css"%>
    </style>
    <link rel="stylesheet" type="text/css"
          href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/smoothness/jquery-ui.css">
</head>
<body>
<jsp:include page="../menu.jsp"/>
<div class="row no-gutter">
    <div class="col-md-10">
        <c:choose>
            <c:when test="${not empty workers}">
                <div class="list-group">
                    <c:forEach items="${workers}" var="item">
                        <a href="?id=${item.id}"
                           class="list-group-item list-group-item-action disabled">${item.firstName} ${item.secondName}
                        </a>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <h3 class="w3-wide" style="margin: 20px;">Not found any worker!</h3>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="col-md-2">
        <div class="col-10" id="workerExhibits">
            <br>
            <form>
                <div class="input-group input-group-sm mb-3">
                    <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                           placeholder="Surname" name="name" id="name" required pattern="^[a-zA-Z]{1,20}$"
                           oninvalid="this.setCustomValidity('only English ')">
                </div>
                <button type="button" class="btn btn-primary" onclick="findByName()">Search</button>
            </form>
            <br><br>
            <button type="button" class="btn btn-primary" onclick="addPostForm()">Add new post</button>
            <br><br>
            <button type="button" class="btn btn-primary" onclick="redirectToWorkerAddForm()">Add new worker
            </button>
            <br><br><br>
            <h6>Delete post:</h6>
            <br>
            <select name="postId" class="custom-select" id="postId">
                <option selected value=""></option>
                <c:forEach var="post" items="${posts}" varStatus="rowCounter">
                    <option value="${post.getId()}">${post.getName()}</option>
                </c:forEach>
            </select>
            <br><br>
            <button type="button" class="btn btn-danger" onclick="deletePost()">Delete
            </button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script type="text/javascript">
    function findByName() {
        var fName = document.getElementById("name").value;
        var input = document.getElementById("name");
        if (input.checkValidity()) {
            document.location.href = "worker?name=" + fName;
        } else {
            alert("Enter surname with eng letters!");
            document.location.reload();
        }
    }

    function addPostForm() {
        document.location.href = "post/add";
    }

    function redirectToWorkerAddForm() {
        document.location.href = "worker/add";
    }

    function deletePost() {
        var e = document.getElementById("postId");
        var strUser = e.options[e.selectedIndex].value;
        if (strUser == "") {
            alert("Choose one!")
        } else {
            document.location.href = "post/delete?id=" + strUser;
        }
    }

    jQuery(function ($) {
        var data = [];
        <c:forEach items="${workers}" var="item">
        data.push("${item.getSecondName()}")
        </c:forEach>
        $("#name").autocomplete({
            source: data
        });
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
