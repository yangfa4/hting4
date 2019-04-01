package com.sy.demo.biz.zxf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.zxf.ZXF_IDao1;
import com.sy.demo.dao.zxf.ZXF_IDao2;
import com.sy.demo.pojo.Bond;
import com.sy.demo.pojo.Languagetype;
import com.sy.demo.pojo.Majortype;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.Servicetype;
import com.sy.demo.pojo.Sharea;
import com.sy.demo.pojo.System;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zxf.Ordersvo1;

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
	 * 查询商家订单
	 * 
	 * @methodName: queryOrders
	 * @param uid
	 * @return
	 *
	 */
	public PageInfo<Ordersvo1> queryOrders(Integer uid,String oid, Integer p, Integer s,String oids) {
		PageHelper.startPage(p, s);
		return new PageInfo<Ordersvo1>(dao2.queryOrders(uid,oid,oids));
	}

	public List<Ordersvo1> queryOrders(Integer uid,String oid,String oids) {
		return dao2.queryOrders(uid,oid,oids);
	}
}
