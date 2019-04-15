package com.sy.demo.util.zxf;

import java.util.List;

import com.sy.demo.pojo.Orders;
import com.sy.demo.vo.zxf.OrderQuantity;
import com.sy.demo.vo.zxf.Ordersvo1;

public class Number {

	public static OrderQuantity OrderNumber(List<Ordersvo1> listod) {
		OrderQuantity oq = new OrderQuantity();
		oq.setAllorder(listod.size());
		for (Ordersvo1 orders : listod) {
			switch (orders.getOrderStatus()) {
			case 1:
				oq.setObligation(oq.getObligation() + 1);
				break;
			case 2:
				oq.setWaitinglist(oq.getWaitinglist() + 1);
				break;
			case 3:
				oq.setForservice(oq.getForservice() + 1);
				break;
			case 4:
				oq.setHasservice(oq.getHasservice() + 1);
				break;
			case 5:
				oq.setServiceend(oq.getServiceend() + 1);
				break;
			case 6:
				oq.setCancelservice(oq.getCancelservice() + 1);
				break;
			case 7:
				oq.setDuegetmoneyend(oq.getDuegetmoneyend() + 1);
				break;
			case 8:
				oq.setGetmoneyend(oq.getGetmoneyend() + 1);
				break;
			default:
				break;
			}
		}
		return oq;
	}
}
