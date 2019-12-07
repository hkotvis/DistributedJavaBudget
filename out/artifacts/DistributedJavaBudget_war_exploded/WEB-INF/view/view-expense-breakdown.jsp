<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/view/shared/header.jsp" %>

<div class="container">
    <br>
    <h1>This Month's Budget: ${inputBudget.amountMonthly}</h1>
    <h5>Remaining Budget: </h5>
    <form:form action="search" method="GET">
        Search Expenses <br>
        <input type="search" class="form-control" name="searchTerm"/>
        <input type="submit" value="Search" class="btn btn-primary"/>
    </form:form>
    <br/><br>
    <table style="width:100%">
        <tr>
            <th>Expense</th>
            <th>Amount</th>
            <th><a style="float: right" href="${contextPath}/budget/showAddExpenseForm" class="btn btn-success"><i class="fas fa-plus"></i></a></th>
            <hr>
        </tr>

        <c:forEach var="tempExp" items="${expenses}">
            <c:url var="updateLink" value="/budget/showUpdateExpenseForm">
                <c:param name="userExpenseId" value="${tempExp.userExpenseId}"/>
            </c:url>

            <!-- construct a "delete" link with donut id -->
            <c:url var="deleteLink" value="/budget/delete">
                <c:param name="userExpenseId" value="${tempExp.userExpenseId}"/>
            </c:url>

            <tr>
                <td><a href="" onclick="(alert('Details: ${tempExp.details}'))">${tempExp.expenses.expenseName}</a></td>
                <td>${tempExp.expenseAmount}</td>
                <td>
                    <a class="btn" href="${deleteLink}" style="float:right;" onclick="if (!confirm('Are you sure?')) return false"><i class="fas fa-trash"></i></a>
                    <a class="btn" href="${updateLink}" style="float:right;"><i class="fas fa-pen"></i></a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@ include file="/WEB-INF/view/shared/footer.jsp" %>