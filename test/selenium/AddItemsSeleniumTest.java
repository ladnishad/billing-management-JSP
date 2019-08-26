package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import static org.junit.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import selenium.functions.AddItemsFunctions;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class AddItemsSeleniumTest extends SeleniumTestBase{
	  
	@BeforeClass
	  public static void setUp() throws Exception {
		  setDriver();
		  startup();
	  }

	  @Test
	  @FileParameters("./SeleniumTestData/AddItemFailTestCases.csv")
	  public void AddItemsErrorTests(String ItemName, String ItemCost, String Comment, String ItemNameErr, String ItemCostErr,String CommErr,String ErrMsg) throws Exception {
		  String error[] = new String[4];
		  
		  error = AddItemsFunction(ItemName,ItemCost,Comment);
		  
		  assertEquals(ItemNameErr,error[0]);
		  assertEquals(ItemCostErr,error[1]);
		  assertEquals(CommErr,error[2]);
		  assertEquals(ErrMsg,error[3]);
	  }
	  
	  @Test
	  @FileParameters("./SeleniumTestData/AddItemSuccessTestCases.csv")
	  public void AddItemsSuccessTests(String ItemName, String ItemCost, String Comment, String ItemNameErr, String ItemCostErr,String CommErr,String ErrMsg) throws Exception {
		  String error[] = new String[4];
		  
		  error = AddItemsFunction(ItemName,ItemCost,Comment);
		  
		  assertEquals(ItemNameErr,error[0]);
		  assertEquals(ItemCostErr,error[1]);
		  assertEquals(CommErr,error[2]);
		  assertEquals(ErrMsg,error[3]);
	  }
	  
	  public String[] AddItemsFunction(String ItemName,String ItemCost,String Comment){
			String error[] = new String[4];
		  	driver.findElement(By.id("itemnameinput")).clear();
		    driver.findElement(By.id("itemnameinput")).sendKeys(ItemName);
		    driver.findElement(By.id("itemcostinput")).clear();
		    driver.findElement(By.id("itemcostinput")).sendKeys(ItemCost);
		    driver.findElement(By.id("itemcominput")).clear();
		    driver.findElement(By.id("itemcominput")).sendKeys(Comment);
		    driver.findElement(By.id("submitadditem")).click();
		    error[0] = driver.findElement(By.id("ItemNameErrMsg")).getAttribute("value").toString();
		    error[1] = driver.findElement(By.id("ItemCostErrMsg")).getAttribute("value").toString();
		    error[2] = driver.findElement(By.id("ItemCommErrMsg")).getAttribute("value").toString();
		    error[3] = driver.findElement(By.id("ItemErrMsg")).getAttribute("value").toString();
		    return error;
		}

	  @AfterClass
	  public static void tearDownAfterTest() throws Exception {
		  end();
		  driver.close();
	  }
	  
	  public static void startup(){
		  driver.findElement(By.id("listitempage")).click();
	  }
	  
	  public static void end(){
		  driver.findElement(By.id("HomeButton")).click();
	  }
	  

}
