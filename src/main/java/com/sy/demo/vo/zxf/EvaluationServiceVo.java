package com.sy.demo.vo.zxf;

import java.util.Date;

import com.sy.demo.pojo.Evaluationservice;
import com.sy.demo.pojo.User;

/**
 * 评价
 * 
 * @className: EvaluationServiceVo
 * @author: zxf
 * @date: 2019年4月19日 下午9:32:44
 *
 */
public class EvaluationServiceVo extends Evaluationservice {

	private User eu; // 评价者

	public User getEu() {
		return eu;
	}

	public void setEu(User eu) {
		this.eu = eu;
	}

	public EvaluationServiceVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
