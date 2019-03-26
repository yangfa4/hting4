package com.sy.demo.dao.hx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.vo.hx.PostVo;

public interface IForumDao {
	public List<Forummanagement>  findBlock();
	
	public List<Forummanagement> findColumn(@Param("pid") Integer pid);
	
	public Forummanagement findTitleName(@Param("fmid") Integer fmid);
	
	public List<PostVo> queryPostList(@Param("pid")Integer pid,
			@Param("title")String title,
			@Param("forumid")Integer forumid,
			@Param("orderId")Integer orderId,
			@Param("essence")Integer essence);
	
	public PostVo queryPostDetail(@Param("postId")Integer postId);
	
	
}
