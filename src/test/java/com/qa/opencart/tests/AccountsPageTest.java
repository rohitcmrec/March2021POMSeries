package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String title = accPage.getAccPageTitle();
		System.out.println("Acc Page title is: " + title);
		Assert.assertEquals(title, Constants.ACC_PAGE_TITLE);
	}

	@Test
	public void accPageHeaderTest() {
		String header = accPage.getAccPageHeader();
		System.out.println("Acc Page header is: " + header);
		Assert.assertEquals(header, Constants.ACC_PAGE_HEADER);
	}

	@Test
	public void accPageSectionsListTest() {
		List<String> secList = accPage.getAccSectionsList();
		softAssert.assertEquals(secList.size(), Constants.ACC_PAGE_SECTIONS_COUNT);
		Assert.assertEquals(secList, Constants.EXPECTED_ACC_SECS_LIST);
		softAssert.assertAll();
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { 
			{ "iMac" }, 
			{ "MacBook" }, 
			{ "Apple" } };
	}

	@Test(dataProvider = "productData")
	public void searchTest(String productName) {
		searchResultsPage = accPage.doSearch(productName);
		Assert.assertTrue(searchResultsPage.getSearchProductListCount()>0);
	}
	
	
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] { 
			{ "MacBook" , "MacBook Pro"},
			{"Apple", "Apple Cinema 30\""}};
	}
		
	@Test(dataProvider = "productSelectData")
	public void selectProductTest(String productName, String mainProductName) {
		searchResultsPage = accPage.doSearch(productName);
		searchResultsPage.selectProduct(mainProductName);
	}
	
	
}
