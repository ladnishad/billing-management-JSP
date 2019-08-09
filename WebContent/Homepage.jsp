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
		
		var text = document.getElementById('PersitemUsers');
		var itemTypePersonal = document.getElementById('itemTypePersonal');
		var personalForm = document.getElementById('personalForm');
		var num = parseInt(text.value);
		var textInput = num.toString().toUpperCase();
		
		if(num == 0){
			document.getElementById('PNumUsersErrMsg').value = 'Input cannot be 0.';
		}
		
		else if(num > 4){
			document.getElementById('PNumUsersErrMsg').value = 'Input cannot be greater than 4.';
		}
		
		else if(textInput == 'NAN'){
			document.getElementById('PNumUsersErrMsg').value = 'Enter a valid input.';
		}
		
		else{
			document.getElementById('PNumUsersErrMsg').value = '';
			var elementid = document.getElementById("userLabel"+0);
			
			if(elementid == null)
			{
				for (var i = 0; i < num && i < 4; i++)
				{
					
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
						
					var linebreak = document.createElement("br");
					linebreak.id = "br"
					personalForm.appendChild(linebreak);
						
					//linebreak = document.createElement("br");
					//personalForm.appendChild(linebreak);
						
					var optionArray = ["Harshit","Harish","Deep","Nishad"];
					for (var j = 0; j < optionArray.length; j++) 
					{
						var option = document.createElement("option");
						option.setAttribute("value",optionArray[j]);
						option.text = optionArray[j];
						selectList.appendChild(option);
					}
							
				}
			}
				
			else
			{
				for(var j=0;j<100;j++)
				{
					var UserLabelelement = document.getElementById("userLabel"+j);
					personalForm.removeChild(UserLabelelement);
						
					var Selectelement = document.getElementById("mySelect"+j);
					personalForm.removeChild(Selectelement);
						
					var QtyLabelelement = document.getElementById("qtyLabel"+j);
					personalForm.removeChild(QtyLabelelement);
						
					var QtyTextelement = document.getElementById("qtyText"+j);
					personalForm.removeChild(QtyTextelement);
					
					var breakElement = document.getElementById("br");
					personalForm.removeChild(breakElement);
				}
					
					
				for (var i = 0; i < num && i < 4; i++) 
				{
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
						
					var linebreak = document.createElement("br");
					linebreak.id = "br"
					personalForm.appendChild(linebreak);
						
					var optionArray = ["Harshit","Harish","Deep","Nishad"];
					for (var j = 0; j < optionArray.length; j++) 
					{
						var option = document.createElement("option");
						option.setAttribute("value",optionArray[j]);
						option.text = optionArray[j];
						selectList.appendChild(option);
					}
							
				}
					
			}
			var submit = document.createElement('input');
			submit.setAttribute('type','submit');
			submit.setAttribute('ID','personalAdd');
			submit.setAttribute('value','Add to bill');
			submit.setAttribute('form','personalForm');
			personalForm.appendChild(submit);
			linebreak = document.createElement("br");
			personalForm.appendChild(linebreak);
			linebreak = document.createElement("br");
			personalForm.appendChild(linebreak);
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
		<table>
		<tr>
		<td><label>Select Item: </label></td>
		
		<td><input name = "CommitemlistText" id="CommitemlistText" list="Commitemlist">
		<datalist id="Commitemlist" name="CommitemList">
		<c:forEach items="${listAllItemNames}" var="names">
        	<option value="${names.getItemName()}">${names.getItemName()}</option>
    	</c:forEach>
    	</datalist></td>
    	<td><input value="<c:out value='${CItemErrMsg}'/>" id = "CItemErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 200px" disabled="disabled" maxlength="60"></td>
    	</tr>
    	<tr>
    	<td><label>Enter Qty: </label></td>
		<td><input type="text" name = "CommitemQty" id="CommitemQty" style="width: 130px;"></td>
		<td><input value="<c:out value='${CQtyErrMsg}'/>" id = "CQtyErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 200px" disabled="disabled" maxlength="60"></td>
		</tr>
		</table>
		<table>
		<tr>
		<td><input value="<c:out value='${CerrMsgs}'/>" id = "CerrMsgs" type="text" style ="background-color: white; color: red; border: none; width: 200px" disabled="disabled" maxlength="60"></td>
		</tr>
		</table>
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
		<table>
		<tr>
		<td><label>Select Item: </label></td>
		<td><input name = "itemlistText" id="itemlistText" list="itemlist">
		<datalist id="itemlist" name="itemList">
		<c:forEach items="${listAllItemNames}" var="names">
        	<option value="${names.getItemName()}">${names.getItemName()}</option>
    	</c:forEach>
    	</datalist></td>
    	<td><input value="<c:out value='${PItemErrMsg}'/>" id = "PItemErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 200px" disabled="disabled" maxlength="60"></td>
		</tr>
		<tr>
		<td><label>Enter total qty: </label></td>
		<td><input type="text" name="PersitemQty" id="PersitemQty"></td>
		<td><input value="<c:out value='${PQtyErrMsg}'/>" id = "PQtyErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 200px" disabled="disabled" maxlength="60"></td>
		</tr>
		<tr>
		<td><label>Enter no of users: </label></td>
		<td><input type="text" name="PersitemUsers" id="PersitemUsers"></td>
		<td><input value="<c:out value='${PNumUsersErrMsg}'/>" id = "PNumUsersErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 200px" disabled="disabled" maxlength="60"></td>
		</tr>
		</table>
		<table>
		<tr>
		<td><input value="<c:out value='${PSpecialUsrErrMsg}'/>" id = "PSpecialUsrErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 1000px" disabled="disabled" maxlength="60"></td>
		</tr>
		<tr>
		<td><input value="<c:out value='${PSpecialQtyErrMsg}'/>" id = "PSpecialQtyErrMsg" type="text" style ="background-color: white; color: red; border: none; width: 1000px" disabled="disabled" maxlength="60"></td>
		</tr>
		</table>
		<input type="button" name="addusersbutton" id="addusersbutton" onclick="revealUsers()" value="Add Users"><br><br>
    	
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
            
             	
        </table><br>
        </c:if>
        <form action="AddBillController?action=deleteBill" method="post" id="deleteForm">
        	<input type="submit" value="Delete Bill" id="delete" name="delete">
        </form>
        
        <form action="AddBillController?action=submitBill" method="post" id="submitBillForm">
        	<input type="submit" value="Submit Bill" id="submitbill" name="submitbill">
        </form>  
</div>
</body>
</html>