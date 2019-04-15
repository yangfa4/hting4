package com.sy.demo.vo.zsm;

public class serviceVo {

	private Integer serColleID;
	private String serviceTitle;
	private String serviceFuTitle;
	private Integer servicePrice;
	private Integer creditScore;
	private String serviceCoverImg;
	private String userName;
	public Integer getSerColleID() {
		return serColleID;
	}
	public void setSerColleID(Integer serColleID) {
		this.serColleID = serColleID;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceFuTitle() {
		return serviceFuTitle;
	}
	public void setServiceFuTitle(String serviceFuTitle) {
		this.serviceFuTitle = serviceFuTitle;
	}
	public Integer getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}
	public Integer getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public serviceVo(Integer serColleID, String serviceTitle, String serviceFuTitle, Integer servicePrice,
			Integer creditScore, String serviceCoverImg, String userName) {
		super();
		this.serColleID = serColleID;
		this.serviceTitle = serviceTitle;
		this.serviceFuTitle = serviceFuTitle;
		this.servicePrice = servicePrice;
		this.creditScore = creditScore;
		this.serviceCoverImg = serviceCoverImg;
		this.userName = userName;
	}
	public serviceVo() {
		super();
	}
	@Override
	public String toString() {
		return "serviceVo [serColleID=" + serColleID + ", serviceTitle=" + serviceTitle + ", serviceFuTitle="
				+ serviceFuTitle + ", servicePrice=" + servicePrice + ", creditScore=" + creditScore
				+ ", serviceCoverImg=" + serviceCoverImg + ", userName=" + userName + "]";
	}
}
