package com.hyo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.operations.DAOOperations;
import com.pojo.ItemType;
import com.pojo.Items;
import com.pojo.Location;
import com.pojo.Manufacturer;
import com.pojo.Supplier;


/**
 *
 * @author Agastya Narumanchi
 */
public class HYOInc{
	
		public static void setAppConfigDetails() {
			try {	
				//Loading the properties file
	    	    InputStream input = new FileInputStream(AppConfiguration.resourceLocation+"/config.properties");
	   			Properties prop = new Properties();
	   			prop.load(input);
			} catch (Exception ex) {
	            java.util.logging.Logger.getLogger(HYOInc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		}
		
		public static HashMap<String,Object> getAllDetailsMap() {
			//list of items used across the system
			ArrayList<Items> items = new ArrayList<Items>();
			//list of items used with low stock
			ArrayList<Items> stockAlertItems = new ArrayList<Items>();
			//list of locations used across the system
			ArrayList<Location> locations = new ArrayList<Location>();
			//list of product types used across the system
			ArrayList<ItemType> itemTypes = new ArrayList<ItemType>();
			//list of manufacturers across the system
			ArrayList<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
			//list of suppliers across the system
			ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
			HashMap<String,Object> allDetails= new HashMap<String,Object>();
			try {
	   			//Geting all lists
	   			items = DAOOperations.getItemsList();
	   			suppliers = DAOOperations.getSuppliersList();
	   			manufacturers = DAOOperations.getManufacturersList();
	   			itemTypes = DAOOperations.getItemTypeList();
	   			locations = DAOOperations.getLocationList();
	   			
	   			for(Items i: items) {
	   				if(i.getStockQty()<=AppConfiguration.minStockQty)stockAlertItems.add(i);
	   			}
	   			allDetails.put("items", items);
	   			allDetails.put("stockAlertItems", stockAlertItems);
	   			allDetails.put("suppliers", suppliers);
	   			allDetails.put("manufacturers", manufacturers);
	   			allDetails.put("itemTypes", itemTypes);
	   			allDetails.put("locations", locations);
	 
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
			return allDetails;
		}
}
