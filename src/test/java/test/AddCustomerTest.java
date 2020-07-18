package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	
WebDriver driver;
	
	
	/*String userName = null;
	String password = null;
	String fullName = null;
	String company = null;
	String email = null;
	String phoneNum = null;
	String address = null;
	String city = null;
	String state = null;
	String zip = null;
	String group = null;*/
	
	@Test (priority = 1)
	@Parameters({"username", "password", "fullName", "company", "email", "phoneNum", "address", "city", "state", "zip", "group"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String company, String email, String phoneNum, String address, String city, String state, String zip, String group) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSignInButton();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.verifyDashBoardElement();
		
		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.clickCustomersButton();
		addCustomer.clickAddCustomerButton();
		addCustomer.insertFullName(fullName);
		addCustomer.insertCompanyName(company);
		addCustomer.insertEmail(email);
		addCustomer.insertPhoneNumber(phoneNum);
		addCustomer.insertAddress(address);
		addCustomer.insertCity(city);
		addCustomer.insertState(state);
		addCustomer.insertZip(zip);
		addCustomer.insertGroup(group);
		addCustomer.clickOnSaveButton();
		addCustomer.clickOnListCustomersButton();
		addCustomer.verifyEnteredCustomerAndDelete();
		
		
		BrowserFactory.tearDown();
		
	}
	
	@Test (priority = 2)
	@Parameters({"username", "password", "fullName", "company", "email", "phoneNum", "address", "city", "state", "zip", "group"})
	public void validUserShouldBeAbleToUseSearchBarOnListCustomer(String userName, String password, String fullName, String company, String email, String phoneNum, String address, String city, String state, String zip, String group) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSignInButton();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.verifyDashBoardElement();
		
		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.clickCustomersButton();
		addCustomer.clickOnListCustomersButton();
		addCustomer.clickAddCustomerOnListCustomer();
		
		addCustomer.insertFullName(fullName);
		addCustomer.insertCompanyName(company);
		addCustomer.insertEmail(email);
		addCustomer.insertPhoneNumber(phoneNum);
		addCustomer.insertAddress(address);
		addCustomer.insertCity(city);
		addCustomer.insertState(state);
		addCustomer.insertZip(zip);
		addCustomer.insertGroup(group);
		addCustomer.clickOnSaveButton();
		addCustomer.clickOnListCustomersButton();
		addCustomer.testListContactSearchBar();
		addCustomer.verifyEnteredCustomerOnSearchBarAndTestView();
		
		
		
		BrowserFactory.tearDown();
		
	}

}
