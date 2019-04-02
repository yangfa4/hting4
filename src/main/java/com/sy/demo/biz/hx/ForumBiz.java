package com.sy.demo.biz.hx;

import java.net.Inet4Address;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.hx.IForumDao;
import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.pojo.Post;
import com.sy.demo.vo.hx.PostVo;
import com.sy.demo.vo.hx.PostcommentVo;
@Service
public class ForumBiz {
	@Autowired
	private IForumDao dao;
	/**
	 * 查询大板块
	 * @return
	 */
	public List<Forummanagement>  findBlock(){
		return dao.findBlock();
	}
	/**
	 * 查询小模块
	 * @param pid
	 * @return
	 */
	public List<Forummanagement> findColumn(Integer pid){
		return dao.findColumn(pid);
	}
	/**
	 * 查询对象  选中的大模块的名称
	 * @param fmid
	 * @return
	 */
	public Forummanagement findTitleName(Integer fmid) {
		return dao.findTitleName(fmid);
	}
	/**
	 * 查询帖子 分页
	 * @param pid
	 * @param title
	 * @param forumid
	 * @param orderId
	 * @param essence
	 * @param p
	 * @param s
	 * @return
	 */
	public PageInfo<PostVo> findPostList(Integer pid,
			String title,Integer forumid,
			Integer orderId,Integer essence,Integer p,Integer s){
		PageHelper.startPage(p,s);
		return new PageInfo<PostVo>(dao.queryPostList(pid,title,forumid,orderId,essence));
	}
	/**
	 * 查询热门帖子
	 * @param title
	 * @param p
	 * @param s
	 * @return
	 */
	public PageInfo<PostVo> FindHostPost(String title,Integer p,Integer s){
		PageHelper.startPage(p, s);
		return new PageInfo<PostVo>(dao.FindHostPost(title));
	}
	/**
	 * 查询详情 浏览数加一
	 * @param postId
	 * @return
	 */
	public PostVo findPostDes(Integer postId) {
		return dao.queryPostDetail(postId);
	}
	/**
	 * 查询评论数
	 * @param postId
	 * @param p
	 * @param s
	 * @return
	 */
	public PageInfo<PostcommentVo> findcomment(Integer postId,Integer p,Integer s){
		PageHelper.startPage(p, s);
		return new PageInfo<PostcommentVo>(dao.queryComment(postId));
	}
	
	public PageInfo<PostVo> findUserPost(Integer page,Integer size,Integer userId,String title){
		PageHelper.startPage(page, size);
		return new PageInfo<PostVo>(dao.queryMyPost(userId,title));
	}
	
	public PageInfo<PostVo> findUserComment(Integer page,Integer size,Integer userId,String title){
		PageHelper.startPage(page, size);
		return new PageInfo<PostVo>(dao.queryMyComment(userId,title));
	}
	
	public PageInfo<PostVo> findUserCollect(Integer page,Integer size,Integer userId,String title){
		PageHelper.startPage(page, size);
		return new PageInfo<PostVo>(dao.queryMyCollection(userId, title));
	}
	
}
