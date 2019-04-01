package com.sy.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sy.demo.biz.hx.ForumBiz;
import com.sy.demo.pojo.Forummanagement;

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
	 	List<Forummanagement> list= biz.findBlock();
	 	for (Forummanagement f : list) {
			System.out.println(f);
		}
	}

}
