package models;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)

public class AddItemModelTest {
	
	@FileParameters("./JunitTestFolder/AddItemModelTestCases.csv")
	@Test
	public void AddItemTest(String ItemName,String ItemCost,String Comment, String ItemNameErrMsg,String ItemCostErrMsg,String CommentErrMsg,String errMsg) {
		AddItemErrMsgs errMsgs = new AddItemErrMsgs();
		AddItemModel addItemTest = new AddItemModel(ItemName,ItemCost,Comment);
		
		addItemTest.validateItem(addItemTest, errMsgs, "");
		
		assertEquals(ItemNameErrMsg,errMsgs.getItemNameErrMsg());
		assertEquals(ItemCostErrMsg,errMsgs.getItemCostErrMsg());
		assertEquals(CommentErrMsg,errMsgs.getItemCommErrMsg());
		assertEquals(errMsg,errMsgs.getErrorMsg());
	}

}
