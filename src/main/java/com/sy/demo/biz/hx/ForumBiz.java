package com.sy.demo.biz.hx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.demo.dao.hx.IForumDao;
import com.sy.demo.pojo.Forummanagement;
@Service
public class ForumBiz {
	@Autowired
	private IForumDao dao;
	
	public List<Forummanagement>  findBlock(){
		return dao.findBlock();
	}
	
	public List<Forummanagement> findColumn(Integer pid){
		return dao.findColumn(pid);
	}
}
