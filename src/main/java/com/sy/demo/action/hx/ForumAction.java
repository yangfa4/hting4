package com.sy.demo.action.hx;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.hx.ForumBiz;
import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.hx.PostVo;

@Controller
@RequestMapping("/Forum")
public class ForumAction {

	@Autowired
	private ForumBiz biz;
	
	/**
	 * 所有模块查询
	 * @param model
	 * @param pid
	 * @return
	 */
	@GetMapping("findBlock")
	public String findBlock(Model model,Integer pid,
			@RequestParam(required=false) String title,
			@RequestParam(required=false) Integer forumid,
			@RequestParam(required=false) Integer orderId,
			Integer essence,
			@RequestParam(defaultValue="1") Integer p,
			@RequestParam(defaultValue="5")Integer s){
		if(pid==null) {
			pid=biz.findBlock().get(0).getFmID();
		}
		model.addAttribute("list", biz.findBlock());
		model.addAttribute("clist", biz.findColumn(pid));
		model.addAttribute("lname", biz.findTitleName(pid));
		model.addAttribute("Page_list", biz.findPostList(pid, title, forumid, orderId, essence, p, s));
		return "hx/lt-forum";
	}
	
	@GetMapping("findHotPost")
	public String findHostPost(@RequestParam(defaultValue="1") Integer p,
			@RequestParam(defaultValue="5")Integer s,String title,Model mo) {
		mo.addAttribute("list", biz.findBlock());
		mo.addAttribute("HOTPOST", biz.FindHostPost(title, p, s));
		return "hx/lt-hotforum";
	}
	
	
	@GetMapping("findPostDes")
	public String findDesils(Integer postId,Model model,@RequestParam(defaultValue="1") Integer p,
			@RequestParam(defaultValue="5")Integer s) {
		model.addAttribute("PostDes", biz.findPostDes(postId));
		model.addAttribute("PAGE_INFO", biz.findcomment(postId,p,s));
		model.addAttribute("HOTPOST", biz.FindHostPost(null, 1, 5));
		
		return "hx/lt-postDetail";
	}
	
	@PostMapping("login")
	public String login(HttpSession session) {
		User u=new User();
		u.setUserID(26);
		u.setUserName("倾心");
		session.setAttribute("login", u);
		return "hx/lt-myforum";
	}
	
	
	
}
