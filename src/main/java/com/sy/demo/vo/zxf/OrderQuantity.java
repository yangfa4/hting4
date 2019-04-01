package com.sy.demo.vo.zxf;

/**
 * 各类订单数
 * 
 * @className: OrderQuantity
 * @author: zxf
 * @date: 2019年3月28日 下午10:16:49
 *
 */
public class OrderQuantity {
	private int allorder; // 所有预订
	private int obligation; // 待付款
	private int waitinglist; // 待接单
	private int forservice; // 待服务
	private int hasservice; // 已服务
	private int serviceend; // 服务完成
	private int cancelservice;// 服务取消
	private int getmoneyend; // 已退款
	private int duegetmoneyend;// 未接单
	// 1待付款2待接单3待提供服务4已提供服务6服务完成6服务取消7未接单8已退款
	public int getAllorder() {
		return allorder;
	}

	public void setAllorder(int allorder) {
		this.allorder = allorder;
	}

	public int getObligation() {
		return obligation;
	}

	public void setObligation(int obligation) {
		this.obligation = obligation;
	}

	public int getWaitinglist() {
		return waitinglist;
	}

	public void setWaitinglist(int waitinglist) {
		this.waitinglist = waitinglist;
	}

	public int getForservice() {
		return forservice;
	}

	public void setForservice(int forservice) {
		this.forservice = forservice;
	}

	public int getHasservice() {
		return hasservice;
	}

	public void setHasservice(int hasservice) {
		this.hasservice = hasservice;
	}

	public int getServiceend() {
		return serviceend;
	}

	public void setServiceend(int serviceend) {
		this.serviceend = serviceend;
	}

	public int getCancelservice() {
		return cancelservice;
	}

	public void setCancelservice(int cancelservice) {
		this.cancelservice = cancelservice;
	}

	public int getGetmoneyend() {
		return getmoneyend;
	}

	public void setGetmoneyend(int getmoneyend) {
		this.getmoneyend = getmoneyend;
	}

	public int getDuegetmoneyend() {
		return duegetmoneyend;
	}

	public void setDuegetmoneyend(int duegetmoneyend) {
		this.duegetmoneyend = duegetmoneyend;
	}

	@Override
	public String toString() {
		return "OrderQuantity [allorder=" + allorder + ", obligation=" + obligation + ", waitinglist=" + waitinglist
				+ ", forservice=" + forservice + ", hasservice=" + hasservice + ", serviceend=" + serviceend
				+ ", cancelservice=" + cancelservice + ", getmoneyend=" + getmoneyend + ", duegetmoneyend="
				+ duegetmoneyend + "]";
	}

	public OrderQuantity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
