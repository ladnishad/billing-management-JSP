<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Bills</title>
</head>
<body>
<form action="ListBillController?action=listbill" method="post">
	<label for="ItemName">Enter BillID: </label>
	<input type="text" id="BillIDinput" name="BillIDinput" required>
	<input type="submit" value="Search Bill" id="searchBill" name="searchBill">
</form>
		<c:if test="${!empty listbill}">
        <table border="1">
            <caption><h2>List of Items</h2></caption>
            <tr>
                <th>BillID</th>
                <th>Item</th>
                <th>Harshit</th>
                <th>Harish</th>
                <th>Deep</th>
                <th>Nishad</th>
                <th>Qty</th>
                <th>Total Cost</th>
            </tr>
            <c:forEach var="bill" items="${listbill}">
                <tr>
                    <td><c:out value="${bill.getBillID()}" /></td>
                    <td><c:out value="${bill.getBillItem()}" /></td>
                    <td><c:out value="${bill.getHarshitCost()}" /></td>
                    <td><c:out value="${bill.getHarishCost()}" /></td>
                    <td><c:out value="${bill.getDeepCost()}" /></td>
                    <td><c:out value="${bill.getNishadCost()}" /></td>
                    <td><c:out value="${bill.getTotalQty()}" /></td>
                    <td><c:out value="${bill.getTotalCost()}" /></td>
                </tr>
            </c:forEach>
            
        </c:if>        	
        </table>
        
        <c:if test="${!empty listbillTotal}">
        <table border="1" style="width:300px;">
            <c:forEach var="billTotal" items="${listbillTotal}">
                <tr>
                    <td colspan="3"><strong>Total</strong></td>
                    <td><strong><c:out value="${billTotal.getHarshitTotal()}" /></strong></td>
                    <td><strong><c:out value="${billTotal.getHarishTotal()}" /></strong></td>
                    <td><strong><c:out value="${billTotal.getDeepTotal()}" /></strong></td>
                    <td><strong><c:out value="${billTotal.getNishadTotal()}" /></strong></td>
                    <td colspan="2"><strong><c:out value="${billTotal.getTotal()}" /></strong></td>
                </tr>
            </c:forEach>
            
        </c:if>        	
        </table>
        
		</body>
</html>