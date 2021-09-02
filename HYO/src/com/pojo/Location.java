package com.pojo;


import javax.swing.table.DefaultTableModel;

public class Location {
	private String code = null;
	private String name = null;
	
	
	//getter setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public static void saveModel(DefaultTableModel model) {
//
//		//System.out.printf("Save model- rowcount |%d| \n", model.getRowCount());
//		InventoryManagement.locations.clear();
//
//		for (int i = 0; i < model.getRowCount(); i++) {
//			Location location = new Location();
//
//			location.code = model.getValueAt(i, 0).toString();
//			location.name = model.getValueAt(i, 1).toString();
//
//			InventoryManagement.locations.add(location);
//
//		}
//
//	}
//
//	public static boolean inUse(String cd) {
//		// TODO Auto-generated method stub
//		boolean ret = false;
//
//		for (int i = 0; i < InventoryManagement.items.size(); i++) {
//			ItemList item = InventoryManagement.items.get(i);
//			//System.out.printf("i = %d\n", i);
//
//			if (item.getLocationCode().equalsIgnoreCase(cd)) {
//				ret = true;
//				//System.out.printf("matched [%s] at %d\n", cd, i);
//				break;
//			}
//
//		}
//		return ret;
//	}
}
