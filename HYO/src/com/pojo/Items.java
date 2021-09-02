package com.pojo;


import java.util.Comparator;
import java.util.Date;

public class Items {

	private String productID = null;
	private String product = null;
	private String model = null;
	private String manufacturerCode = null;
	private String supplierCode = null;
	private String itemTypeCode = null;
	private String locationCode = null;
	private float MSRP;
	private float unitCost;
	private float discountRate;
	private int stockQty;
	private Date lastUpdated;
	
	

	// Getter setter for ItemList
	
	public String getProductID() {
		return productID;
	}

	public String getItemTypeCode() {
		return itemTypeCode;
	}

	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public float getMSRP() {
		return MSRP;
	}

	public void setMSRP(float mSRP) {
		MSRP = mSRP;
	}

	public float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}

	public float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}
	
	// Comparator for sorting the list by Manufacturer
	public static Comparator<Items> SortByManufacturer = new Comparator<Items>() {

		public int compare(Items itm1, Items itm2) {

			return itm1.getManufacturerCode().compareTo(itm2.getManufacturerCode()); //ascending order
		}
	};
	
	// Comparator for sorting the list by Supplier
	public static Comparator<Items> SortBySupplier = new Comparator<Items>() {

		public int compare(Items itm1, Items itm2) {

			return itm1.getSupplierCode().compareTo(itm2.getSupplierCode()); //ascending order
		}
	};

	// Comparator for sorting the list by Type
	public static Comparator<Items> SortByType = new Comparator<Items>() {

		public int compare(Items itm1, Items itm2) {

			return itm1.getItemTypeCode().compareTo(itm2.getItemTypeCode()); //ascending order
		}
	};

	// Comparator for sorting the list by Location
	public static Comparator<Items> SortByLocation = new Comparator<Items>() {

		public int compare(Items itm1, Items itm2) {

			return itm1.getLocationCode().compareTo(itm2.getLocationCode()); //ascending order
		}
	};

	// Comparator for sorting the list by MSRP
	public static Comparator<Items> SortByMSRP = new Comparator<Items>() {

		public int compare(Items itm1, Items itm2) {

			return Float.compare(itm1.getMSRP(), itm2.getMSRP()); //ascending order

		}
	};

	// Comparator for sorting the list by Unit Cost
	public static Comparator<Items> SortByUnitCost = new Comparator<Items>() {

		public int compare(Items itm1, Items itm2) {

			return Float.compare(itm1.getUnitCost(), itm2.getUnitCost()); //ascending order

		}
	};

	// Comparator for sorting the list by Availbility
	public static Comparator<Items> SortByAvailbility = new Comparator<Items>() {

		public int compare(Items itm1, Items itm2) {

			return itm2.getStockQty() - itm1.getStockQty(); // descending order

		}
	};

	// Comparator for sorting the list by profit margin
	public static Comparator<Items> SortByMargin = new Comparator<Items>() {

		public int compare(Items itm1, Items itm2) {

			float margin1 = itm1.getMSRP() - itm1.getUnitCost();
			float margin2 = itm2.getMSRP() - itm2.getUnitCost();

			return Float.compare(margin2, margin1); // descending order

		}
	};

}