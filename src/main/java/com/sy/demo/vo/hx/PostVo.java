package com.sy.demo.vo.hx;

import java.util.List;

import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.pojo.Post;
import com.sy.demo.pojo.User;

public class PostVo extends Post {
	private User user;
	private Forummanagement forum;
	private PostcommentVo lastcomment;
	private Integer count;
	private List<PostcommentVo> commentlist;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Forummanagement getForum() {
		return forum;
	}
	public void setForum(Forummanagement forum) {
		this.forum = forum;
	}
	public PostcommentVo getLastcomment() {
		return lastcomment;
	}
	public void setLastcomment(PostcommentVo lastcomment) {
		this.lastcomment = lastcomment;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<PostcommentVo> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(List<PostcommentVo> commentlist) {
		this.commentlist = commentlist;
	}
	public PostVo() {
		super();
	}
	public PostVo(User user, Forummanagement forum, PostcommentVo lastcomment, Integer count,
			List<PostcommentVo> commentlist) {
		super();
		this.user = user;
		this.forum = forum;
		this.lastcomment = lastcomment;
		this.count = count;
		this.commentlist = commentlist;
	}
	
}
