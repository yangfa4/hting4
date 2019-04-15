package com.sy.demo.action.zsm;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.zsm.zsmMoneyBiz;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zsm.moneyVo;

@Controller
@RequestMapping("/money")
public class zsmMoneyAction {

	@Autowired
	private zsmMoneyBiz biz;
	/**
	 * 查询用户金币交易记录并进行分页
	 * @param model
	 * @param pageSize
	 * @param pageNum
	 * @param acquisitionMode
	 * @return
	 */
	@GetMapping("/semoney")
	public String Selectmoney(Model model,Integer pageSize,Integer pageNum,Integer acquisitionMode,HttpSession session){   
		if (pageNum == null)pageNum = 1;
		if (pageSize == null)pageSize = 6;
		User user=(User) session.getAttribute("USER");
		PageInfo<moneyVo> pageInfo =biz.SelectMoney(user.getUserID(),acquisitionMode, pageSize, pageNum);
		model.addAttribute("PAGE_INFO", pageInfo);
		model.addAttribute("user",biz.SelectUser(user.getUserID()));
		return "zsm/grzx-moneys";
	}
	@GetMapping("/Banktype")
	public String SelectBanktype(Model model,HttpSession session) {
		model.addAttribute("banktype", biz.SelectByBank());
		User user=(User) session.getAttribute("USER");
		model.addAttribute("user", biz.SelectUser(user.getUserID()));
		return "zsm/jinb-tixt";
	}
	/**
	 * 新增交易金币交易记录
	 * @return
	 */
	@PostMapping("/insertjbjiaoyijilu")
	public String insertjbjiaoyijilu(String putName,Integer bankID,String bankAccount,String openBankName,Integer money,HttpSession session) {
		User user=(User) session.getAttribute("USER");
		biz.insertGoldnotes(user.getUserID(), "金币提现", "-"+money);
		biz.insertPutforward(user.getUserID(), putName, bankID, bankAccount, openBankName, money);
		biz.insertPutforwardRecord(25, bankAccount, bankID, money);
		return "redirect:/money/semoney";
	}
	
}
