package com.pojo;


import javax.swing.table.DefaultTableModel;

public class Supplier {
	private String code = null;
	private String name = null;
	
	//getters setters
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
//		InventoryManagement.suppliers.clear();
//
//		for (int i = 0; i < model.getRowCount(); i++) {
//			Supplier supplier = new Supplier();
//
//			supplier.code = model.getValueAt(i, 0).toString();
//			supplier.name = model.getValueAt(i, 1).toString();
//
//			InventoryManagement.suppliers.add(supplier);
//
//		}
//
//	}
//
//	public static boolean inUse(String cd) {
//
//		boolean ret = false;
//
//		for (int i = 0; i < InventoryManagement.items.size(); i++) {
//			Items item = InventoryManagement.items.get(i);
//			//System.out.printf("i = %d\n", i);
//
//			if (item.getSupplierCode().equalsIgnoreCase(cd)) {
//				ret = true;
//				//System.out.printf("matched [%s] at %d\n", cd, i);
//				break;
//			}
//
//		}
//		return ret;
//	}
}