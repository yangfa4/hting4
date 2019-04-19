package com.sy.demo.dao.zxf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Appraisalapply;
import com.sy.demo.pojo.Languagetype;
import com.sy.demo.pojo.Majortype;
import com.sy.demo.pojo.Servicetype;
import com.sy.demo.pojo.Sharea;
import com.sy.demo.pojo.System;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zxf.ServiceTypeVo;

public interface ZXF_IDao1 {

	User queryuser(@Param("uid") Integer uid);

	// 查系统配置
	List<System> Querysystem();

	// 查申请服务类别
	List<Servicetype> QueryservicetypeAll();

	// 查中韩行政地区
	List<Sharea> QueryShareaAll();

	// 查服务语言
	List<Languagetype> QueryLanguagetypeAll();

	// 查专业
	List<Majortype> QuerymajortypeAll();

	// 查申请服务类别(包括其子类)
	List<ServiceTypeVo> queryservicetypebystpid(@Param("stPid") Integer stPid);

	// 查询鉴定记录
	Appraisalapply queryAppraisalapplyByStidAndUserID(@Param("stid") Integer stid, @Param("userID") Integer userID);
}
