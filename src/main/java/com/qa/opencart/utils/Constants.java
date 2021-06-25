package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	public static final int DEFAULT_TIME_OUT = 5;

	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACC_PAGE_TITLE = "My Account";
	public static final String ACC_PAGE_HEADER = "Your Store";

	public static final int ACC_PAGE_SECTIONS_COUNT = 4;
	
	public static final int IMAC_IMAGE_COUNT = 3;
	public static final int MACBOOK_PRO_IMAGE_COUNT = 4;
	
	public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";

	/******************Sheet Names********************/
	public static final String REGISTER_SHEET_NAME = "register";
	public static final String LOGIN_SHEET_NAME = "login";

	
	
	public static final List<String> EXPECTED_ACC_SECS_LIST = 
						Arrays.asList("My Account", 
										"My Orders", 
										"My Affiliate Account", 
										"Newsletter");
	
	

}
