package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(JUnitParamsRunner.class)
public class ViewPastBillsSeleniumTest extends SeleniumTestBase{

	@BeforeClass
	public static void setUp() throws Exception {
		setDriver();
		startup();
	}

	@Test
	@FileParameters("./SeleniumTestData/ViewPastBillsErrorTests.csv")
	public void ViewPastBillsErrorTest(String BillID, String IDError,String ErrMsg) {
			String error = ViewPastBillsFunction(BillID);
		  
			assertEquals(IDError,error);
	}
	
	@Test
	@FileParameters("./SeleniumTestData/ViewPastBillsSuccessTest.csv")
	public void ViewPastBillsSuccessTest(String BillID, String IDError) {
			String error = ViewPastBillsFunction(BillID);
		  
			assertEquals(IDError,error);
	}
	
	
	public String ViewPastBillsFunction(String billID){
		
	  	driver.findElement(By.id("BillIDinput")).clear();
	    driver.findElement(By.id("BillIDinput")).sendKeys(billID);
	    driver.findElement(By.id("searchBill")).click();
	    String error = driver.findElement(By.id("SearchBillErrMsg")).getAttribute("value").toString();
	    return error;
	}
	
	@AfterClass
	  public static void tearDownAfterTest() throws Exception {
		  end();
		  driver.close();
	  }
	
	
	public static void startup(){
		  driver.findElement(By.id("viewbills")).click();
	  }
	  
	  public static void end(){
		  driver.findElement(By.id("HomeButton")).click();
	  }

}
