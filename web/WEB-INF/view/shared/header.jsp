<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Don't Budge... BUDGET!</title>
    <script src="https://kit.fontawesome.com/8242e336e9.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="resources/img/hand-holding-usd-solid.svg" width="50" height="50" alt="">
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home.html">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${contextPath}/budgetBreakdown">Budget <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="budget.html" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Plan Ahead
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">January</a>
                    <a class="dropdown-item" href="#">February</a>
                    <a class="dropdown-item" href="#">March</a>
                    <a class="dropdown-item" href="#">April</a>
                    <a class="dropdown-item" href="#">May</a>
                    <a class="dropdown-item" href="#">June</a>
                    <a class="dropdown-item" href="#">July</a>
                    <a class="dropdown-item" href="#">August</a>
                    <a class="dropdown-item" href="#">September</a>
                    <a class="dropdown-item" href="#">October</a>
                    <a class="dropdown-item" href="#">November</a>
                    <a class="dropdown-item" href="#">December</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign In</button>
        </form>
    </div>
</nav>

