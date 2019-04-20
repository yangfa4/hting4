package com.sy.demo.vo.zxf;

import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;

public class Ordersvo1 extends Orders {

	private Services ser = new Services();

	private User u; // 客户

	private User u2; // 商家

	public User getU2() {
		return u2;
	}

	public void setU2(User u2) {
		this.u2 = u2;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Services getSer() {
		return ser;
	}

	public void setSer(Services ser) {
		this.ser = ser;
	}

	public Ordersvo1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
