package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. By Locators: private
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//div[@class='row']//a");
	private By registerLink = By.linkText("Register");
	private By loginError = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	// 2. constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 3. page actions:
	@Step("getting login page title....")
	public String getLoginPageTitle() {
		return elementUtil.getPageTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	@Step("checking forgot pwd link exist or not....")
	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}

	@Step("login to app with correct username : {0} and password: {1}")
	public AccountsPage doLogin(String un, String pwd) {
		elementUtil.doPresenceOfElementLocated(emailId, Constants.DEFAULT_TIME_OUT).sendKeys(un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	}

	/**
	 * app login method with negative data
	 * 
	 * @param un
	 * @param pwd
	 * @return
	 */
	@Step("login to app with incorrect username : {0} and password: {1}")
	public boolean appLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);

		String error = elementUtil.doGetText(loginError);
		if (error.contains("No match for E-Mail Address and/or Password")) {
			return true;
		}
		return false;
	}

	@Step("getting footer links for the login page.....")
	public List<String> getFooterLinks() {
		List<WebElement> footerList = elementUtil.getElements(footerLinks);
		List<String> footerTextList = new ArrayList<String>();

		for (WebElement e : footerList) {
			footerTextList.add(e.getText());
		}
		return footerTextList;

	}

	/**
	 * navigate to register page:
	 */
	@Step("navigating to registration page.....")
	public RegistrationPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}

}
