package com.sy.demo.dao.lhq;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Post;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.lhq.AdvertisementVO;
import com.sy.demo.vo.lhq.HomePostVO;

public interface IAdvertisementDao {
	
	/**
	 * 查询首页广告
	 * @return
	 */
	public List<AdvertisementVO> queryByAtid(@Param("flag")Integer flag);
	
	/**
	 * 首页社区服务星级服务推荐商家
	 * @param stid
	 * @return
	 */
	public List<User> queryRecommendUser(@Param("stid")Integer stid);
	/**
	 * 查询首页社区服务最新帖子
	 * @return
	 */
	public List<HomePostVO> queryHomePostVO();
	
	/**
	 * 查询首页社区服务美妆天地板块帖子
	 * @return
	 */
	public List<Post> queryHomePostByMakeup();
	

}
