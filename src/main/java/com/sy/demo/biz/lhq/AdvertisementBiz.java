package com.sy.demo.biz.lhq;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sy.demo.dao.lhq.IAdvertisementDao;
import com.sy.demo.pojo.Advertisement;
import com.sy.demo.pojo.Advertisementapply;
import com.sy.demo.pojo.Post;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.lhq.AdvertisementVO;
import com.sy.demo.vo.lhq.HomePostVO;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class AdvertisementBiz {
	
	@Autowired
	private IAdvertisementDao advertiseDao;
	
	/**
	 * 查询首页广告
	 * @return
	 */
	public List<AdvertisementVO> queryByAtid(Integer flag){
		return advertiseDao.queryByAtid(flag);
	}
	
	/**
	 * 首页社区服务星级服务推荐商家
	 * @param stid
	 * @return
	 */
	public List<User> queryRecommendUser(Integer stid){
		return advertiseDao.queryRecommendUser(stid);
	}
	/**
	 * 查询首页社区服务最新帖子
	 * @return
	 */
	public List<HomePostVO> queryHomePostVO(){
		return advertiseDao.queryHomePostVO();
	}
	/**
	 * 查询首页社区服务美妆天地板块帖子
	 * @return
	 */
	public List<Post> queryHomePostByMakeup(){
		return advertiseDao.queryHomePostByMakeup();
	}
	
	
	/**
	 * 查看商家星级
	 * @param merchantLevel
	 * @return
	 */
	public User getUser(Integer userID) {
		return advertiseDao.getUser(userID);
	}
	
	/**
	 * 商家申请广告位
	 * @param advertisementapply
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void  saveAdvertisementapply(Advertisementapply advertisementapply) {
		advertiseDao.saveAdvertisementapply(advertisementapply);
	}
	
	/**
	 * 后台审批前台商家申请的广告位
	 * @param aaID
	 * @param auditStatus
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void updateAdvertisementapply(Integer aaID,Integer auditStatus) {
		advertiseDao.updateAdvertisementapply(aaID, auditStatus);
	}
	
	/**
	 * 查询星级广告位
	 * @return
	 */
	public List<Advertisement> findByAtid(){
		return advertiseDao.findByAtid();
	}

}
