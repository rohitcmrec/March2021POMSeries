package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic - 100: design a login page for demo cart application")
@Story("US - 101: login page features with title, forgot pwd link and login feature")
public class LoginPageTest extends BaseTest {

	@Description("login page title test...")
	@Severity(SeverityLevel.MINOR)
	@Test()
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Description("forgot pwd link test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Description("login test with correct data...")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Description("login test footer links test....")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageFooterLinksTest() {
		List<String> footerList = loginPage.getFooterLinks();
		softAssert.assertEquals(footerList.size(), 15);
		softAssert.assertTrue(footerList.contains("About Us"));
		softAssert.assertAll();
	}

}
