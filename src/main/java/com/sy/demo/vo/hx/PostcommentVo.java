package com.sy.demo.vo.hx;

import com.sy.demo.pojo.Postcomment;
import com.sy.demo.pojo.User;

public class PostcommentVo extends Postcomment {
	private User user;
	private PostcommentVo pc;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostcommentVo getPc() {
		return pc;
	}

	public void setPc(PostcommentVo pc) {
		this.pc = pc;
	}
	
}