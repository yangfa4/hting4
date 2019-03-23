package com.sy.demo.action.zxf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.demo.biz.zxf.ZXF_shopbiz;

@RestController
@RequestMapping("/zxf/api")
public class ZXF_action_api {

	@Autowired
	private ZXF_shopbiz biz;

	

}
