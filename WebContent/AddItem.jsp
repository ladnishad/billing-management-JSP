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
<a href="Homepage.jsp">Back</a>
<a href="ViewBills.jsp">View Past Bills</a>
<div align="center">
<h1>Add/View Items</h1>

	<form action="AddItemController?action=additem" method="post">
		<label for="ItemName">Enter Item Name</label>
		<input type="text" id="itemnameinput" name="itemnameinput" placeholder="Eg: Eggs, Milk,.." required><br><br>

    	<label for="ItemCost">Enter Cost of the item</label>
    	<input type="text" id="itemcostinput" name="itemcostinput" placeholder="Eg: 20" required><br><br>

    	<label for="Comments">Comments/Keywords</label>
    	<input type="text" id="itemcominput" name="itemcominput" placeholder="Brand name/Extra details"><br><br>
    	<input type="submit" value="Add" class="button" id="submitadditem" name="submitadditem">
	</form><br>
	<form action="AddItemController?action=list" method="post">
		
		<input type="submit" value="List" class="button" id="listitem" name="listitem">
		
	</form>
		<c:if test="${empty listItems}">
		<input id="alert" name="AlertMsg" value="<c:out value='Sorry! No items found.'/>" type="text" style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
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
        
    </div>
</body>
</html>