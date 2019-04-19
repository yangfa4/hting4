package com.sy.demo.action.hx;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.sy.demo.pojo.Post;
import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.hx.ForumBiz;
import com.sy.demo.pojo.Forummanagement;
import com.sy.demo.pojo.Postcollection;
import com.sy.demo.pojo.Postcomment;
import com.sy.demo.pojo.Postfabulous;
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
			@RequestParam(defaultValue="5")Integer s,HttpSession session){
		if(pid==null) {
			pid=biz.findBlock().get(0).getFmID();
		}
		model.addAttribute("list", biz.findBlock());
		model.addAttribute("clist", biz.findColumn(pid));
		model.addAttribute("lname", biz.findTitleName(pid));
		model.addAttribute("Page_list", biz.findPostList(pid, title, forumid, orderId, essence, p, s));
		User u=biz.findUserInfo(26);
		
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
	 * @param s
	 * @return
	 */
	@GetMapping("findPostDes")
	public String findDesils(Integer postId,Model model,@RequestParam(defaultValue="1") Integer p,
			@RequestParam(defaultValue="5")Integer s,Integer fmid,HttpSession session) {
		System.err.println(session.getAttribute("USER"));
		
		model.addAttribute("User",session.getAttribute("USER"));
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
	public String findUserPost(Integer userId,Integer type,
			@RequestParam(defaultValue="1") Integer p,
			@RequestParam(defaultValue="5")Integer s,
			@RequestParam(required=false)String title,Model model) {
		PageInfo<PostVo> user_post=biz.findUserPost(p, s, userId, title);
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
 		model.addAttribute("type", type);
		model.addAttribute("USER_POST", user_post);
		model.addAttribute("user",biz.findUserInfo(userId));
		return "hx/zjw-dongtai.html";
	}
	
	/**
	 * 点赞并验证重复和验证是否自己的帖子
	 * @param fabu
	 * @param session
	 * @return
	 */
	@PostMapping("saveFabulous")
	@ResponseBody
	public Map<String,String> checkFabulous(@RequestBody Postfabulous fabu,HttpSession session){
		User user = (User)session.getAttribute("USER");
		Map<String,String> map=new HashMap<>();
		if(user==null){
			map.put("code", "100");
		}else{
			fabu.setUserID(user.getUserID());
			//验证点赞重复
			int rCol = biz.checkHasFabulous(fabu.getPostID(), fabu.getUserID());
			//验证是否点赞自己帖子
			int rSef = biz.checkIsSelf(fabu.getPostID(), fabu.getUserID());
			if(rCol>0) {
				map.put("code", "300");
			}else if(rSef>0) {
				map.put("code", "400");
			}else {
				biz.saveFabulous(fabu);
				map.put("code", "200");
			}
		}
		return map;
	}
	
	/**
	 * 收藏并验证重复和验证是否自己的帖子
	 * @param postId
	 * @param session
	 * @return
	 */
	@PostMapping("saveCollection")
	@ResponseBody
	public Map<String,String> checkCollection(@RequestBody Postcollection collec,HttpSession session){
		User user = (User)session.getAttribute("USER");
		Map<String,String> map=new HashMap<>();
		if(user==null){
			map.put("code", "100");
		}else{
			collec.setUserID(user.getUserID());
			//验证点赞重复
			int rCol = biz.checkHasCollection(collec.getPcID(),user.getUserID());
			//验证是否收藏自己帖子
			int rSef = biz.checkIsSelf(collec.getPcID(), user.getUserID());
			if(rCol>0) {
				map.put("code", "300");
			}else if(rSef>0) {
				map.put("code", "400");
			}else {
				biz.saveCollection(collec);
				map.put("code", "200");
			}
		}
		return map;
	}
	
	/**
	 * 评论
	 * @param comm
	 * @return
	 */
	@PostMapping("saveComment")
	@ResponseBody
	public Map<String,String> saveComment(@RequestBody Postcomment comm){
		Map<String,String> map=new HashMap<>();
		//int result = biz.queryCommentCount(comm.getCommentator());
		//int commuser = biz.queryCommentAtor(comm.getPostid());
		biz.saveComment(comm);
		//if(result>10||commuser==comm.getCommentator()) {
			map.put("code", "200");
		//}else {
		//	map.put("code", "300");
			//biz.updateCommentJIntegral(comm);
		//}
		return map;
	}
	
	/**
	 * 跳转到发帖页面
	 * @param pid
	 * @param fmid
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("toAddForum")
	public String toAddForum(Integer pid,@RequestParam(required=false)Integer fmid,Model model,HttpSession session) {
		User user = (User)session.getAttribute("USER");
		if(user==null) {
			return "szy-login.html";
		}else {
			//显示版块下拉框
			List<Forummanagement> list = biz.findBlock();
			model.addAttribute("BLIST", list);
			model.addAttribute("pid", pid);
			model.addAttribute("fmid", fmid);
			return "hx/lt-addForum";
		}
	}
	
	/**
	 * 显示栏目下拉框
	 * @param pid
	 * @return
	 */
	@GetMapping("showColumn")
	@ResponseBody
	public List<Forummanagement> showColumn(Integer pid){
		List<Forummanagement> list = biz.findColumn(pid);
		return list;
	}
	
	
	/**
	 * 发布帖子
	 * @param post
	 * @return
	 */
	@PostMapping("savePost")
	@ResponseBody
	public Map<String,String> savePost(@RequestBody Post post,HttpSession session) {
		Integer userId = ((User)session.getAttribute("USER")).getUserID();
		Map<String,String> map=new HashMap<>();
		post.setUserID(userId);
		int result = biz.savePost(post);
		int postCount = biz.checkPostCount(userId);
		if(result>0) {
			if(postCount>3) {
				map.put("code", "200");
			}else {
				//新增积分
				biz.updateJIntegral(userId);
				map.put("code", "300");
			}
		}else {
			map.put("code", "400");
		}
		return map;
	}

	@GetMapping("MyPost")
	public String Mypost(HttpSession session,Model model,Integer type,@RequestParam(required=false)String title,@RequestParam(defaultValue="1") Integer p) {
		User u=(User)session.getAttribute("USER");
		PageInfo<PostVo> mypost = null;
		if(u==null) {
			return "szy-login";
		}else {
			if(type==1) {
				mypost=biz.findUserPost(p, 5, u.getUserID(), title);
			}else if(type==2) {
				mypost=biz.findUserCollect(p, 5, u.getUserID(), title);
			}else if(type==3) {
				mypost=biz.findUserComment(p, 5, u.getUserID(), title);
			}	
		}
		 
		List<Forummanagement> list=biz.findBlock();
		
		model.addAttribute("LIST",list);
		model.addAttribute("MYPOST", mypost);
		return "hx/lt-myforum";
	}
	
	
	
	
	
}
