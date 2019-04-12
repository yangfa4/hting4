package com.sy.demo;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sy.demo.biz.lhq.AdvertisementBiz;
import com.sy.demo.pojo.Advertisementapply;
import com.sy.demo.pojo.Post;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.lhq.HomePostVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LhqAdvertisementTest {
	
	@Autowired
	private AdvertisementBiz advertiseBiz;
	
	@Test
	public void queryByAtid() {
		/*
		List<AdvertisementVO> listVo=advertiseBiz.queryByAtid(1);
		for (AdvertisementVO list : listVo) {
			System.out.println("输出："+list);
			
		    System.out.println("输出图片大小："+list.getImgsize());
			
		}*/
		
		List<HomePostVO> homePostVOList=advertiseBiz.queryHomePostVO();
		for (HomePostVO homePostVO : homePostVOList) {
			System.out.println("输出美妆版块帖子"+homePostVO);
		}
		
	}
	
	@Test
	public void queryRecommendUser() {
		List<User> user=advertiseBiz.queryRecommendUser(2);
		for (User user2 : user) {
			System.out.println("输出user:"+user2);
		}
	}
	
	@Test
	public void queryHomePostByMakeup() {
		List<Post> post=advertiseBiz.queryHomePostByMakeup();
		for (Post post2 : post) {
			System.out.println("输出post:"+post2);
		}
	}
	
	/**
	 * 查看商家星级
	 * @param merchantLevel
	 * @return
	 */
	@Test
	public void getUser() {
		 advertiseBiz.getUser(24);
		 System.out.println("输出商家星级:"+advertiseBiz.getUser(24).getMerchantLevel());
	}
	
	/**
	 * 商家申请广告位
	 * @param advertisementapply
	 * @return
	 */
	@Test
	public void  saveAdvertisementapply() {
		float price=200;
		//Advertisementapply apply=new Advertisementapply(apcUrl, userID, aappUrl, auditTime, aaID, aimgPath, price, auditStatus, startTime, endTime, rentAMonth, applyTime, aid)
		Advertisementapply apply=new Advertisementapply(null,24,null,null,0,"/Uploads/adv/2017-10/20171011102015-43018.jpg",price,1,new Date(),new Date(),2,new Date(),13);
		advertiseBiz.saveAdvertisementapply(apply);
	}
	
	/**
	 * 后台审批前台商家申请的广告位
	 * @param aaID
	 * @param auditStatus
	 * @return
	 */
	@Test
	public void updateAdvertisementapply() {
		advertiseBiz.updateAdvertisementapply(1,2);
	}
	
}
