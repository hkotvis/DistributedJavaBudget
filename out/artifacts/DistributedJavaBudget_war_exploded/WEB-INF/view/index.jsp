<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Don't Budge, BUDGET!</title>
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
                <a class="nav-link" href="currentBudget.html">Budget <span class="sr-only">(current)</span></a>
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

<div class="container">
    <br>
    <h1>Don't Budge, BUDGET!</h1>
    <h3>Instructions</h3>
    <div class="home">
        <p>Click the button below to create the month's budget!</p>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">Start Now</button>
    </div>
    <div class="">

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Monthly Income</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                            <!-- This is the input for monthly income -->
                            <form:form modelAttribute="inputBudget" action="showBudget">
                            <div class="input-group mb-3"> <div class="input-group-prepend"><span class="input-group-text">$</span> </div>
                                <form:input type="number" class="form-control" aria-label="Amount (to the nearest dollar)" path="dollarAmt" />
                                <div class="input-group-append" required>
                                    <span class="input-group-text">.00</span> </div></div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <input type="submit" class="btn btn-primary"  value="Save"/> <!--onclick="window.location.href ='budget.html'" -->
                            </div>
                            </form:form>
                        </div>
                </div>
            </div>
        </div>
    </div>

   </div> <!-- end of container -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>