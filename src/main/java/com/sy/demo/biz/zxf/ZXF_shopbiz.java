package com.sy.demo.biz.zxf;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.zxf.ZXF_IDao1;
import com.sy.demo.dao.zxf.ZXF_IDao2;
import com.sy.demo.pojo.Appraisalapply;
import com.sy.demo.pojo.Bond;
import com.sy.demo.pojo.Evaluationservice;
import com.sy.demo.pojo.Languagetype;
import com.sy.demo.pojo.Majortype;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.Servicetype;
import com.sy.demo.pojo.Sharea;
import com.sy.demo.pojo.System;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zxf.EvaluationServiceVo;
import com.sy.demo.vo.zxf.Ordersvo1;
import com.sy.demo.vo.zxf.RefundListVo;
import com.sy.demo.vo.zxf.ReturnEvaluation;
import com.sy.demo.vo.zxf.ServiceTypeVo;

@Service
public class ZXF_shopbiz {

	@Autowired
	private ZXF_IDao1 dao1;
	@Autowired
	private ZXF_IDao2 dao2;

	public User queryby(Integer uid) {
		return dao1.queryuser(uid);
	}

	/**
	 * 查系统配置
	 * 
	 * @methodName: Querysystem
	 * @return
	 *
	 */
	public List<System> Querysystem() {
		return dao1.Querysystem();
	}

	/**
	 * 查申请服务类别
	 * 
	 * @methodName: QueryservicetypeAll
	 * @return
	 *
	 */
	public List<Servicetype> QueryservicetypeAll() {
		return dao1.QueryservicetypeAll();
	}

	/**
	 * 查中韩行政地区
	 * 
	 * @methodName: QueryShareaAll
	 * @return
	 *
	 */
	public List<Sharea> QueryShareaAll() {
		return dao1.QueryShareaAll();
	}

	/**
	 * 查服务语言
	 * 
	 * @methodName: QueryLanguagetypeAll
	 * @return
	 *
	 */
	public List<Languagetype> QueryLanguagetypeAll() {
		return dao1.QueryLanguagetypeAll();
	}

	/**
	 * 查专业
	 * 
	 * @methodName: QuerymajortypeAll
	 * @return
	 *
	 */
	public List<Majortype> QuerymajortypeAll() {
		return dao1.QuerymajortypeAll();
	}

	/**
	 * 服务信息查询
	 * 
	 * @methodName: queryServices
	 * @param uid
	 * @param name
	 * @param auditStatus
	 * @return
	 *
	 */
	public PageInfo<Services> queryServices(Integer uid, String serviceTitle, Integer auditStatus, Integer p,
			Integer s) {
		PageHelper.startPage(p, s);
		return new PageInfo<Services>(dao2.queryServices(uid, serviceTitle, auditStatus));
	}

	/**
	 * 商家入驻申请（34列+1（交保证金 -**））
	 * 
	 * @methodName: sjrz
	 * @param us
	 * @return
	 *
	 */
	public Integer sjrz(User us) {
		return dao2.sjrz(us);
	}

	/**
	 * 新增保证金记录(3)
	 * 
	 * @methodName: addBand
	 * @param bd
	 * @return
	 *
	 */
	public Integer addBand(Bond bd) {
		return dao2.addBand(bd);
	}

	/**
	 * 查询商家订单1
	 * 
	 * @methodName: queryOrders
	 * @param uid
	 * @return
	 *
	 */
	public PageInfo<Ordersvo1> queryOrders(Integer uid, String oid, Integer p, Integer s, String oids, Integer stat) {
		PageHelper.startPage(p, s);
		return new PageInfo<Ordersvo1>(dao2.queryOrders(uid, oid, oids, stat));
	}

	/**
	 * 查询商家订单2
	 * 
	 * @methodName: queryOrders
	 * @param uid
	 * @param oid
	 * @param oids
	 * @return
	 *
	 */
	public List<Ordersvo1> queryOrders(Integer uid, String oid, String oids, Integer stat) {
		return dao2.queryOrders(uid, oid, oids, stat);
	}

	/**
	 * 修改订单状态
	 * 
	 * @methodName: ordersStatupdate
	 * @param orderID
	 * @param stat
	 * @return
	 *
	 */
	public Integer ordersStatupdate(String orderID, Integer stat, Float money, Integer uid) {
		if (stat == 3) { // 状态为待服务（接单）
			dao2.usermoneyupdate(uid, money, 1); // 接单 商家加钱
		}
		return dao2.ordersStatupdate(orderID, stat);
	}

	/**
	 * 查申请服务类别(包括其子类)
	 * 
	 * @methodName: queryservicetypebystpid
	 * @param stPid
	 * @return
	 *
	 */
	public List<ServiceTypeVo> queryservicetypebystpid(Integer stPid) {
		return dao1.queryservicetypebystpid(stPid);
	}

	/**
	 * 发布服务
	 * 
	 * @methodName: addservices
	 * @param services
	 * @return
	 *
	 */
	public Integer addservices(Services services) {
		return dao2.addservices(services);
	}

	/**
	 * 商家收到的退款查询
	 * 
	 * @methodName: queryrefund
	 * @param uid
	 * @return
	 *
	 */
	public PageInfo<RefundListVo> queryrefund(Integer uid, Integer p, Integer s) {
		List<RefundListVo> list = dao2.queryrefund(uid);
		for (RefundListVo rl : list) {
			List<Ordersvo1> od = dao2.queryOrders(null, null, rl.getOrderID(), null);
			if (od != null && od.size() != 0) {
				rl.setOrder(od.get(0));
			}
		}
		PageHelper.startPage(p, s);
		return new PageInfo<RefundListVo>(list);
	}

	/**
	 * 查询退款详情
	 * 
	 * @methodName: queryrefundbyid
	 * @param id
	 * @return
	 *
	 */
	public RefundListVo queryrefundbyid(@Param("id") Integer id) {
		RefundListVo rv = dao2.queryrefundbyid(id);
		if (rv != null) {
			List<Ordersvo1> od = dao2.queryOrders(null, null, rv.getOrderID(), null);
			if (od != null && od.size() > 0) {
				rv.setOrder(od.get(0));
			}
			rv.getOrder().setU2(dao1.queryuser(rv.getOrder().getSer().getUserID()));
		}
		return rv;
	}

	/**
	 * 金币修改,改退款表商家审核状态(同意)
	 * 
	 * @methodName: usermoneyupdate
	 * @param uid
	 * @param money
	 * @param jiajian
	 *            1/加 , 2/减
	 * @return
	 *
	 */
	public Integer ordersrefundstatusupdate(RefundListVo rv, String businessremarks) {
		if (businessremarks == null) {
			dao2.usermoneyupdate(rv.getOrder().getU().getUserID(), rv.getApplyRefundMoney(), 1); // 改客户金币 +
			dao2.usermoneyupdate(rv.getOrder().getU2().getUserID(), rv.getOrder().getTotalPrice(), 2); // 改商家金币 -
			dao2.ordersrefundstatusupdate(rv.getOrderID(), 5); // 改订单表退款状态
			return dao2.refundrefundstatusupdate(rv.getRefundID(), 2, null); // 改退款表商家审核状态
		} else {
			dao2.ordersrefundstatusupdate(rv.getOrderID(), 2); // 改订单表退款状态
			return dao2.refundrefundstatusupdate(rv.getRefundID(), 3, businessremarks); // 改退款表商家审核状态
		}
	}

	/**
	 * 查询鉴定记录
	 * 
	 * @methodName: queryAppraisalapplyByStidAndUserID
	 * @param stid
	 * @param userID
	 * @return
	 *
	 */
	public Appraisalapply queryAppraisalapplyByStidAndUserID(Integer stid, Integer userID) {
		return dao1.queryAppraisalapplyByStidAndUserID(stid, userID);
	}

	/**
	 * 新增服务鉴定
	 * 
	 * @methodName: addAppraisalapply
	 * @param ap
	 * @return
	 *
	 */
	public int addAppraisalapply(Appraisalapply ap) {
		return dao2.addAppraisalapply(ap);
	}

	/**
	 * 商家查评价
	 * 
	 * @methodName: queryEvaluation
	 * @param uid
	 * @return
	 *
	 */
	public PageInfo<EvaluationServiceVo> queryEvaluation(Integer uid, Integer p, Integer s) {
		List<EvaluationServiceVo> lt = dao2.queryEvaluation(uid, 0);
		for (ReturnEvaluation es : lt) {
				EvaluationServiceVo ev = (EvaluationServiceVo)es;
				ev.setEu(dao1.queryuser(es.getUserID()));
				ev.setRe(toReturnEvaluation(dao2.queryEvaluation(uid, 1)));
				ev.setSer(dao2.querybyser(ev.getServiceID()));
		}
		PageHelper.startPage(p, s);
		return new PageInfo<EvaluationServiceVo>(lt);
	}
	
	public List<ReturnEvaluation> toReturnEvaluation(List<EvaluationServiceVo> lt){
		List<ReturnEvaluation> list = new ArrayList<ReturnEvaluation>();
		for (EvaluationServiceVo ev : lt) {
			ev.setEu(dao1.queryuser(ev.getUserID()));
			list.add(ev);
		}
		return list;
	}
	
	/**
	 * 商家回复
	 * 
	 * @methodName: addEvaluation
	 * @param ev
	 * @return
	 *
	 */
	public int addEvaluation(Evaluationservice ev) {
		return dao2.addEvaluation(ev);
	}
	

}
