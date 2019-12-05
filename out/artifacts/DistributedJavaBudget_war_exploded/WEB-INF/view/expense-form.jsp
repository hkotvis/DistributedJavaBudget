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
                <td><form:input class="form-control" path="expenseName"/>
                    <form:errors path="expenseName" style="color: red;"/></td>
            </tr>
            <tr>
                <td><label>Expense Amount</label></td>
                <td><form:input class="form-control" path="expenseAmt"/>
                    <form:errors path="expenseAmt" style="color: red;"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="btn btn-primary">&nbsp;<button type="button" class="btn btn-outline-secondary">Cancel</button></td>
            </tr>
        </table>
    </form:form>

</div>
<%@ include file="/WEB-INF/view/shared/footer.jsp"%>


