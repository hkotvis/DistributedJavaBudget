<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/view/shared/header.jsp"%>

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
                            <form:form modelAttribute="inputBudget" action="budget/showBudget">
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

<%@ include file="/WEB-INF/view/shared/footer.jsp"%>