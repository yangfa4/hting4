package com.sy.demo.biz.hx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.hx.IForumDao;
import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.vo.hx.PostVo;
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
	
	public Forummanagement findTitleName(Integer fmid) {
		return dao.findTitleName(fmid);
	}
	
	public PageInfo<PostVo> findPostList(Integer pid,
			String title,Integer forumid,
			Integer orderId,Integer essence,Integer p,Integer s){
		PageHelper.startPage(p,s);
		return new PageInfo<PostVo>(dao.queryPostList(pid,title,forumid,orderId,essence));
	}
	
	public PostVo findPostDes(Integer postId) {
		return dao.queryPostDetail(postId);
	}
}
