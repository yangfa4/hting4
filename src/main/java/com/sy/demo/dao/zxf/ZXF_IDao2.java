package com.sy.demo.dao.zxf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Bond;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;

public interface ZXF_IDao2 {

	/**
	 * 商家入驻申请（34列+1（交保证金 -**））
	 * @methodName: sjrz
	 * @param us
	 * @return
	 *
	 */
	 Integer sjrz(@Param("us")User us);
	 /**
	  * 新增保证金记录
	  * @methodName: addBand
	  * @param bd
	  * @return
	  *
	  */
	 Integer addBand(@Param("bd")Bond bd);
	 /**
	  * 服务信息查询
	  * @methodName: queryServices
	  * @param uid
	  * @param name
	  * @param auditStatus
	  * @return
	  *
	  */
	 List<Services> queryServices(@Param("uid")Integer uid,@Param("serviceTitle")String serviceTitle,@Param("auditStatus")Integer auditStatus);
	 
}
