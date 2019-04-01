package com.sy.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sy.demo.biz.lhq.AdvertisementBiz;
import com.sy.demo.pojo.Post;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.lhq.AdvertisementVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LhqAdvertisementTest {
	
	@Autowired
	private AdvertisementBiz advertiseBiz;
	
	@Test
	public void queryByAtid() {
		
		List<AdvertisementVO> listVo=advertiseBiz.queryByAtid(1);
		for (AdvertisementVO list : listVo) {
			System.out.println("输出："+list);
			
		    System.out.println("输出图片大小："+list.getImgsize());
			
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


}
