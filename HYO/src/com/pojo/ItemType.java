package com.pojo;


import javax.swing.table.DefaultTableModel;

public class ItemType {
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

//	public static void saveModel(DefaultTableModel model) {
//
//		//System.out.printf("Save model- rowcount |%d| \n", model.getRowCount());
//		InventoryManagement.productTypes.clear();
//
//		for (int i = 0; i < model.getRowCount(); i++) {
//			ItemType productType = new ItemType();
//
//			productType.code = model.getValueAt(i, 0).toString();
//			productType.name = model.getValueAt(i, 1).toString();
//
//			InventoryManagement.productTypes.add(productType);
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
//			Items item = InventoryManagement.items.get(i);
//			//System.out.printf("i = %d\n", i);
//
//			if (item.getTypeCode().equalsIgnoreCase(cd)) {
//				ret = true;
//				//System.out.printf("matched [%s] at %d\n", cd, i);
//				break;
//			}
//
//		}
//		return ret;
//	}
}
