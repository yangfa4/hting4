package com.sy.demo.dao.zsm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zsm.MerchantcollectionVo;
import com.sy.demo.vo.zsm.serviceVo;
import com.sy.demo.vo.zsm.servicebtVo;

public interface zsmserviceDao {

	/**
	 * 根据用户查找服务收藏每个类别个数
	 * @param userID
	 * @return
	 */
	List<servicebtVo>SelectBysl(@Param("userID") Integer userID);
	
	
	/**
	 * 查询某个用户所有收藏的服务
	 * @param userID
	 * @return
	 */
	List<serviceVo>SelectService(@Param("userID") Integer userID,@Param("serviceTitle") String serviceTitle,@Param("stName") String stName);

    /**
     * 根据收藏服务ID删除服务
     * @param serColleID
     */
	void deleteServiceByid(@Param("serColleID") Integer serColleID);

	/**
	 * 查询收藏信息
	 * @return
	 */
	MerchantcollectionVo SelectMerchan(@Param("userID") Integer userID);
	
	/**
	 * 查询收藏商家服务信息
	 * @return
	 */
	List<Services> SelectServices();
	
	/**
	 * 查询商家店铺信息
	 * @return
	 */
	User SelectUser();
	
	
}
