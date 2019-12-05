<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/view/shared/header.jsp" %>

<div class="container">
    <br>
    <h1>This Month's Budget: ${inputBudget.dollarAmt}</h1>
    <h3>Remaining Budget: </h3>
    <button style="float: right" type="button" class="btn btn-success" onclick="window.location.href ='printPage.html'">
        Print Budget
    </button>
    <br/>
    <h4>.</h4>
    <table style="width:100%">
        <tr>
            <th>Expense</th>
            <th>Amount</th>
            <th><a style="float: right" href="${contextPath}/budget/showAddExpenseForm" class="btn btn-success"><i class="fas fa-plus"></i></a></th>
        </tr>

        <form:form action="search" method="GET">
            Search Expenses <input type="search" name="searchTerm"/>
            <input type="submit" value="Search" class="btn btn-primary"/>
        </form:form>

        <c:forEach var="tempExp" items="${expenses}">

            <!-- construct an "update" link with donut id -->
            <!-- c:url is same as JSP's response.encodeURL() -->
<%--            <c:url var="updateLink" value="/budget/showUpdateExpenseForm">--%>
<%--                <c:param name="expenseId" value="${tempExp.expenseId}"/>--%>
<%--            </c:url>--%>

<%--            <!-- construct a "delete" link with donut id -->--%>
<%--            <c:url var="deleteLink" value="/budget/delete">--%>
<%--                <c:param name="expenseId" value="${tempExp.expenseId}"/>--%>
<%--            </c:url>--%>

            <tr>
                <td>${tempExp.expenses.expenseName}</td>
                <td>${tempExp.expenseAmount}</td>
<%--                <td>Update | Delete--%>
<%--                    <!-- display the update link -->--%>
<%--                    <a href="${updateLink}">Update</a>--%>
<%--                    |--%>
<%--                    <!-- display the delete link -->--%>
<%--                    <a href="${deleteLink}"--%>
<%--                       onclick="if (!confirm('Are you sure?')) return false">Delete</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>


        <tr>
            <td><a href="ItemDetail.html">Rent</a></td>
            <td>$1,000.00
                <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button>
                <button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button>
            </td>
        </tr>
        <tr>
            <td><a href="">Phone</a></td>
            <td>$70.00
                <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button>
                <button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button>
            </td>
        </tr>
        <tr>
            <td><a href="">Groceries</a></td>
            <td>$90.00
                <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button>
                <button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button>
            </td>
        </tr>
        <tr>
            <td><a href="">Electric</a></td>
            <td>$30.00
                <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button>
                <button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button>
            </td>
        </tr>
        <tr>
            <td><a href="">Entertainment</a></td>
            <td>$35.00
                <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button>
                <button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button>
            </td>
    </table>

</div>

<%@ include file="/WEB-INF/view/shared/footer.jsp" %>