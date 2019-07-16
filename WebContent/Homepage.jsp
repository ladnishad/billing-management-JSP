<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<script type="text/javascript">
	function revealUsers(){
		
		//document.getElementById("userselect").style.display = "inline";
		var text = document.getElementById('PersitemUsers');
		var itemTypePersonal = document.getElementById('itemTypePersonal');
		var personalForm = document.getElementById('personalForm');
		var num = parseInt(text.value);
		//alert(num);

		for (var i = 0; i < num; i++) {
			var userLabel = document.createElement("label");
			userLabel.id = "userLabel"+i;
			userLabel.innerHTML = "Select User: ";
			personalForm.appendChild(userLabel);
			
			var selectList = document.createElement("select");
			selectList.setAttribute("id", "mySelect"+i);
			selectList.setAttribute("name", "mySelect"+i);
				
			personalForm.appendChild(selectList);
				
			var qtyLabel = document.createElement("label");
			qtyLabel.id = "qtyLabel"+i;
			qtyLabel.innerHTML = "Enter Quantity: ";
			personalForm.appendChild(qtyLabel);
			var qtyText = document.createElement("input");
			qtyText.Type = "text";
			qtyText.id = "qtyText"+i;
			qtyText.name = "qtyText"+i;
			qtyText.placeholder = "Ex: 1,2,3,...";
			personalForm.appendChild(qtyText);
			linebreak = document.createElement("br");
			personalForm.appendChild(linebreak);
			linebreak = document.createElement("br");
			personalForm.appendChild(linebreak);
			
			var optionArray = ["Harshit","Harish","Deep","Nishad"];
			for (var j = 0; j < optionArray.length; j++) {
				var option = document.createElement("option");
				option.setAttribute("value",optionArray[j]);
				option.text = optionArray[j];
				selectList.appendChild(option);
			}
				
		}
	}
</script>
</head>
<body>
<div align="center">
	<form action="AddItemController?action=list" method="post">
		
	<input type="submit" value="View/Add Items" class="button" id="listitempage" name="listitempage">
	<input type="button" onclick="location.href='ViewBills.jsp'" value="View Past Bills" class="button" id="viewbills" name="viewbills">	
	
	</form>
	
</div>
<br>

<div align="center">
	<div style="float: left; width: 50%;">
	<form action="AddBillController?action=populate" method="post">
		<input type="submit" value="Click for common item" class="button" id="common" name="common">
	</form>
	<br>

	<div id="itemTypeCommon">
		<form action="AddBillController?action=addCommon" method="post">
		<label>Select Item: </label>
		<input name = "CommitemlistText" id="CommitemlistText" list="Commitemlist">
		<datalist id="Commitemlist" name="CommitemList">
		<c:forEach items="${listAllItemNames}" var="names">
        	<option value="${names.getItemName()}">${names.getItemName()}</option>
    	</c:forEach>
    	</datalist><br><br>
    	<label>Enter Qty: </label>
		<input type="text" name = "CommitemQty" id="CommitemQty" style="width: 130px;"><br><br>
		<input type="submit" value="Add to Bill" id="commonAdd" name="commonAdd" >
		</form>
	</div>
	</div>

	<div style="float: left; width: 50%;">
		<form action="AddBillController?action=populate" method="post">
		<input type="submit" value="Click for personal item" class="button" id="common" name="common">
		</form>
		<br>

		<div id="itemTypePersonal">
		<form action="AddBillController?action=addPersonal" method="post" id="personalForm">
		<label>Select Item: </label>
		<input name = "itemlistText" id="itemlistText" list="itemlist">
		<datalist id="itemlist" name="itemList">
		<c:forEach items="${listAllItemNames}" var="names">
        	<option value="${names.getItemName()}">${names.getItemName()}</option>
    	</c:forEach>
    	</datalist><br><br>
    	<label>Enter total qty: </label>
    	<input type="text" name="PersitemQty" id="PersitemQty"><br><br>
    	<label>Enter no of users: </label>
    	<input type="text" name="PersitemUsers" id="PersitemUsers"><br><br>
    	<input type="button" name="addusersbutton" id="addusersbutton" onclick="revealUsers()" value="Add Users">
    	<input type="submit" value="Add to Bill" id="personalAdd" name="personalAdd"><br><br>
    	
    	</form>
		</div>
	</div>
</div>

<br>
<br>
<br>
<br>
<div align = "center">
	  <c:if test="${!empty listCurrItems}">
        <table border="1" style="table-layout:fixed;width:1000px;">
            <caption><h2>Current Bill</h2></caption>
            <tr>
                <th>BillID</th>
                <th colspan="2">Item</th>
                <th>Harshit</th>
                <th>Harish</th>
                <th>Deep</th>
                <th>Nishad</th>
                <th>Qty</th>
                <th>Total Cost</th>
            </tr>
            <c:forEach var="bill" items="${listCurrItems}">
                <tr>
                    <td><c:out value="${bill.getBillsID()}" /></td>
                    <td colspan="2"><c:out value="${bill.getBillItem()}" /></td>
                    <td><c:out value="${bill.getHarshitCost()}" /></td>
                    <td><c:out value="${bill.getHarishCost()}" /></td>
                    <td><c:out value="${bill.getDeepCost()}" /></td>
                    <td><c:out value="${bill.getNishadCost()}" /></td>
                    <td><c:out value="${bill.getTotalQty()}" /></td>
                    <td><c:out value="${bill.getTotalCost()}" /></td>
                </tr>
            </c:forEach>
            
	        	
        </table>
       </c:if> 
        
        <c:if test="${!empty listCurrTotal}">
        <table border="1" style="table-layout:fixed;width:1000px;">
            <c:forEach var="billTotal" items="${listCurrTotal}">
                <tr>
                    <td colspan="3"><strong>Total</strong></td>
                    <td><strong><c:out value="${billTotal.getHarshitCostTotal()}" /></strong></td>
                    <td><strong><c:out value="${billTotal.getHarishCostTotal()}" /></strong></td>
                    <td><strong><c:out value="${billTotal.getDeepCostTotal()}" /></strong></td>
                    <td><strong><c:out value="${billTotal.getNishadCostTotal()}" /></strong></td>
                    <td colspan="2"><strong><c:out value="${billTotal.getTotal()}" /></strong></td>
                </tr>
            </c:forEach>
            
             	
        </table>
        </c:if>  
</div>
</body>
</html>