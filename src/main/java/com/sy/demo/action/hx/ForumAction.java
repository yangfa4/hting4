package com.sy.demo.action.hx;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.hx.ForumBiz;
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
	/**
	 * 查询热门话题
	 * @param p
	 * @param s
	 * @param title
	 * @param mo
	 * @return
	 */
	@GetMapping("findHotPost")
	public String findHostPost(@RequestParam(defaultValue="1") Integer p,
			@RequestParam(defaultValue="5")Integer s,String title,Model mo) {
		mo.addAttribute("list", biz.findBlock());
		mo.addAttribute("HOTPOST", biz.FindHostPost(title, p, s,null));
		return "hx/lt-hotforum";
	}
	
	/**
	 * 查询帖子详情
	 * @param postId
	 * @param model
	 * @param p
	 * @param s
	 * @return
	 */
	@GetMapping("findPostDes")
	public String findDesils(Integer postId,Model model,@RequestParam(defaultValue="1") Integer p,
			@RequestParam(defaultValue="5")Integer s,Integer fmid) {
		model.addAttribute("User",biz.findUserInfo(26));
		model.addAttribute("PostDes", biz.findPostDes(postId));
		model.addAttribute("Fname", biz.findTitleName(fmid));
		model.addAttribute("PAGE_INFO", biz.findcomment(postId,p,s));
		model.addAttribute("HOTPOST", biz.FindHostPost(null, 1, 5,postId));
		model.addAttribute("POSTNEW", biz.findNewPost(fmid));
		return "hx/lt-postDetail";
	}
	
	/**
	 * 查询用户帖子   我的收藏 我的评论 我的帖子 等等
	 * @param type
	 * @param userId
	 * @param p
	 * @param s
	 * @param title
	 * @param model
	 * @return
	 */
	@GetMapping("findUserPost")
	public String findUserPost(Integer type,Integer userId,
			@RequestParam(defaultValue="1") Integer p,
			@RequestParam(defaultValue="5")Integer s,
			String title,Model model) {
		PageInfo<PostVo> user_post=null;
 		if(type==1) {
			model.addAttribute("POST", biz.findUserPost(p, s, userId, title));
			model.addAttribute("COMMENT", biz.findUserComment(p, s, userId, title));
			model.addAttribute("COLLECT",biz.findUserCollect(p, s, userId, title));
		}else if(type==2) {
			user_post=biz.findUserPost(p, s, userId, title);
		}else if(type==3) {
			user_post=biz.findUserComment(p, s, userId, title);
		}else if(type==3) {
			user_post=biz.findUserCollect(p, s, userId, title);
		}
		model.addAttribute("USER_POST", user_post);
		model.addAttribute("user",biz.findUserInfo(userId));
		return "zjw-dongtai.html";
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
