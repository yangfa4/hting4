package com.sy.demo.dao.hx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Forummanagement;

public interface IForumDao {
	public List<Forummanagement>  findBlock();
	
	public List<Forummanagement> findColumn(@Param("pid") Integer pid);
	
	public Forummanagement findTitleName(@Param("fmid") Integer fmid);
}
