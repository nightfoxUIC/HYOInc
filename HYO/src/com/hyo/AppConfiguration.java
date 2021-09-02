package com.hyo;


import java.util.Properties;

import com.operations.SearchProductOperations;

public class AppConfiguration {
	public static String productName = "HYOInc";
	public static String pricingTier = "1";
	public static String dbUrl="jdbc:mysql://localhost:3306/hyoinc";
	public static String dbUser="root";
	public static String dbPassword="root";
	public static Integer minStockQty = 20;
	public static String resourceLocation = "C:/Users/Agastya Narumanchi/Desktop/courses/IDS-517/TransformInc/HYOInc/resources";
	
	public AppConfiguration(Properties prop) {
		SearchProductOperations sp = new SearchProductOperations();
		productName = (String) prop.get("productName");
		pricingTier = (String) prop.get("pricingTier ");
		minStockQty = Integer.parseInt((String)prop.get("minStockQty"));
		dbUrl= (String) prop.get("db.url");
		dbUser= (String) prop.get("db.user");
		dbPassword= (String) prop.get("db.password");
		resourceLocation = (String) prop.get("resourceLocation");

	}

}
