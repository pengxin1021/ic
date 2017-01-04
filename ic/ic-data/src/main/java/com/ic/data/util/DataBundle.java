package com.ic.data.util;

import java.util.ResourceBundle;

public class DataBundle {

	private static ResourceBundle bundle = ResourceBundle.getBundle("url");
	
	public static String TBUrl = bundle.getString("tb.url");
	
	public static int TBPage = Integer.parseInt((String) bundle.getObject("tb.page"));
	
	public static String TBHost = bundle.getString("tb.host");
	
	public static String TBCookie = bundle.getString("tb.cookie");
}
