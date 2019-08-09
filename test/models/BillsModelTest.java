package models;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)

public class BillsModelTest {

	@FileParameters("./JunitTestFolder/BillModelTestCases.csv")
	@Test
	public void validatePastBillTest(String BillID, String IDError,String ErrMsg) {
		BillsErrMsgs errMsgs = new BillsErrMsgs();
		BillsModel billTest = new BillsModel(BillID);
		
		billTest.validatePastBill(billTest, errMsgs, "");
		
		assertEquals(IDError,errMsgs.getPastBillErrMsg());
		assertEquals(ErrMsg,errMsgs.getErrorMsg());
		
	}

}
