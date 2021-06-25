package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	private By searchHeaderName = By.cssSelector("div#content h1");
	private By productResults = By.cssSelector("div.caption a");
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getSearchHeaderName() {
		return elementUtil.doGetText(searchHeaderName);
	}
	
	
	public int getSearchProductListCount() {
		return 	
				elementUtil
				.waitForVisibilityOfElements(productResults, Constants.DEFAULT_TIME_OUT).size();

	}
	
	public ProductInfoPage selectProduct(String mainProductName) {
		List<WebElement> searchList = 
					elementUtil.waitForVisibilityOfElements(productResults, Constants.DEFAULT_TIME_OUT);
		for(WebElement e : searchList) {
			String text = e.getText();
				if(text.equals(mainProductName)) {
					e.click();
					break;
				}
		}
		
		return new ProductInfoPage(driver);
	}
	
	
}
