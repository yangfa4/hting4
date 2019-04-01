package com.sy.demo.biz.lhq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sy.demo.dao.lhq.IAdvertisementDao;
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

}
