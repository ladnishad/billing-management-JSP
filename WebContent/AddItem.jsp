<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add and view items</title>
</head>
<body>

<input type="button" onclick="location.href='Homepage.jsp'" value="Home" class="button" id="HomeButton" name="HomeButton">
<input type="button" onclick="location.href='ViewBills.jsp'" value="View past bills" class="button" id="viewBillsButton" name="viewBillsButton"> <br><br>
<h1>Add/View Items</h1>
<input name="errMsg" id="error" value="<c:out value='${errorMsgs.errorMsg}'/>" type="text" style ="background-color: white; color: red; border: none; width:800px" disabled="disabled"><br>
	<form action="AddItemController?action=additem" method="post">
	<table align = "center">
		<tr>
		<td><label for="ItemName">Enter Item Name</label></td>
		<td><input type="text" id="itemnameinput" name="itemnameinput" placeholder="Eg: Eggs, Milk,.."></td>
		<td><input value="<c:out value='${ItemNameErrMsg}'/>" id = "ItemNameErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
		</tr>
		<tr>
    	<td><label for="ItemCost">Enter Cost of the item</label></td>
    	<td><input type="text" id="itemcostinput" name="itemcostinput" placeholder="Eg: 20"></td>
    	<td><input value="<c:out value='${ItemCostErrMsg}'/>" id = "ItemCostErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
    	</tr>
    	<tr>
    	<td><label for="Comments">Comments/Keywords</label></td>
    	<td><input type="text" id="itemcominput" name="itemcominput" placeholder="Brand name/Extra details"></td>
    	<td><input value="<c:out value='${ItemCommErrMsg}'/>" id = "ItemCommErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
    	</tr>
    </table>
    	<input type="submit" value="Add" class="button" id="submitadditem" name="submitadditem">
	</form><br>
	<input value="<c:out value='${errMsgs}'/>" id = "ItemErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"><br>
		<c:if test="${empty listItems}">
		<input id="alert" name="AlertMsg" value="<c:out value='Press List button to list items added.'/>" type="text" style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		</c:if>
		<c:if test="${!empty listItems}">
        <table border="1" cellpadding="5">
            <caption><h2>List of Items</h2></caption>
            <tr>
                <th>ID</th>
                <th>Item Name</th>
                <th>Item Cost</th>
                <th>Comments</th>
            </tr>
            <c:forEach var="item" items="${listItems}">
                <tr>
                    <td><c:out value="${item.getItemID()}" /></td>
                    <td><c:out value="${item.getItemName()}" /></td>
                    <td><c:out value="${item.getItemCost()}" /></td>
                    <td><c:out value="${item.getItemComm()}" /></td>
                </tr>
            </c:forEach>
        	</c:if>
        </table>
        
</body>
</html>