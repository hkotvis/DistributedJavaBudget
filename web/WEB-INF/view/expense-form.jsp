<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/shared/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">

    <form:form action="${contextPath}/budget/save" enctype="multipart/form-data" modelAttribute="budget"
               method="post">
        <form:hidden path="userExpenseId" value="${budget.userExpenseId}"/>

        <table>
            <tr>
                <td><label>Expense Name</label></td>
                <td><form:input class="form-control" path="expenses.expenseName"/>
                    <form:errors path="expenses.expenseName" style="color: red;"/></td>
            </tr>
            <tr>
                <td><label>Expense Amount</label></td>
                <td><form:input class="form-control" path="expenseAmount"/>
                    <form:errors path="expenseAmount" style="color: red;"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Save" class="btn btn-primary">
                    &nbsp;<button type="button" class="btn btn-outline-secondary">Cancel</button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
<%@ include file="/WEB-INF/view/shared/footer.jsp"%>


