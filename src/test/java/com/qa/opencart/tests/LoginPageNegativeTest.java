package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class LoginPageNegativeTest extends BaseTest {

	@DataProvider
	public Object[][] loginNegativeData() {
		Object loginData[][] = ExcelUtil.getTestData(Constants.LOGIN_SHEET_NAME);
		return loginData;
	}

	@Test(dataProvider = "loginNegativeData")
	public void loginTest_negative(String username, String password) {
		Assert.assertTrue(loginPage.appLogin(username, password));
	}

}
