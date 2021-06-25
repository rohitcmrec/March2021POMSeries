package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");

	private By quantity = By.id("input-quantity");
	private By addtoCartBtn = By.id("button-cart");
	private By successMesg = By.cssSelector("div.alert.alert-success.alert-dismissible");

	Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getProductHeaderText() {
		System.out.println("getting product header value....");
		return elementUtil.doGetText(productHeader);
	}

	public int getProductImagesCount() {
		return elementUtil.waitForVisibilityOfElements(productImages, Constants.DEFAULT_TIME_OUT).size();
	}

	public Map<String, String> getProductInfo() {
		productInfoMap = new LinkedHashMap<String, String>();
		// productInfoMap = new HashMap<String, String>();
		// productInfoMap = new TreeMap<String, String>();

		productInfoMap.put("name", getProductHeaderText());
		getProductMetaData();
		getProductPriceData();
		return productInfoMap;
	}

	private void getProductMetaData() {
		List<WebElement> metaDataList = elementUtil.getElements(productMetaData);
		System.out.println("total product meta data: " + metaDataList.size());
		// meta data:
		for (WebElement e : metaDataList) {
			// Brand: Apple
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
	}

	/**
	 * getProductPriceData
	 */
	private void getProductPriceData() {
		// price:
		List<WebElement> priceList = elementUtil.getElements(productPriceData);
		System.out.println("total price meta data: " + priceList.size());

		String price = priceList.get(0).getText().trim();
		String exPrice = priceList.get(1).getText().trim();

		productInfoMap.put("price", price);
		productInfoMap.put("ExTaxPrice", exPrice);
	}

}
