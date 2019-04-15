package com.sy.demo.action.zsm;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.demo.biz.zsm.zsmServiceBiz;
import com.sy.demo.pojo.User;

@Controller
@RequestMapping("/fwsc")
public class zsmServiceAction {

	@Autowired
	private zsmServiceBiz biz;
	
	/**
	 * 服务收藏根据用户ID去完成
	 * @param model
	 * @param serviceTitle
	 * @return
	 */
	@RequestMapping("/SelectService")
	public String SelectService(Model model,String serviceTitle,String stName,HttpSession session) {
		//需要获取sessice
		User user=(User) session.getAttribute("USER");
		model.addAttribute("sl", biz.SelectBysl(user.getUserID()));
		model.addAttribute("shuju",biz.SelectService(user.getUserID(), serviceTitle,stName));
		model.addAttribute("if", 1);
		System.out.println(biz.SelectService(user.getUserID(), serviceTitle,stName));
		System.out.println(biz.SelectBysl(user.getUserID()));
		return "zsm/grzx-favs";
	}
	@RequestMapping("/SelectServicee/{stName}")
	public String SelectServicee(Model model,String serviceTitle,@PathVariable String stName,HttpSession session) {
		//需要获取sessice
		User user=(User) session.getAttribute("USER");
		model.addAttribute("sl", biz.SelectBysl(user.getUserID()));
		model.addAttribute("shuju",biz.SelectService(user.getUserID(), serviceTitle,stName));
		System.out.println(biz.SelectService(user.getUserID(), serviceTitle,stName));
		model.addAttribute("if", 1);
		System.out.println(biz.SelectBysl(user.getUserID()));
		return "zsm/grzx-favs";
	}
}
