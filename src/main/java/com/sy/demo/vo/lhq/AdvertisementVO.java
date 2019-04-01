package com.sy.demo.vo.lhq;

import java.util.Date;

import com.sy.demo.pojo.Advertisement;


public class AdvertisementVO{
	
	 private String adescribe;// 描述

	    private Integer atid;// 外键，广告位模块编号

	    private String apcUrl;// PC端链接路径

	    private String aimgPath;// 图片路径

	    private Float price;// 价格(单价/月)

	    private Integer aorder;// 排序

	    private Date startTime;// 开始时间

	    private Integer state;// 广告位状态(已租/未租)

	    private Integer rentAMonth;// 租的月数

	    private Integer aid;// 广告位id(前台模块放ID，匹配后台广告)，主键

	    private String atitle;// 标题

	    private String aappUrl;// 手机端链接路径

	private ImageWidthAndHeightVO imgsize;
	

	public String getAdescribe() {
		return adescribe;
	}

	public void setAdescribe(String adescribe) {
		this.adescribe = adescribe;
	}

	public Integer getAtid() {
		return atid;
	}

	public void setAtid(Integer atid) {
		this.atid = atid;
	}

	public String getApcUrl() {
		return apcUrl;
	}

	public void setApcUrl(String apcUrl) {
		this.apcUrl = apcUrl;
	}

	public String getAimgPath() {
		return aimgPath;
	}

	public void setAimgPath(String aimgPath) {
		this.aimgPath = aimgPath;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getAorder() {
		return aorder;
	}

	public void setAorder(Integer aorder) {
		this.aorder = aorder;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getRentAMonth() {
		return rentAMonth;
	}

	public void setRentAMonth(Integer rentAMonth) {
		this.rentAMonth = rentAMonth;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAappUrl() {
		return aappUrl;
	}

	public void setAappUrl(String aappUrl) {
		this.aappUrl = aappUrl;
	}

	public ImageWidthAndHeightVO getImgsize() {
		return imgsize;
	}

	public void setImgsize(ImageWidthAndHeightVO imgsize) {
		this.imgsize = imgsize;
	}

	@Override
	public String toString() {
		return "AdvertisementVO [adescribe=" + adescribe + ", atid=" + atid + ", apcUrl=" + apcUrl + ", aimgPath="
				+ aimgPath + ", price=" + price + ", aorder=" + aorder + ", startTime=" + startTime + ", state=" + state
				+ ", rentAMonth=" + rentAMonth + ", aid=" + aid + ", atitle=" + atitle + ", aappUrl=" + aappUrl + "]";
	}

	
	


	
}
