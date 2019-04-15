package com.sy.demo.dao.hx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.pojo.Postcollection;
import com.sy.demo.pojo.Postfabulous;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.hx.PostVo;
import com.sy.demo.vo.hx.PostcommentVo;

public interface IForumDao {
	/**
	 * 查询大模块
	 * @return
	 */
	public List<Forummanagement>  findBlock();
	
	/**
	 *  查询小模块
	 * @param pid
	 * @return
	 */
	public List<Forummanagement> findColumn(@Param("pid") Integer pid);
	
	/**
	 * 查询对象  选中的大模块的名称
	 * @param fmid
	 * @return
	 */
	public Forummanagement findTitleName(@Param("fmid") Integer fmid);
	
	/**
	 * 查询帖子 分页
	 * @param pid
	 * @param title
	 * @param forumid
	 * @param orderId
	 * @param essence
	 * @return
	 */
	public List<PostVo> queryPostList(@Param("pid")Integer pid,
			@Param("title")String title,
			@Param("forumid")Integer forumid,
			@Param("orderId")Integer orderId,
			@Param("essence")Integer essence);
	
	
	/**
	 * 查询热门帖子
	 * @param title
	 * @return
	 */
	public List<PostVo> FindHostPost(@Param("title")String title,@Param("postid")Integer postid);
	
	/**
	 * 查询详情 浏览数加一
	 * @param postId
	 * @return
	 */
	public PostVo queryPostDetail(@Param("postId")Integer postId);
	
	/**
	 * 查询评论数
	 * @param postId
	 * @return
	 */
	public List<PostcommentVo> queryComment(@Param("postId")Integer postId);
	
	/**
	 * 查询最新帖子
	 * @param fmid
	 * @return
	 */
	public List<PostVo> queryNewPost(@Param("fmid")Integer fmid);
	
	/**
	 * 查询用户我的帖子
	 * @param userId
	 * @param title
	 * @return
	 */
	public List<PostVo>queryMyPost(@Param("userId")Integer userId,@Param("title")String title);
	/**
	 * 查询用户我的评论
	 * @param userId
	 * @param title
	 * @return
	 */
	public List<PostVo>queryMyComment(@Param("userId")Integer userId,@Param("title")String title);
	
	/**
	 * 查询用户我的收藏
	 * @param userId
	 * @param title
	 * @return
	 */
	public List<PostVo>queryMyCollection(@Param("userId")Integer userId,@Param("title")String title);
	
	/**
	 * 查询用户资料
	 * @param userId
	 * @return
	 */
	public User queryUserInfo(@Param("userId")Integer userId);
	
	/**
	 * 验证收藏帖是否是自己的帖子
	 * @param postId
	 * @param userId
	 * @return
	 */
	public int checkIsSelf(@Param("postId")Integer postId,@Param("userId")Integer userId);
	
	
	/**
	 * 检查是否重复点赞
	 * @param postId
	 * @param userId
	 * @return
	 */
	public Integer checkHasFabulous(@Param("postId")Integer postId,@Param("userId")Integer userId);
	
	/**
	 * 点赞
	 * @param fabu
	 * @return
	 */
	public Integer saveFabulous(@Param("fabu") Postfabulous fabu);
	
	/**
	 * 验证用户是否重复收藏
	 * @param userId
	 * @return
	 */
	public int checkHasCollection(@Param("postId")Integer postId,@Param("userId")Integer userId);
	
	
	/**
	 * 收藏
	 * @param coll
	 * @return
	 */
	public Integer savaCollection(@Param("coll")Postcollection coll);
	
}
