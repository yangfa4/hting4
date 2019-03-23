package com.sy.demo.dao.zxf;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.User;

public interface ZXF_IDao {

	Integer rz();
	
	User queryuser(@Param("uid") Integer uid);
	
	
}
