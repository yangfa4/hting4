package com.sy.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.hx.ForumBiz;
import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.vo.hx.PostVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hanting4ApplicationTests {

	@Autowired
	private ForumBiz biz;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void test() {
	 	 PageInfo<PostVo> list = biz.findPostList(1, null, null, 0, 0, 1, 5);
	 	for (PostVo f : list.getList()) {
			System.out.println(f.getUser().getUserName());
			
		}
	}

}
