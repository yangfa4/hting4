package com.sy.demo.vo.zxf;

import java.util.List;

import com.sy.demo.pojo.Servicetype;

public class ServiceTypeVo extends Servicetype {

	private List<Servicetype> servicetypelist;

	public List<Servicetype> getServicetypelist() {
		return servicetypelist;
	}

	public void setServicetypelist(List<Servicetype> servicetypelist) {
		this.servicetypelist = servicetypelist;
	}

	public ServiceTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
