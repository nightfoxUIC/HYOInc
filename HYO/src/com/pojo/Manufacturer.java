package com.pojo;


import javax.swing.table.DefaultTableModel;

public class Manufacturer {
	private String code = null;
	private String name = null;
	
	//getter setter
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

	public static void saveModel(DefaultTableModel model) {

		//System.out.printf("Save model- rowcount |%d| \n", model.getRowCount());
		//InventoryManagement.manufacturers.clear();

		for (int i = 0; i < model.getRowCount(); i++) {
			Manufacturer manufacturer = new Manufacturer();

			manufacturer.code = model.getValueAt(i, 0).toString();
			manufacturer.name = model.getValueAt(i, 1).toString();

			//InventoryManagement.manufacturers.add(manufacturer);

		}
	}	

	//checks 
//	public static boolean inUse(String cd) {
//		boolean ret = false;
//
//		for (int i = 0; i < InventoryManagement.items.size(); i++) {
//			Items item = InventoryManagement.items.get(i);
//			if (item.getManufacturerCode().equalsIgnoreCase(cd)) {
//				ret = true;
//				break;
//			}
//
//		}
//		return ret;
//	}
}
