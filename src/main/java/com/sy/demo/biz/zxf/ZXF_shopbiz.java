package com.sy.demo.biz.zxf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.demo.dao.zxf.ZXF_IDao1;
import com.sy.demo.pojo.Languagetype;
import com.sy.demo.pojo.Majortype;
import com.sy.demo.pojo.Servicetype;
import com.sy.demo.pojo.Sharea;
import com.sy.demo.pojo.User;

@Service
public class ZXF_shopbiz {

	@Autowired
	private ZXF_IDao1 dao1;

	public User queryby(Integer uid) {
		return dao1.queryuser(uid);
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
}
