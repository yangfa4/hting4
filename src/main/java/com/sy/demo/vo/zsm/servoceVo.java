package com.sy.demo.vo.zsm;

public class servoceVo {

	private String orderID;
	private Integer totalPrice;
	private String shopName;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public servoceVo(String orderID, Integer totalPrice, String shopName) {
		super();
		this.orderID = orderID;
		this.totalPrice = totalPrice;
		this.shopName = shopName;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public servoceVo() {
		super();
	}
	@Override
	public String toString() {
		return "servoceVo [orderID=" + orderID + ", totalPrice=" + totalPrice + ", shopName=" + shopName + "]";
	}
}
