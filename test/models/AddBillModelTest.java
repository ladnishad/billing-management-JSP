package models;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class AddBillModelTest {

	@FileParameters("./JunitTestFolder/AddBillModelCommonItemTestCases.csv")
	@Test
	public void validateCommonItemTest(String ItemName,String ItemQty,String ItemNameErrMsg, String ItemQtyErrMsg,String ErrMsg) {
		AddBillErrMsgs errMsgs = new AddBillErrMsgs();
		AddBillModel addBillTest = new AddBillModel(ItemName,ItemQty);
		
		addBillTest.validateCommonItem(addBillTest, errMsgs, "");
		
		assertEquals(ItemNameErrMsg,errMsgs.getCommItemNameErrMsg());
		assertEquals(ItemQtyErrMsg,errMsgs.getCommItemQtyErrMsg());
		assertEquals(ErrMsg,errMsgs.getErrorMsg());
	}

}
