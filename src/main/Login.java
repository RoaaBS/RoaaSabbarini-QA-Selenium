package main;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Actions;
import PageObject.Assertions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class Login extends Actions{
	Assertions assertion=new Assertions();
	String email= "roaa66@gmail.com";
	String password="12345";
	@BeforeSuite
	public void setup() {
		maximizeBrowser();
		
	}
	@Test(description="validate that user can login to website")
	public void LoginFunctionality() {
		visitAutomationexercise();
		clickLoginFromHome();
		TypeEmailInEmailFeild(email);
		TypePasswordInPasswordFeild(password);
		clickonLoginButton();
		ClickonProduct();
		UpdateQuantity();
		ClickAddtoCart();
		ViewCart();
		ProceedToCheckout();
		PlaceOrder();
		PaymentForm();
		ClickOnConfirmOrder();
		assertion.CheckMessageBarIsContain();
		
	}
	@AfterSuite
	public void AfterTest() {
		CloseDriver();
	}

}
