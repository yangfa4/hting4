package com.sy.demo.vo.zsm;

import java.util.List;

import com.sy.demo.pojo.Merchantcollection;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;

public class MerchantcollectionVo {

    private Merchantcollection merchantcollection;//收藏信息
    
    private List<Services> services;//关于收藏商家服务
    
    private User user;//商家

	public Merchantcollection getMerchantcollection() {
		return merchantcollection;
	}

	public void setMerchantcollection(Merchantcollection merchantcollection) {
		this.merchantcollection = merchantcollection;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MerchantcollectionVo(Merchantcollection merchantcollection, List<Services> services, User user) {
		super();
		this.merchantcollection = merchantcollection;
		this.services = services;
		this.user = user;
	}

	public MerchantcollectionVo() {
		super();
	}

	@Override
	public String toString() {
		return "MerchantcollectionVo [merchantcollection=" + merchantcollection + ", services=" + services + ", user="
				+ user + "]";
	}
    
	

	
}
