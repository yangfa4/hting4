package com.sy.demo.biz.zsm;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sy.demo.dao.zsm.zsmserviceDao;
import com.sy.demo.vo.zsm.serviceVo;
import com.sy.demo.vo.zsm.servicebtVo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class zsmServiceBiz {

	@Autowired
	private zsmserviceDao dao;
	
	
	/**
	 * 根据用户查找服务收藏每个类别个数
	 * @param userID
	 * @return
	 */
	public List<servicebtVo>SelectBysl(Integer userID){
		return dao.SelectBysl(userID);
	}
	/**
	 * 查询某个用户收藏所有的服务
	 * @param userID
	 * @return
	 */
	public List<serviceVo>SelectService(Integer userID,String serviceTitle,String stName){
		return dao.SelectService(userID,serviceTitle,stName);
	}
	
	/**
	 *根据收藏服务ID删除服务 
	 * @param serColleID
	 */
	public void DeleteService(Integer serColleID) {
		dao.deleteServiceByid(serColleID);
	}
}
