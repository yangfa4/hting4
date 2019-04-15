package com.sy.demo.biz.hx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.hx.IForumDao;
import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.pojo.Postcollection;
import com.sy.demo.pojo.Postfabulous;
import com.sy.demo.pojo.User;
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
	@Cacheable(value="Block")
	public List<Forummanagement>  findBlock(){
		return dao.findBlock();
	}
	/**
	 * 查询小模块
	 * @param pid
	 * @return
	 */
	@Cacheable(value="Column")
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
	public PageInfo<PostVo> FindHostPost(String title,Integer p,Integer s,Integer postid){
		PageHelper.startPage(p, s);
		return new PageInfo<PostVo>(dao.FindHostPost(title,postid));
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
	
	/**
	 * 查询我的帖子
	 * @param page
	 * @param size
	 * @param userId
	 * @param title
	 * @return
	 */
	public PageInfo<PostVo> findUserPost(Integer page,Integer size,Integer userId,String title){
		PageHelper.startPage(page, size);
		return new PageInfo<PostVo>(dao.queryMyPost(userId,title));
	}
	
	/**
	 * 查询新帖子
	 * @param fmid
	 * @return
	 */
	public List<PostVo> findNewPost(Integer fmid){
		return dao.queryNewPost(fmid);
	}
	/**
	 * 查询用户我的评论
	 * @param page
	 * @param size
	 * @param userId
	 * @param title
	 * @return
	 */
	public PageInfo<PostVo> findUserComment(Integer page,Integer size,Integer userId,String title){
		PageHelper.startPage(page, size);
		return new PageInfo<PostVo>(dao.queryMyComment(userId,title));
	}
	
	/**
	 * 查询用户 我的收藏
	 * @param page
	 * @param size
	 * @param userId
	 * @param title
	 * @return
	 */
	public PageInfo<PostVo> findUserCollect(Integer page,Integer size,Integer userId,String title){
		PageHelper.startPage(page, size);
		return new PageInfo<PostVo>(dao.queryMyCollection(userId, title));
	}
	
	/**
	 * 查询用户资料
	 * @param userId
	 * @return
	 */
	public User findUserInfo(Integer userId) {
		return dao.queryUserInfo(userId);
	}
	
	/**
	 * 验证是否收藏或点赞自己帖子
	 * @param postId
	 * @param userId
	 * @return
	 */
	public int checkIsSelf(Integer postId,Integer userId) {
		return dao.checkIsSelf(postId, userId);
	}
	
	/**
	 * 检查是否重复点赞
	 * @param postId
	 * @param userId
	 * @return
	 */
	public Integer checkHasFabulous(Integer postId,Integer userId) {
		return dao.checkHasFabulous(postId, userId);
	}
	
	/**
	 * 点赞
	 * @param fabu
	 * @return
	 */
	public Integer saveFabulous(Postfabulous fabu) {
		return dao.saveFabulous(fabu);
	}
	

	/**
	 * 验证是否重复收藏
	 * @param postId
	 * @param userId
	 * @return
	 */
	public int checkHasCollection(Integer postId,Integer userId) {
		return dao.checkHasCollection(postId, userId);
	}
	
	/**
	 * 收藏
	 * @param coll
	 * @return
	 */
	public Integer saveCollection(Postcollection coll) {
		return dao.savaCollection(coll);
	}
}
