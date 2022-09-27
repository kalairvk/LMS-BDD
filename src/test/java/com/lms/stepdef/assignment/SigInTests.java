package com.lms.stepdef.assignment;
//package stepDefinitions;
//
//import org.junit.Assert;
//import org.junit.BeforeClass;
//
//import context.ScnContext;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import pageObjects.SignInPage;
//import utils.BrowserFactory;
//import utils.ReadConfig;
//
//
//public class SigInTests extends BrowserFactory{
//	ReadConfig config;
//	ScnContext cs;
//	
//	
//	public SigInTests(ScnContext cs) {
//		this.cs=cs;
//		config=new ReadConfig();
//		cs.signInPage=new SignInPage(cs.driver);
//	}
//	
//	@Before
//	public void setUp() {
//		cs.logger.info("Launched browser");
//		cs.driver=init();
//		config=new ReadConfig();
//		cs.signInPage=new SignInPage(cs.driver);
//	}
//	
////	@After
//	public void tearDown() {
//		cs.driver.quit();
//	}
//	
////	@AfterStep
////	public void afterStep(Scenario scenario) {
////		scenario.attach(GenericFunctions.getByteScreenshot(), "image/png", "Screenshots");
////	}
//	
//	
//	@Given("user is on the sigin page on LMS site")
//	public void user_is_on_the_sigin_page_on_lms_site() {	
//		cs.driver.get(config.getAppUrl());
//		cs.logger.info("Application launched");
//	}
//	
//	@When("user provides valid username as {string} and password as {string}")
//	public void user_provides_valid_username_as_and_password_as(String un, String pw) throws InterruptedException {
//		 cs.signInPage.enterUsername(config.getUsername());
//		 Thread.sleep(3000);
//		 cs.signInPage.enterPassword(config.getPassword());
//		 Thread.sleep(3000);
//	}
//	
//	@And("user clicks on login button")
//	public void user_clicks_on_login_button() throws InterruptedException {
//		cs.signInPage.clickLogin();
//		Thread.sleep(3000);
//	}
//
//	
//	@Then("user should see the message {string} and land on homepage")
//	public void user_should_see_the_message_you_are_logged_in_successfully_and_land_on_homepage(String string) {
//		
//	}
//}
