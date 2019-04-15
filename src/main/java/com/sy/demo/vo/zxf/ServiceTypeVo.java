package com.sy.demo.vo.zxf;

import java.util.List;

import com.sy.demo.pojo.Servicetype;

public class ServiceTypeVo {

	private Integer stPid;// 递归编号(父ID)

	private Integer proportion;// 违约金比例

	private Integer toExamine;// 是否审核（1未审核2审核）

	private Integer display;// 是否显示(1不显示，2显示

	private String stName;// 服务名称

	private String advertisement;// 广告图片地址

	private Integer stid;// 服务类别id，主键

	private Integer confirmTime;// 自动确认时间

	private Integer sort;// 排序(层次作用 默认0 0是一级服务 以此类推)

	private Integer operationTime;// 未操作时间

	private Integer violatedNumber;// 服务违约天数

	private List<Servicetype> servicetypelist;

	public Integer getStPid() {
		return stPid;
	}

	public void setStPid(Integer stPid) {
		this.stPid = stPid;
	}

	public Integer getProportion() {
		return proportion;
	}

	public void setProportion(Integer proportion) {
		this.proportion = proportion;
	}

	public Integer getToExamine() {
		return toExamine;
	}

	public void setToExamine(Integer toExamine) {
		this.toExamine = toExamine;
	}

	public Integer getDisplay() {
		return display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	public Integer getStid() {
		return stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public Integer getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Integer confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Integer operationTime) {
		this.operationTime = operationTime;
	}

	public Integer getViolatedNumber() {
		return violatedNumber;
	}

	public void setViolatedNumber(Integer violatedNumber) {
		this.violatedNumber = violatedNumber;
	}

	public List<Servicetype> getServicetypelist() {
		return servicetypelist;
	}

	public void setServicetypelist(List<Servicetype> servicetypelist) {
		this.servicetypelist = servicetypelist;
	}

	@Override
	public String toString() {
		return "ServiceTypeVo [stPid=" + stPid + ", proportion=" + proportion + ", toExamine=" + toExamine
				+ ", display=" + display + ", stName=" + stName + ", advertisement=" + advertisement + ", stid=" + stid
				+ ", confirmTime=" + confirmTime + ", sort=" + sort + ", operationTime=" + operationTime
				+ ", violatedNumber=" + violatedNumber + ", servicetypelist=" + servicetypelist + "]";
	}

	public ServiceTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
