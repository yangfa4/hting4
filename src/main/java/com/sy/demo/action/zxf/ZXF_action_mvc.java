package com.sy.demo.action.zxf;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.demo.biz.zxf.ZXF_shopbiz;
import com.sy.demo.pojo.User;

@Controller
@RequestMapping("/zxf/mvc")
public class ZXF_action_mvc {

	@Autowired
	private ZXF_shopbiz biz;

	/**
	 * 访问页面
	 * 
	 * @methodName: to_url
	 * @param path
	 * @return
	 *
	 */
	@RequestMapping("/to")
	public String to_url(String path) {
		return path;
	}

	/**
	 * 去商家中心
	 * 
	 * @methodName: toshop
	 * @param uid
	 * @param session
	 * @return
	 *
	 */
	@RequestMapping("toshop")
	public String toshop(Integer uid, HttpSession session) {
		User us = biz.queryby(uid); // 获取当前登录用户信息
		String path = "zxf//sjzx-index"; // 默认url《商家中心》
		session.setAttribute("user", us);
		if (us.getMerchantType() == 0) { // 0：不是商家
			path = "zxf//sjrz-yktsj";
		}
		return path;
	}

	@RequestMapping("totxzl")
	public String totxzl(HttpSession session, Model mod) {
		mod.addAttribute("servicetypeList", biz.QueryservicetypeAll());
		mod.addAttribute("liveCityList", biz.QueryShareaAll());
		mod.addAttribute("languagetypeList", biz.QueryLanguagetypeAll());
		mod.addAttribute("majortypeList", biz.QuerymajortypeAll());
		return "zxf//sjrz-txzl";
	}

}