package com.sy.demo.action.zsm;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sy.demo.biz.zsm.zsmOrdersBiz;
import com.sy.demo.pojo.Integralrecord;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Refund;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zsm.OrdersVo;

@Controller
@RequestMapping("/grzx")
public class zsmGrzxAction {

	@Autowired
	private zsmOrdersBiz biz;
	/**
	 * 查询所有订单
	 * @param model
	 * @param userID
	 * @param orderStatus
	 * @param orderID
	 * @param commentstatus
	 * @return
	 */
	@RequestMapping("/ordersAll")
	public String Gotogrzx(Model model,Integer userID,Integer orderStatus,String orderID,Integer commentstatus,HttpSession session) {
	  User user=(User) session.getAttribute("USER");
	   model.addAttribute("order",biz.SelectOrders(user.getUserID(), orderStatus, orderID,commentstatus));
	   model.addAttribute("dai",biz.findByInt(1, null, user.getUserID()));
	   model.addAttribute("jie",biz.findByInt(2, null, user.getUserID()));
	   model.addAttribute("ren",biz.findByInt(4, null, user.getUserID()));
	   model.addAttribute("ping",biz.findByInt(null, 1, user.getUserID()));
	    return "/zsm/grzx-order";
	}
	/**
	 * 查询订单详情
	 * @param model
	 * @param orderID
	 * @return
	 */
	@RequestMapping("/SelectOrdersOne/{orderID}")
	public String SelectOrdersOne(Model model,@PathVariable("orderID")String orderID) {
		model.addAttribute("order", biz.SelectOrdersOne(orderID));
		System.out.println(biz.SelectOrdersOne(orderID));
		return "/zsm/grzx-order-detail";
	}
	/**
	 * 点击个人中心第一个进入的页面
	 */
	@RequestMapping("/SelectByuser/{userID}")
	public String SelectByuser(Model model,@PathVariable("userID") Integer userID) {
		model.addAttribute("user",biz.SelectByuser(userID));
		  model.addAttribute("dai",biz.findByInt(1, null, userID));
		   model.addAttribute("jie",biz.findByInt(2, null, userID));
		   model.addAttribute("ren",biz.findByInt(4, null, userID));
		   model.addAttribute("ping",biz.findByInt(null, 1, userID));
		   model.addAttribute("orderAll", biz.Selectcrzxzuixing(userID));
		return "/zsm/grzx-index";
	}
	
	/**
	 * 用户签到得积分
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/qiangdao")
	@ResponseBody
	public Map<String,String>qiangdao(HttpSession session) throws Exception{
		User user=(User) session.getAttribute("USER");
		 Map<String, String>map=new HashMap<String,String>();
	 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String a=sdf.format(biz.Selectqd(user.getUserID()));
	    String b=sdf.format(new Date().getTime());
	     Date c= sdf.parse(a);
	     Date d= sdf.parse(b);
	      long time=(d.getTime()-c.getTime())/(3600*24*1000);
	     if(time>=1) {
	    	 biz.updateUserjf(user.getUserID());
	    	 biz.insertIntegralrecord(new Integralrecord(10, "签到", user.getUserID()));
	    	map.put("code", "200");
	     }else {
	    	 map.put("code", "300");
	     }
	     return map;
	}
	/**
	 * 窗体加载判断用户是否可以签到
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/lookqiangdao")
	@ResponseBody
	public Map<String,String>lookqiangdao(HttpSession session) throws Exception{
		 Map<String, String>map=new HashMap<String,String>();
		 User user=(User) session.getAttribute("USER");
	 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String a=sdf.format(biz.Selectqd(user.getUserID()));
	    String b=sdf.format(new Date().getTime());
	     Date c= sdf.parse(a);
	     Date d= sdf.parse(b);
	      long time=(d.getTime()-c.getTime())/(3600*24*1000);
	     if(time>=1) {
	    	map.put("code", "200");
	     }else {
	    	 map.put("code", "300");
	     }
	     return map;
	}
	/**
	 * 修改订单状态
	 * @param orderStatus
	 * @param orderID
	 * @return
	 */
	@PutMapping("/updateOrders/{orderStatus}/{orderID}")
	@ResponseBody
	public Map<String,String>updateOrders(@PathVariable Integer orderStatus,@PathVariable String orderID){
		Map<String,String>map=new HashMap<String,String>();
		System.out.println(orderStatus);
		System.out.println(orderID);
		biz.updateOrders(orderStatus, null, null, orderID);
		map.put("code", "200");
		return map;
	}
	/**
	 * 确认服务
	 * @param orderStatus
	 * @param orderID
	 * @return
	 */
	@PutMapping("/updateOrdersok/{orderStatus}/{orderID}/{commentstatus}")
	@ResponseBody
	public Map<String,String>updateOrdersok(@PathVariable Integer orderStatus,@PathVariable String orderID,@PathVariable Integer commentstatus){
		Map<String,String>map=new HashMap<String,String>();
		System.out.println(orderStatus);
		System.out.println(orderID);
		biz.updateOrders(orderStatus, commentstatus, null, orderID);
		map.put("code", "200");
		return map;
	}
	/**
	 *购买商品进入支付页面判断金币是否足够
	 * @param model
	 * @param orderID
	 * @return
	 */
	@RequestMapping("/selectUserOrderjb/{orderID}")
	public String selectUserOrderjb(Model model,@PathVariable String orderID,HttpSession session) {
	
		User user=(User) session.getAttribute("USER");
		System.out.println(biz.SelectByuser(user.getUserID()));
		System.out.println(biz.selectByuserOr(orderID));
	     model.addAttribute("user",biz.SelectByuser(user.getUserID()));
	     model.addAttribute("order",biz.selectByuserOr(orderID));
		return "/zsm/grzx-order-pay";
	}
	/**
	 * 支付订单，记录订单，修改用户金币
	 * @param model
	 * @param orderid
	 * @param money
	 * @return
	 */
	@RequestMapping("/orderMoney/{orderid}/{money}")
	public String orderMoney(Model model,@PathVariable String orderid,@PathVariable String money,HttpSession session) {
		User user=(User) session.getAttribute("USER");
		biz.insertGoldnotes(user.getUserID(),"支付订单："+orderid,"-"+money);
		biz.updateUserMoney(user.getUserID(),money);
		biz.updateOredrsBymoney(orderid);
		return "redirect:/grzx/ordersAll";
	}
	/**
	 * 评价查看详情
	 * @param model
	 * @param orderID
	 * @return
	 */
	@RequestMapping("/SelectpjOne/{orderID}")
	public String SelectpjOne(Model model,@PathVariable("orderID")String orderID) {
		model.addAttribute("order", biz.SelectOrdersOne(orderID));
		System.out.println(biz.SelectOrdersOne(orderID));
		return "/zsm/grzx-order-evaluate";
	}
	/**
	 * 用户评价商品
	 * @param model
	 * @param orderid
	 * @param serviceappraisecontent
	 * @param serviceappraiselevel
	 * @param serviceID
	 * @return
	 */
	@PostMapping("/insertPinglun")
	public String insertPinglun(Model model,@RequestParam(value="orderid") String orderid,HttpSession session,@RequestParam(value="serviceappraisecontent") String serviceappraisecontent,@RequestParam(value="serviceappraiselevel") Integer serviceappraiselevel,@RequestParam(value="serviceID") Integer serviceID) {
		biz.updatepinglun(orderid);
		User user=(User) session.getAttribute("USER");
		biz.insertEvaluationService(serviceID, user.getUserID(), serviceappraisecontent, serviceappraiselevel);
		return "redirect:/grzx/ordersAll";
	}
	/**
	 * 退款订单详情
	 * @param model
	 * @param orderID
	 * @return
	 */
	@RequestMapping("/SelectRefundandOrder/{orderID}")
	public String SelectRefundandOrder(Model model,@PathVariable String orderID) {
		Orders a=biz.selectTuikuanxq(orderID);
		Refund b=biz.selectRefund(orderID);
		User c=biz.SelectTkuser(a.getUserID());
		Services d=biz.SelectTkService(a.getServiceID());
		User e=biz.SelectTkshangjia(d.getUserID());
		System.out.println(b.getRefundID());
		model.addAttribute("order", a);
		model.addAttribute("refund", b);
		model.addAttribute("tkuser",c);
		model.addAttribute("sjuser", e);
		model.addAttribute("service", d);
		return "/zsm/grzx-refund-detail";
	}
	/**
	 * 查询退款所需条件
	 * @param model
	 * @param orderID
	 * @return
	 */
	@RequestMapping("/SelectRefundti/{orderID}")
	public String SelectRefundti(Model model,@PathVariable String orderID) {
	    model.addAttribute("o", biz.SelectServoceVo(orderID));
		return "/zsm/grzx-order-refund";
	}
	/**
	 * 申请退款
	 * @param orderID
	 * @param refundReason
	 * @param refundExplain
	 * @param refundImg
	 * @param applyRefundMoney
	 * @return
	 * @throws Exception
	 */
	@PostMapping("insertRefund")
	public String insertRefund(@RequestParam(value="orderID") String orderID,@RequestParam(value="refundReason") String refundReason,@RequestParam(value="refundExplain") String refundExplain,@RequestParam(value="refundImg") MultipartFile refundImg,HttpSession session,@RequestParam(value="applyRefundMoney") Integer applyRefundMoney) throws Exception{
		String fileName3 = refundImg.getOriginalFilename();
		refundImg.transferTo(new File("D:\\img"+File.separator + fileName3));
		User user=(User) session.getAttribute("USER");
		biz.insertRefund(1, orderID, user.getUserID(), refundReason, refundExplain, "/" + fileName3, applyRefundMoney, 1);;
		biz.updateOrders(null, null, 1, orderID);
		return "redirect:/grzx/ordersAll";
	}
	@RequestMapping("updateGuanli/{orderID}")
	public String updateGuanli(@PathVariable String orderID) {
		biz.updateOrders(null, null, 3, orderID);
		return "redirect:/grzx/ordersAll";
	}
}
