package com.sy.demo.action.hx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.demo.biz.hx.ForumBiz;
import com.sy.demo.pojo.Forummanagement;

@RestController
@RequestMapping("/Forum")
public class ForumAction {

	@Autowired
	private ForumBiz biz;
	
	@GetMapping("findBlock")
	public List<Forummanagement> findBlock(){
		return biz.findBlock();
	}

	@GetMapping("findColumn/{pid}")
	public List<Forummanagement> findColumn(@PathVariable Integer pid){
		return biz.findColumn(pid);
	}

	@GetMapping("findTitleName")
	public Forummanagement findTitleName(Integer fmid){
		return biz.findTitleName(fmid);
	}
	
}
