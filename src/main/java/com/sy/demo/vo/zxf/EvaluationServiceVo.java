package com.sy.demo.vo.zxf;

import java.util.List;

/**
 * 评价(包含回复信息)
 * 
 * @className: EvaluationServiceVo
 * @author: zxf
 * @date: 2019年4月19日 下午9:32:44
 *
 */
public class EvaluationServiceVo extends ReturnEvaluation {

 
	private List<ReturnEvaluation> re;
	
	
	public List<ReturnEvaluation> getRe() {
		return re;
	}

	public void setRe(List<ReturnEvaluation> re) {
		this.re = re;
	}

	public EvaluationServiceVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
