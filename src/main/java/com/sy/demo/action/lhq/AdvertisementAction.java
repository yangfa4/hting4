package com.sy.demo.action.lhq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sy.demo.util.Upload;
import com.sy.demo.biz.lhq.AdvertisementBiz;
import com.sy.demo.pojo.Advertisement;
import com.sy.demo.pojo.Advertisementapply;
import com.sy.demo.pojo.Post;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.lhq.AdvertisementVO;
import com.sy.demo.vo.lhq.HomePostVO;


@Controller
@RequestMapping("/lhq/api")
public class AdvertisementAction {
	
	@Autowired
	private AdvertisementBiz advertiseBiz;
	
	
	/**
	 * MVC:首页地址
	 * @param model
	 * @return
	 */
	@GetMapping("homeUrl")
	public String queryHome(Model model) {
		//1.首页轮播图,2.首页社区服务中间广告位查询,3.首页社区上方左右广告位查询
		//4.首页社区下方广告位查询
		List<AdvertisementVO> listVo=advertiseBiz.queryByAtid(1);
		
	    List<AdvertisementVO> homeSlideshowList =listVo;
	    for (AdvertisementVO advertisementVO : homeSlideshowList) {
			System.out.println("输出AappUrl："+advertisementVO.getAimgPath());
		}
		//首页社区服务中间广告位查询
		List<AdvertisementVO> homeMidAdvertingList=advertiseBiz.queryByAtid(2);
		//首页社区上方左右广告位查询
		List<AdvertisementVO> homeTopAdvertingList=advertiseBiz.queryByAtid(3);
		//首页社区下方广告位查询
		List<AdvertisementVO> homeBottomAdvertingList=advertiseBiz.queryByAtid(4);
		
		//星级商家
		List<User> user=advertiseBiz.queryRecommendUser(1);
		List<User> recommendStidByOneList = advertiseBiz.queryRecommendUser(1);//自驾游
		for (User user2 : recommendStidByOneList) {
			System.out.println("输出星级"+user2.getMerchantLevel());
		}
		List<User> recommendStidByTwoList = advertiseBiz.queryRecommendUser(2);//微整形
		List<User> recommendStidByThreeList = advertiseBiz.queryRecommendUser(3);//留学中介
		List<User> recommendStidByFourList = advertiseBiz.queryRecommendUser(4);//韩语翻译
		List<User> recommendStidByFiveList = advertiseBiz.queryRecommendUser(5);//学习资源
		//首页帖子
		List<HomePostVO> homePostVOList=advertiseBiz.queryHomePostVO();
		for (HomePostVO homePostVO : homePostVOList) {
			System.out.println("输出帖子"+homePostVO.getReplyUserName());
		}
		//美妆版块帖子
		List<Post> homePostMakeUpList=advertiseBiz.queryHomePostByMakeup();
		
		for (Post post : homePostMakeUpList) {
			System.out.println("输出美妆版块帖子"+post.getCoverPath());
		}
		System.out.println("输出recommendStidByOneList"+recommendStidByOneList);
		/*System.out.println("输出homePostVOList"+homePostVOList);
		System.out.println("输出homePostMakeUpList"+homePostMakeUpList);*/
		model.addAttribute("homeSlideshowList",homeSlideshowList);
		model.addAttribute("homeMidAdvertingList",homeMidAdvertingList);
		model.addAttribute("recommendStidByOneList",recommendStidByOneList);
		model.addAttribute("recommendStidByTwoList",recommendStidByTwoList);
		model.addAttribute("recommendStidByThreeList",recommendStidByThreeList);
		model.addAttribute("recommendStidByFourList",recommendStidByFourList);
		model.addAttribute("recommendStidByFiveList",recommendStidByFiveList);
		model.addAttribute("homePostVOList",homePostVOList);
		model.addAttribute("homePostMakeUpList",homePostMakeUpList);
		model.addAttribute("homeTopAdvertingList",homeTopAdvertingList);
		model.addAttribute("homeBottomAdvertingList",homeBottomAdvertingList);
		return "lhq/fw-sy";		
	}
	
	@GetMapping("homeUrlOrder")
	public String queryHomeOrder(Model model) {
		//1.首页轮播图,2.首页社区服务中间广告位查询,3.首页社区上方左右广告位查询
		//4.首页社区下方广告位查询
		List<AdvertisementVO> listVo=advertiseBiz.queryByAtid(1);
		
	    List<AdvertisementVO> homeSlideshowList =listVo;
	    for (AdvertisementVO advertisementVO : homeSlideshowList) {
			System.out.println("输出AappUrl："+advertisementVO.getAimgPath());
		}
		//首页社区服务中间广告位查询
		List<AdvertisementVO> homeMidAdvertingList=advertiseBiz.queryByAtid(2);
		//首页社区上方左右广告位查询
		List<AdvertisementVO> homeTopAdvertingList=advertiseBiz.queryByAtid(3);
		//首页社区下方广告位查询
		List<AdvertisementVO> homeBottomAdvertingList=advertiseBiz.queryByAtid(4);
		
		//星级广告位
		List<Advertisement> advert=advertiseBiz.findByAtid();
		List<Advertisement> recommendStidByOneList=new ArrayList<Advertisement>();
		List<Advertisement> recommendStidByTwoList=new ArrayList<Advertisement>();
		List<Advertisement> recommendStidByThreeList=new ArrayList<Advertisement>();
		List<Advertisement> recommendStidByFourList=new ArrayList<Advertisement>();
		List<Advertisement> recommendStidByFiveList=new ArrayList<Advertisement>();
		for (Advertisement advertisement : advert) {
			if(advertisement.getAtid()==16) {
				recommendStidByOneList.add(advertisement);//自驾游
			}else if(advertisement.getAtid()==17) {
				recommendStidByTwoList.add(advertisement);//微整形
			}else if(advertisement.getAtid()==18) {
				recommendStidByThreeList.add(advertisement);//留学中介
			}else if(advertisement.getAtid()==19) {
				recommendStidByFourList.add(advertisement);//韩语翻译
			}else if(advertisement.getAtid()==20) {
				recommendStidByFiveList.add(advertisement);//学习资源
			}
		}
		
		//首页帖子
		List<HomePostVO> homePostVOList=advertiseBiz.queryHomePostVO();
		for (HomePostVO homePostVO : homePostVOList) {
			System.out.println("输出帖子"+homePostVO.getReplyUserName());
		}
		//美妆版块帖子
		List<Post> homePostMakeUpList=advertiseBiz.queryHomePostByMakeup();
	
		
		
		System.out.println("输出recommendStidByOneList"+advert);
		
		model.addAttribute("homeSlideshowList",homeSlideshowList);
		model.addAttribute("homeMidAdvertingList",homeMidAdvertingList);
	    model.addAttribute("recommendStidByOneList",recommendStidByOneList);
		model.addAttribute("recommendStidByTwoList",recommendStidByTwoList);
		model.addAttribute("recommendStidByThreeList",recommendStidByThreeList);
		model.addAttribute("recommendStidByFourList",recommendStidByFourList);
		model.addAttribute("recommendStidByFiveList",recommendStidByFiveList);
		model.addAttribute("homePostVOList",homePostVOList);
		model.addAttribute("homePostMakeUpList",homePostMakeUpList);
		model.addAttribute("homeTopAdvertingList",homeTopAdvertingList);
		model.addAttribute("homeBottomAdvertingList",homeBottomAdvertingList);
		return "lhq/orderAdvertise";		
	}
	
	@GetMapping("orderAdvertise")
	public String orderAdvertise() {
		System.out.println("进入修改");
		return  "lhq/advertiseapply";
	}
	
	@PostMapping("addAdvertisementApply")
	public String merchantMove(HttpSession session,String aimgPath) {
		System.out.println("申请");
		try {
			//String showimgPath = Upload.uploadFile(aimgPath);
			System.out.println("图片路径"+aimgPath);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//User loginUser = (User)session.getAttribute("USER");	//登录用户
		/*float bond = biz.queryBond();	//入驻缴纳保证金金额要求
		if(loginUser.getUsermoney()>=bond) {	//如果当前登录用户的金额足够缴纳保证金
			if(serviceID.split(",").length==2) {	//如果用户选择的服务类别为两个
				user.setFirstserviceid(Integer.parseInt(serviceID.split(",")[0]));
				user.setSecondserviceid(Integer.parseInt(serviceID.split(",")[1]));	
			}else {
				user.setFirstserviceid(Integer.parseInt(serviceID));
			}
			try {
				String shopimgDataFName = Upload.uploadFile(shopimgData);
				String identitypositiveimgDataFName = Upload.uploadFile(identitypositiveimgData);
				String identitynegativeimgDataFName = Upload.uploadFile(identitynegativeimgData);
				String identityhandimgDataFName = Upload.uploadFile(identityhandimgData);
				user.setShopimg(shopimgDataFName);	//设置数据库存储图片路径
				user.setIdentitypositiveimg(identitypositiveimgDataFName);
				user.setIdentitynegativeimg(identitynegativeimgDataFName);
				user.setIdentityhandimg(identityhandimgDataFName);
				user.setUserid(loginUser.getUserid());//当前登录用户编号赋给修改对象
			} catch (IllegalStateException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(biz.merchantMove(user,bond)>0) {//商家入驻受影响行数
				biz.saveGoldNotes(loginUser.getUserid(), 4, "商家入驻缴纳保证金",-bond , 2);	//添加金币流向记录
				szyUserBiz.saveXtxx(loginUser.getUserid(), "您好，您已成功提交商家入驻的申请，请等待管理员审核。");
				return "redirect:/sjrz-shzl.html";
			}else {
				return "redirect:/Public/error/500.html";
			}
		}else {
			return "redirect:/Public/error/500.html";
		}*/
		return null;
	}
	
}
