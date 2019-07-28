<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../style/index.css"%>
    </style>
    <title>Museum</title>
    <link rel="stylesheet" href="../style/index.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../menu.jsp"/>
<div class="worker-container">
    <div class="row">
        <div class="col">
        </div>
        <div class="col-6">
            <table class="table table-hover" id="workerTable">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${workers}" var="item">
                    <tr>
                        <th scope="row"><a
                                href="http://localhost:8080/museum/worker?id=${(item.getId())}">${(item.getId())}</a>
                        </th>
                        <td><a href="http://localhost:8080/worker?id=${(item.getId())}">${(item.getFirstName())}</a>
                        </td>
                        <td><a href="http://localhost:8080/worker?id=${(item.getId())}">${(item.getSecondName())}</a>
                        </td>
                        <td>
                            <form action="/worker/delete" style="margin-block-end: 0em;" method="post">
                                <input type="hidden" name="id" value="${item.getId()}">
                                <input type="submit" class="btn btn-outline-danger" value="Delete"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col">
            <div class="col-10">
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="spanName">Full name</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                           id="name">
                </div>
                <button type="button" class="btn btn-primary" onclick="findByName()">Search</button>
                <br><br>
                <button type="button" class="btn btn-primary" onclick="addPostForm()">Add new post</button>
                <br><br>
                <button type="button" class="btn btn-primary" onclick="redirectToWorkerAddForm()">Add new worker
                </button>
            </div>
        </div>
    </div>
</div>
</table>
</body>
<script>
    function findByName() {
        var fName = document.getElementById("name").value;
        document.location.href = "http://localhost:8080/worker?name=" + fName;
    }

    function addPostForm() {
        document.location.href = "http://localhost:8080/post/add";
    }

    function redirectToWorkerAddForm() {
        document.location.href = "http://localhost:8080/worker/add";
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
