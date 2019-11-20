<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/view/shared/header.jsp"%>

<div class="container">
    <br>
    <h1>Current Budget</h1>
    <button style="float: right" type="button" class="btn btn-success" onclick="window.location.href ='printPage.html'">Print Budget</button> <br/>
    <h4>.</h4>
    <table style="width:100%">
        <tr>
            <th>Expense</th>
            <th>Amount <button style="float: right" type="button" class="btn btn-success" ><i class="fas fa-plus"></i></button></th>

        </tr>
        <tr>
            <td> <a href="ItemDetail.html">Rent</a> </td>
            <td>$1,000.00 <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button><button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button></td>
        </tr>
        <tr>
            <td><a href="">Phone</a></td>
            <td>$70.00 <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button><button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button></td>
        </tr>
        <tr>
            <td><a href="">Groceries</a></td>
            <td>$90.00 <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button><button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button></td>
        </tr>
        <tr>
            <td><a href="">Electric</a></td>
            <td>$30.00 <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button><button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button></td>
        </tr>
        <tr>
            <td><a href="">Entertainment</a></td>
            <td>$35.00 <button type="button" class="btn" style="float:right;"><i class="fas fa-trash"></i></button><button type="button" class="btn" style="float:right;"><i class="fas fa-pen"></i></button></td>
    </table>

</div>

<%@ include file="/WEB-INF/view/shared/footer.jsp"%>