package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void productInfoHeaderTest() {
		searchResultsPage = accPage.doSearch("Macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductHeaderText(), "MacBook Pro");
	}

	@Test
	public void productImagesTest() {
		searchResultsPage = accPage.doSearch("iMac");
		productInfoPage = searchResultsPage.selectProduct("iMac");
		Assert.assertEquals(productInfoPage.getProductImagesCount(), Constants.IMAC_IMAGE_COUNT);
	}

	@Test
	public void productInfoTest() {
		searchResultsPage = accPage.doSearch("Macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();

		actProductInfoMap.forEach((k, v) -> System.out.println(k + " : " + v));

		softAssert.assertEquals(actProductInfoMap.get("name"), "MacBook Pro");
		softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		softAssert.assertTrue(actProductInfoMap.get("price").contains("2,000"));

		softAssert.assertAll();
	}

}
