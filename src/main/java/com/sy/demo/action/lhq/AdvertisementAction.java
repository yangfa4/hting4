package com.sy.demo.action.lhq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import com.sy.demo.biz.lhq.AdvertisementBiz;
import com.sy.demo.pojo.Post;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.lhq.AdvertisementVO;
import com.sy.demo.vo.lhq.HomePostVO;


@Controller
@RequestMapping("/lhq/api")
public class AdvertisementAction {
	
	@Autowired
	private AdvertisementBiz advertiseBiz;
	
	@GetMapping("oks")
	public String dd() {
		return "lhq/ok";
	}
	
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
		List<User> recommendStidByTwoList = advertiseBiz.queryRecommendUser(2);//微整形
		List<User> recommendStidByThreeList = advertiseBiz.queryRecommendUser(3);//留学中介
		List<User> recommendStidByFourList = advertiseBiz.queryRecommendUser(4);//韩语翻译
		List<User> recommendStidByFiveList = advertiseBiz.queryRecommendUser(5);//学习资源
		//首页帖子
		List<HomePostVO> homePostVOList=advertiseBiz.queryHomePostVO();
		
		//美妆版块帖子
		List<Post> homePostMakeUpList=advertiseBiz.queryHomePostByMakeup();
		System.out.println("输出listVo"+listVo);
		System.out.println("输出recommendStidByOneList"+recommendStidByOneList);
		System.out.println("输出homePostVOList"+homePostVOList);
		System.out.println("输出homePostMakeUpList"+homePostMakeUpList);
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
	
	
}
