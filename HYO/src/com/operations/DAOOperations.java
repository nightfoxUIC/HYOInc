package com.operations;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hyo.AppConfiguration;
import com.pojo.ItemType;
import com.pojo.Items;
import com.pojo.Location;
import com.pojo.Manufacturer;
import com.pojo.Supplier;

public class DAOOperations {
	
	public DAOOperations() {
		// TODO Auto-generated constructor stub
	}

	/**************************************** manufacturer DAO operations start*******************************************/
	public static ArrayList<Manufacturer> getManufacturersList() throws SQLException {
		String sql = "select * from manufacturer";
		ResultSet rs = dbConfiguration.excuteSelectStatement(sql);
		ArrayList<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
		
		while(rs.next()) {
			Manufacturer manufacturer = new Manufacturer();
			manufacturer.setCode(rs.getString(1));
			manufacturer.setName(rs.getString(2));
			manufacturers.add(manufacturer);
		}
		return manufacturers;
	}
	public static int UpdateManufacturerList(Manufacturer m) throws SQLException {
		String sql = "update manufacturer set manufacturer_name="+ m.getName() +" where manufacurer_code="+m.getCode();
		return dbConfiguration.excuteUpdateStatement(sql);
		
	}
	public static int addManufacturerList(Manufacturer m) throws SQLException {
		String sql = "insert manufacturer(manufacturer_name,manufacurer_code) values("+m.getCode()+","+m.getName()+")";
		return dbConfiguration.excuteAddStatement(sql);
		
	}
	/**************************************** manufacturer DAO operations end*******************************************/
	
	/**************************************** supplier DAO operations start*******************************************/
	public static ArrayList<Supplier> getSuppliersList() throws SQLException {
		String sql = "select * from supplier";
		ResultSet rs = dbConfiguration.excuteSelectStatement(sql);
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		while(rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setCode(rs.getString(1));
			supplier.setName(rs.getString(2));
			suppliers.add(supplier);
		}
		return suppliers;
	}
	
	public static int UpdateSupplierList(Supplier s) throws SQLException {
		String sql = "update supplier set supplier_name="+ s.getName() +" where supplier_code="+s.getCode();
		return dbConfiguration.excuteUpdateStatement(sql);
		
	}
	public static int addManufacturerList(Supplier s) throws SQLException {
		String sql = "insert supplier(supplier_name,supplier_code) values("+s.getCode()+","+s.getName()+")";
		return dbConfiguration.excuteAddStatement(sql);
		
	}
	/**************************************** supplier DAO operations end*******************************************/
	
	/**************************************** reports DAO operations start*******************************************/
	public static ArrayList<Items> getStockAlertList() throws SQLException {
		String sql = "select * from items where stock_qty<"+AppConfiguration.minStockQty;
		ResultSet rs = dbConfiguration.excuteSelectStatement(sql);
		ArrayList<Items> items = new ArrayList<Items>();
		while(rs.next()) {
			Items item = new Items();
			item.setProductID(rs.getString(1));
			item.setProduct(rs.getString(2));
			item.setModel(rs.getString(3));
			item.setManufacturerCode(rs.getString(4));
			item.setSupplierCode(rs.getString(5));
			item.setItemTypeCode(rs.getString(6));
			item.setLocationCode(rs.getString(7));
			item.setMSRP(rs.getFloat(8));
			item.setUnitCost(rs.getFloat(9));
			item.setDiscountRate(rs.getFloat(10));
			item.setStockQty(rs.getInt(11));
			item.setLastUpdated(rs.getDate(12));
			items.add(item);
		}
		return items;
	}
	/**************************************** reports DAO operations end*******************************************/
	
	/**************************************** location DAO operations start*******************************************/
	public static ArrayList<Location> getLocationList() throws SQLException {
		String sql = "select * from location";
		ResultSet rs = dbConfiguration.excuteSelectStatement(sql);
		ArrayList<Location> locations = new ArrayList<Location>();
		while(rs.next()) {
			Location location = new Location();
			location.setCode(rs.getString(1));
			location.setName(rs.getString(2));
			locations.add(location);
		}
		return locations;
	}
	public static int UpdateLocationList(Location l) throws SQLException {
		String sql = "update location set location_name="+ l.getName() +" where location_code="+l.getCode();
		return dbConfiguration.excuteUpdateStatement(sql);
		
	}
	public static int addLocationList(Location l) throws SQLException {
		String sql = "insert location(location_name,location_code) values("+l.getCode()+","+l.getName()+")";
		return dbConfiguration.excuteAddStatement(sql);
		
	}
	/**************************************** location DAO operations end*******************************************/
	
	/**************************************** item type DAO operations start*******************************************/
	public static ArrayList<ItemType> getItemTypeList() throws SQLException {
		String sql = "select * from ItemType";
		ResultSet rs = dbConfiguration.excuteSelectStatement(sql);
		ArrayList<ItemType> itemTypes = new ArrayList<ItemType>();
		while(rs.next()) {
			ItemType itemType = new ItemType();
			itemType.setCode(rs.getString(1));
			itemType.setName(rs.getString(2));
			itemTypes.add(itemType);
		}
		return itemTypes;
	}
	
	public static int UpdateItemTypeList(ItemType it) throws SQLException {
		String sql = "update itemType set itemType_name="+ it.getName() +" where itemType_code="+ it.getCode();
		return dbConfiguration.excuteUpdateStatement(sql);
		
	}
	public static int addItemTypeList(ItemType it) throws SQLException {
		String sql = "insert itemType(itemType_name,itemType_code) values("+it.getCode()+","+it.getName()+")";
		return dbConfiguration.excuteAddStatement(sql);
		
	}
	/**************************************** item type DAO operations end*******************************************/
	
	public static ArrayList<Items> getItemsList() throws SQLException {
		String sql = "select * from items";
		ResultSet rs = dbConfiguration.excuteSelectStatement(sql);
		ArrayList<Items> items = new ArrayList<Items>();
		while(rs.next()) {
			Items item = new Items();
			item.setProductID(rs.getString(1));
			item.setProduct(rs.getString(2));
			item.setModel(rs.getString(3));
			item.setManufacturerCode(rs.getString(4));
			item.setSupplierCode(rs.getString(5));
			item.setItemTypeCode(rs.getString(6));
			item.setLocationCode(rs.getString(7));
			item.setMSRP(rs.getFloat(8));
			item.setUnitCost(rs.getFloat(9));
			item.setDiscountRate(rs.getFloat(10));
			item.setStockQty(rs.getInt(11));
			item.setLastUpdated(rs.getDate(12));
			items.add(item);
		}
		return items;
	}
	
	public static int deleteItem(Items item) {
		String sql = "delete from items where product_Id="+item.getProductID();
		return dbConfiguration.excuteDeleteStatement(sql);
	}
}
