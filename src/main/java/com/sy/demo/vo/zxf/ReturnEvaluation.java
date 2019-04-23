package com.sy.demo.vo.zxf;

import java.util.Date;

import com.sy.demo.pojo.Evaluationservice;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;

/**
 * 评价回复/评价(不包含回复信息)
 * 
 * @className: ReturnEvaluation
 * @author: zxf
 * @date: 2019年4月22日 上午10:09:26
 *
 */
public class ReturnEvaluation extends Evaluationservice {

	private User eu; // 被回复者

	private Services ser;

	public Services getSer() {
		return ser;
	}

	public void setSer(Services ser) {
		this.ser = ser;
	}

	public User getEu() {
		return eu;
	}

	public void setEu(User eu) {
		this.eu = eu;
	}

	public ReturnEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	
	
}
