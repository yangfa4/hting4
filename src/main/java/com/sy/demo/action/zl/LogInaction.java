package com.sy.demo.action.zl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.demo.biz.zl.LogInBiz;
import com.sy.demo.pojo.Admin;
import com.sy.demo.pojo.Login;
import com.sy.demo.pojo.User;
import com.sy.demo.util.mail;

@Controller
@RequestMapping("/lz")
public class LogInaction {
	@Autowired
	 private LogInBiz biz;
	
	@RequestMapping("/register")
	public String saveuser(String email,String username)throws Exception {
//		Map<String, String> message=new HashMap<String,String>();
//		User user =new User();
//		Login login=new Login();
//		user.setUserRealName(username);
//		login.setUserEmail(email);
		
		//String md5Password = DigestUtils.md5DigestAsHex(pwd.getBytes());
	//	biz.LogInBiz(user,login);
		//发送验证邮件
	mail sendmail=new mail();
	sendmail.SendMail(email,username);
	
			return "zl/ok";//模板文件名
	}
	@RequestMapping("/registerss")
	public String logincg(String email,String username,String password)throws Exception {
//		Map<String, String> message=new HashMap<String,String>();
		User user =new User();
		Login login=new Login();
		System.out.println(username);
		user.setUserRealName(username);
		
			login.setUserPwd(password);
		login.setUserEmail(email);
		biz.LogInBiz(user,login);
			return "zl/ok";//模板文件名
	}
	@GetMapping("/MailboxValidation")
	@ResponseBody
	public Map<String, String> MailboxValidation(String mail)throws Exception {
		Map<String, String> message=new HashMap<String,String>();
		int emp=biz.MailboxValidation(mail);
		if (emp!=0) {
			message.put("code", "500");
			message.put("msg", "ok");
		}else {
			message.put("code", "200");
			message.put("msg", "ok");
			
		}
			return message;
	}
	
	/**
	 * 登录
	 * 获取session
	 * @param password
	 * @param email
	 * @return
	 */
	@GetMapping("/signin")
	@ResponseBody
	public Map<String, String> SignInDao(String email,String password,HttpSession session)throws Exception {
		System.out.println(email+password);
		Map<String, String> message=new HashMap<String,String>();
		Login login=new Login();
		login.setUserEmail(email);
		login.setUserPwd(password);
		Login loginuser =biz.LoginDao(login);
		
		if (loginuser==null) {
			message.put("code", "500");
			message.put("msg", "ok");
		}else {
			User use=biz.SignInDao(loginuser.getUserID());
			session.setAttribute("USER", use);
			 if(use.getMailboxVerification()==0){
				message.put("code", "250");
				message.put("msg", "ok");
				
			}else {
				message.put("code", "200");
				message.put("msg", "ok");
			}
			
		}
				return message;
	}
	/**
	 * 激活邮箱
	 * @param model
	 * @param email
	 * @param nickName
	 * @param codeId
	 * @return
	 */
	@RequestMapping(value="/ActivateMailbox",method=RequestMethod.GET)
	public String emailYanz(Model model,String email,String nickName) {
		System.out.println(email+nickName);
		User user=new User();
		user.setMerchantEmail(email);
		user.setUserName(nickName);
				model.addAttribute("user",user);
				return "zl/zhuce";
		
	}
	
	
}
