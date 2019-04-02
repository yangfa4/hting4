package com.sy.demo.dao.hx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Forummanagement;
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
	public List<PostVo> FindHostPost(@Param("title")String title);
	
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
	
	
	public List<PostVo>queryMyPost(@Param("userId")Integer userId,@Param("title")String title);
	
	public List<PostVo>queryMyComment(@Param("userId")Integer userId,@Param("title")String title);
	
	public List<PostVo>queryMyCollection(@Param("userId")Integer userId,@Param("title")String title);
	
}
