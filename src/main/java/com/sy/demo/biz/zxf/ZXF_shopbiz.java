package com.sy.demo.biz.zxf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.demo.dao.zxf.ZXF_IDao;
import com.sy.demo.pojo.User;


@Service
public class ZXF_shopbiz {

	@Autowired
	private ZXF_IDao dao;
	
	public User queryby(Integer uid) {
		return dao.queryuser(uid);
	}
	
	
}
