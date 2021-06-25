package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void setUpRegistration() {
		registrationPage = loginPage.navigateToRegisterPage();
	}
	
	
	public String getRandomNumber() {
		Random randomGenerator = new Random();
		String email = "testautomation"+randomGenerator.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, 
								 String phone, String password, String subscribe) {
		
	Assert.assertTrue
					(registrationPage.
								accountRegistration(firstName, lastName, 
										getRandomNumber(), phone,
														password, subscribe));
	}
	

}
