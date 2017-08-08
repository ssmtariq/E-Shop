package com.ecommerce.util;

public final class ApplicationConstants {
	
	//Admin Constants
	public static final int ADMIN_TYPE_SUPER =1;
	public static final int ADMIN_TYPE_ADMIN =0;

	//Payment Constants
	public static final int PAYMENT_COMPLETE =1;
	public static final int PAYMENT_NOT_COMPLETE =0;
	public static final String PAYMENT_METHOD_IPN = "Paypal-IPN";
	
	//User TYPE Constants
	public static final int USER_TYPE_ADMIN =0;
	public static final int USER_TYPE_SUPER_ADMIN =1;
	public static final int USER_TYPE_GENERAL =2;
	
	//User Constants
	public static final int USER_ACTIVE =1;
	public static final int USER_INACTIVE =0;
	public static final int USER_BLOCKED =2;

	//Order Constants
	public static final int ORDER_PENDING =0;
	public static final int ORDER_DELIVERABLE =1;
	public static final int ORDER_DELIVERED =2;
	
	//Session Constants
	public static final String SESSION_CURRENT_ADMIN = "currentAdmin";
	public static final String SESSION_CURRENT_USER = "currentUser";
	public static final String SESSION_USER_TYPE = "userType" ;
	public static final String SESSION_SIGN_IN_STATUS= "signInStatus";
	public static final String SESSION_CURRENT_ORDER= "currentOrder";
	public static final String SESSION_CURRENT_ORDER_AMOUNT= "currentOrderAmount";
	public static final String SHOPPING_CART_ITEMS= "myCartItems";
	
	//User Registration Email
//	public static final String APPLICATION_PROTOCOL = "http://";
	public static final String APPLICATION_HOSTNAME = "localhost";
	public static final String APPLICATION_PORT = "8080";
	public static final String EMAIL_USERNAME = "eshop.bjit.bd@gmail.com";
	public static final String EMAIL_PASSWORD = "bjit10590";
	public static final String REGISTRATION_EMAIL_SUBJECT = "E-Shop Registration Confirmation";
	public static final String RECOVERY_EMAIL_SUBJECT = "E-Shop Account Recovery Information";
	public static final String REGISTRATION_EMAIL_BODY = "Registration";
	public static final String RECOVERY_EMAIL_BODY = "Recovery";
	
	//Category Constants
	public static final String CATEGORY_IMAGE_PATH = "/home/bjit-8/Documents/workspace/eCommerceBjitFinalProject/WebContent/upload/category";
	
	//Product Constants
	public static final String PRODUCT_IMAGE_PATH = "/home/bjit-8/Documents/workspace/eCommerceBjitFinalProject/WebContent/upload/product";
	public static final int PRODUCT_AVAILABLE = 1;
	public static final int PRODUCT_COMING_SOON = 2;
	public static final int PRODUCT_NOT_FOR_SALE = 3;
	public static final int PRODUCT_IS_FEATURED = 1;
	public static final int PRODUCT_IS_NOT_FEATURED = 0;
}
