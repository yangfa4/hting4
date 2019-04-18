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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.zxf.ZXF_shopbiz;
import com.sy.demo.pojo.Bond;
import com.sy.demo.pojo.Languagetype;
import com.sy.demo.pojo.Majortype;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;
import com.sy.demo.util.zxf.Number;
import com.sy.demo.vo.zxf.OrderQuantity;
import com.sy.demo.vo.zxf.Ordersvo1;
import com.sy.demo.vo.zxf.RefundListVo;

@Controller
@RequestMapping("/zxf/mvc")
public class ZXF_action_mvc {

	@Autowired
	private ZXF_shopbiz biz;

	private OrderQuantity oq = null;

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
		User us = (User) session.getAttribute("USER");
		String path = "zxf//sjzx-index"; // 默认url《商家中心》
		if (uid != null) {
			us = biz.queryby(uid); // 获取当前登录用户信息
		}
		session.setAttribute("user", us);

		session.setAttribute("system", biz.Querysystem().get(0));
		if (us.getAuditStatus() == 2) { // 2：是商家
			mod.addAttribute("servicetype", biz.QueryservicetypeAll());
			oq = Number.OrderNumber(biz.queryOrders(us.getUserID(), null, null, 0));
			mod.addAttribute("num", oq);
		} else {
			path = "zxf//sjrz-yktsj";
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

	/**
	 * 商家入驻
	 * 
	 * @methodName: shrz
	 * @param user
	 * @param serviceID
	 * @param Img1
	 * @param Img2
	 * @param Img3
	 * @param Img4
	 * @param langs
	 * @param majors
	 * @return
	 * @throws Exception
	 *
	 */
	@PostMapping("shrz")
	public String shrz(User user, String serviceID, MultipartFile Img1, MultipartFile Img2, MultipartFile Img3,
			MultipartFile Img4, String[] langs, String[] majors) throws Exception {
		user.setAuditStatus(1); // 1待审核2已通过3拒绝
		user.setShopImg(shangchu(Img1));
		user.setIdentityPositiveImg(shangchu(Img2));
		user.setIdentityNegativeImg(shangchu(Img3));
		user.setIdentityHandImg(shangchu(Img4));
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
		if (langs != null) {
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

	/**
	 * 去收到的预定
	 * 
	 * @methodName: sddyd
	 * @param mod
	 * @param uid
	 * @param oidtxt
	 * @param p
	 * @param s
	 * @param orderID
	 * @return
	 *
	 */
	@RequestMapping("tosddyd")
	public String sddyd(Model mod, Integer uid, String oidtxt, Integer p, Integer s, String orderID, Integer stat) {
		if (p == null) {
			p = 1;
		}
		if (oidtxt == null) {
			oidtxt = "";
		} else {
			oidtxt = oidtxt.trim();
		}
		if (s == null) {
			s = 3;
		}
		if (stat == null) {
			stat = 0;
		}
		if (orderID != null) { // 查询单个订单详情
			mod.addAttribute("order", biz.queryOrders(uid, oidtxt, orderID, stat).get(0));
			return "zxf//sjrz-order-deatil";
		}
		System.out.println(oidtxt.equals("") && orderID == null && stat == 0);
		if (oidtxt.equals("") && orderID == null && stat == 0) { // 查询订单各种情况个数
			oq = Number.OrderNumber(biz.queryOrders(uid, null, null, 0));
		}
		mod.addAttribute("num", oq);
		mod.addAttribute("oidtxt", oidtxt);
		mod.addAttribute("stat", stat);
		mod.addAttribute("pageInfo", biz.queryOrders(uid, oidtxt, p, s, orderID, stat)); // 订单查询
		return "zxf//sjzx-order";
	}

	/**
	 * 查看发布的服务
	 * 
	 * @methodName: fbdfw
	 * @param mod
	 * @param uid
	 * @param p
	 * @param s
	 * @param title
	 * @param auditStatus
	 * @return
	 *
	 */
	@RequestMapping("tofbdfw")
	public String fbdfw(Model mod, Integer uid, Integer p, Integer s, String title, Integer auditStatus) {
		if (p == null) {
			p = 1;
		}
		if (s == null) {
			s = 3;
		}
		if (title == null) {
			title = "";
		} else {
			title = title.trim();
		}
		if (auditStatus == null) {
			auditStatus = 0;
		}
		mod.addAttribute("title", title);
		mod.addAttribute("auditStatus", auditStatus);
		mod.addAttribute("PAGE_INFO", biz.queryServices(uid, title, auditStatus, p, s));
		return "zxf//sjzx-services";
	}

	/**
	 * 去发布服务
	 * 
	 * @methodName: tofbfw
	 * @param sid
	 * @param mod
	 * @return
	 *
	 */
	@RequestMapping("tofbfw")
	public String tofbfw(String sid, Model mod) {
		String path = "";
		Integer stid = Integer.parseInt(sid.trim());
		switch (stid) {
		case 1:
			path = "zxf/sjzx-zjyfbfw";
			break;
		case 2:
			path = "zxf/sjzx-wzxfb";
			break;
		case 3:
			path = "zxf/sjzx-fbfw";
			break;
		case 4:
			path = "zxf/sjzx-hwfyfb";
			break;
		case 5:
			path = "zxf/sjzx-xxzyfb";
			break;
		default:
			break;
		}
		mod.addAttribute("typelist", biz.queryservicetypebystpid(stid));
		return path;
	}

	/**
	 * 发布服务
	 * 
	 * @methodName: fbfw
	 * @param session
	 * @return
	 *
	 */
	@PostMapping("fbfw")
	public String fbfw(HttpSession session, Services service, MultipartFile serviceCoverImg1,
			MultipartFile serviceImgUrlOne1, MultipartFile serviceImgUrlTwo1, MultipartFile serviceImgUrlThree1,
			MultipartFile serviceImgUrlFour1, MultipartFile uploadDataUrl1, String[] areaids,
			String[] serviceCostInclude1) throws Exception {
		service.setUploadDataUrl(shangchu(uploadDataUrl1));
		service.setServiceCoverImg(shangchu(serviceCoverImg1));
		service.setServiceImgUrlOne(shangchu(serviceImgUrlOne1));
		service.setServiceImgUrlTwo(shangchu(serviceImgUrlTwo1));
		service.setServiceImgUrlThree(shangchu(serviceImgUrlThree1));
		service.setServiceImgUrlFour(shangchu(serviceImgUrlFour1));
		service.setServiceCity(Stringappend(areaids));
		service.setServiceCostInclude(Stringappend(serviceCostInclude1));
		System.out.println(service);
		if (biz.addservices(service) > 0) {
			System.out.println("服务发布成功");
		}
		return "redirect:/zxf/mvc/tofbdfw?uid=" + ((User) session.getAttribute("user")).getUserID();
	}

	/**
	 * 图片上传
	 * 
	 * @methodName: shangchu
	 * @param multipartfile
	 * @return String
	 * @throws Exception
	 *
	 */
	public String shangchu(MultipartFile multipartfile) throws Exception {
		String name = null;
		if (multipartfile != null && !"".equals(multipartfile.getOriginalFilename())) {
			name = File.separator + multipartfile.getOriginalFilename();
			multipartfile.transferTo(new File("D:\\img" + name));
		}
		System.out.println(name);
		return name;
	}

	/**
	 * 数组拼接成字符串
	 * 
	 * @methodName: Stringappend
	 * @param strings
	 * @return
	 *
	 */
	public String Stringappend(String[] strings) {
		StringBuffer sb = new StringBuffer();
		if (strings != null && strings.length > 0) {
			for (int i = 0; i < strings.length; i++) {
				if (strings[i] != null && !"".equals(strings[i].trim())) {
					if (i != 0) {
						sb.append(",");
					}
					sb.append(strings[i]);
				}
			}
			return sb.toString();
		}
		return null;
	}

	/**
	 * 去商家退款
	 * 
	 * @methodName: tosjtk
	 * @return
	 *
	 */
	@RequestMapping("tosjtk")
	public String tosjtk(Model mod, Integer uid, Integer p, Integer s) {
		if (p == null) {
			p = 1;
		}
		if (s == null) {
			s = 3;
		}
		mod.addAttribute("pageInfo", biz.queryrefund(uid, p, s));
		return "zxf/sjzx-refund";
	}

	/**
	 * 去商家退款详情
	 * 
	 * @methodName: tosjtk
	 * @param mod
	 * @param refundID
	 * @return
	 *
	 */
	@RequestMapping("tosjtkxq")
	public String tosjtk(Model mod, Integer refundID) {
		mod.addAttribute("refund", biz.queryrefundbyid(refundID));
		return "zxf/sjzx-refund-detail";
	}
   
	/**
	 * 去商家不同意退款备注页面
	 * 
	 * @methodName: tosjtk
	 * @param mod
	 * @param refundID
	 * @return
	 *
	 */
	@RequestMapping("tosjtkbty")
	public String tosjtkbty(Model mod, Integer refundID) {
		 mod.addAttribute("rid", refundID);
		return "zxf/sjzx-refund-why";
	}
	/**
	 * 拒绝退款
	 * @methodName: refundno
	 * @param refundID
	 * @return
	 *
	 */
	@PostMapping("refundno")
	public String refundno(Integer refundID,String businessremarks,HttpSession session) {
		RefundListVo rv = biz.queryrefundbyid(refundID);
		biz.ordersrefundstatusupdate(rv,businessremarks);
		return "redirect:/zxf/mvc/tosjtk?uid=" + ((User) session.getAttribute("user")).getUserID();
	}
	/**
	 * 去我提交的鉴定
	 * 
	 * @methodName: tosjjd
	 * @return
	 *
	 */
	@RequestMapping("tosjjd")
	public String tosjjd(Model mod) {

		return "zxf/sjzx-auth";
	}

}
