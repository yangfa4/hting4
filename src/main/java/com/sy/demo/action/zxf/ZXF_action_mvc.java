package com.sy.demo.action.zxf;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sy.demo.biz.zxf.ZXF_shopbiz;
import com.sy.demo.pojo.Bond;
import com.sy.demo.pojo.Languagetype;
import com.sy.demo.pojo.Majortype;
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
	public String toshop(Integer uid, HttpSession session, Model mod) {
		User us = (User) session.getAttribute("user");
		String path = "zxf//sjzx-index"; // 默认url《商家中心》
		if (us == null) {
			us = biz.queryby(uid); // 获取当前登录用户信息
			session.setAttribute("user", us);
		}
		session.setAttribute("system", biz.Querysystem().get(0));
		if (us.getMerchantType() == 0) { // 0：不是商家-------有点点错误
			path = "zxf//sjrz-yktsj";
		} else {
			mod.addAttribute("servicetype", biz.QueryservicetypeAll());
		}
		return path;
	}

	/**
	 * 去商家入驻填写资料
	 * 
	 * @methodName: totxzl
	 * @param session
	 * @param mod
	 * @return
	 *
	 */
	@RequestMapping("totxzl")
	public String totxzl(HttpSession session, Model mod) {
		mod.addAttribute("servicetypeList", biz.QueryservicetypeAll());
		mod.addAttribute("liveCityList", biz.QueryShareaAll());
		mod.addAttribute("languagetypeList", biz.QueryLanguagetypeAll());
		mod.addAttribute("majortypeList", biz.QuerymajortypeAll());
		return "zxf//sjrz-txzl";
	}

	@PostMapping("shrz")
	public String shrz(User user, String serviceID, MultipartFile Img1, MultipartFile Img2, MultipartFile Img3,
			MultipartFile Img4, String[] langs, String[] majors) throws Exception {
		user.setAuditStatus(1); // 1待审核2已通过3拒绝
		String fileName1 = Img1.getOriginalFilename();
		user.setShopImg(File.separator + fileName1);
		Img1.transferTo(new File(File.separator + fileName1));
		String fileName2 = Img2.getOriginalFilename();
		user.setIdentityPositiveImg(File.separator + fileName2);
		Img2.transferTo(new File(File.separator + fileName2));
		String fileName3 = Img3.getOriginalFilename();
		user.setIdentityNegativeImg(File.separator + fileName3);
		Img3.transferTo(new File(File.separator + fileName3));
		String fileName4 = Img4.getOriginalFilename();
		user.setIdentityHandImg(File.separator + fileName4);
		Img4.transferTo(new File(File.separator + fileName4));
		int index = serviceID.indexOf(",");
		System.out.println(index);
		if (index != -1) {
			user.setFirstServiceID(Integer.parseInt(serviceID.substring(0, index)));
			user.setSecondServiceID(Integer.parseInt(serviceID.substring(index + 1)));
		} else {
			user.setFirstServiceID(Integer.parseInt(serviceID));
		}
		if (user.getExperienceStatus() == 0) {
			user.setGuaranteeMoney(500); // 500保证金
			user.setUserMoney(user.getUserMoney() - 500); // 扣钱500保证金
		}
		List<Languagetype> list = biz.QueryLanguagetypeAll();
		if(langs!=null) {
			for (int i = 0; i < langs.length; i++) {
				if (langs[i] != " " && langs[i].length() > 0) {
					for (Languagetype Lang : list) {
						if (Lang.getLanguageID() == Integer.parseInt(langs[i])) {
							if (i != 0) {
								user.setLanguageNameText(user.getLanguageNameText() + ",");
							}
							user.setLanguageNameText(user.getLanguageNameText() + Lang.getLanguageName());
							break;
						}
					}
				}
			}
		}
		
		List<Majortype> list2 = biz.QuerymajortypeAll();
		if (majors != null) {
			for (int i = 0; i < majors.length; i++) {
				if (majors[i] != " " && majors[i].length() > 0) {
					for (Majortype maj : list2) {
						if (maj.getMajorID() == Integer.parseInt(majors[i])) {
							if (i != 0) {
								user.setMajorNameText(user.getMajorNameText() + ",");
							}
							user.setMajorNameText(user.getMajorNameText() + maj.getMajorName());
							break;
						}
					}
				}
			}
		}
		biz.sjrz(user);
		System.out.println(user);
		if (user.getExperienceStatus() == 0) {
			Bond bd = new Bond();
			bd.setUserID(user.getUserID());
			bd.setBondType(1);
			bd.setGoldCoin(new Float(+500));
			biz.addBand(bd);
		}
		System.out.println(user.getMajorNameText());
		System.out.println(user.getLanguageNameText());
		return "zxf//sjrz-shzl";
	}

	@RequestMapping("tosddyd")
	public String sddyd(Model mod, Integer uid) {

		return "zxf//sjzx-order";
	}

	@RequestMapping("tofbdfw")
	public String fbdfw(Model mod, Integer uid, Integer p, Integer s, String title, Integer auditStatus) {
		System.out.println(title);
		mod.addAttribute("title", title);
		mod.addAttribute("auditStatus", auditStatus);
		mod.addAttribute("PAGE_INFO", biz.queryServices(uid, title, auditStatus, p, s));
		return "zxf//sjzx-services";
	}
}
