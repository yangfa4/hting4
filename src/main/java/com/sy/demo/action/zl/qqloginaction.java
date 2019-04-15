package com.sy.demo.action.zl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.demo.biz.zl.LogInBiz;

@Controller
@RequestMapping("/qq")
public class qqloginaction {
	@Autowired
	 private LogInBiz biz;
	@GetMapping("/login")
	@ResponseBody
	public Map<String, String> MailboxValidation(String mail)throws Exception {
		Map<String, String> message=new HashMap<String,String>();
//int emp=biz.MailboxValidation(mail);
		int emp=1;
		if (emp!=0) {
			message.put("code", "500");
			message.put("msg", "ok");
		}else {
			message.put("code", "200");
			message.put("msg", "ok");
			
		}
			return message;
	}
}
