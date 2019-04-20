package com.sy.demo.vo.zxf;

import com.sy.demo.pojo.Refund;

public class RefundListVo extends Refund {

	private Ordersvo1 order = new Ordersvo1();

	public Ordersvo1 getOrder() {
		return order;
	}

	public void setOrder(Ordersvo1 order) {
		this.order = order;
	}

	public RefundListVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
