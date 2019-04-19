package com.sy.demo.vo.tjc;

import java.util.Date;

public class CollectVo {

    private Date collectionTime;// 收藏时间

    private Integer serColleID;// 服务收藏(商品收藏)id，主键

    private Integer serviceID;// 外键，服务编号(商品表)

    private Integer userID;// 外键，用户编号

    private Integer country;// 外键，国家编号

    private String serviceCoverImg;// 封面图

    private Date releaseTime;// 发布时间

    private String serviceCity;// 服务城市(可填多个)

    private Integer browseNumber;// 浏览数

    private Integer stid;// 服务类别编号，外键

    private String serviceIntro;// 服务介绍

    private String majoyNameByCN;// 学科-中文-专业

    private String adminOpinion;// 管理员意见

    private String serviceImgUrlThree;// 细节图3

    private String serviceImgUrlTwo;// 细节图2

    private String serviceCostTypeID;// 费用说明

    private Date serviceEndDate;// 可预定日期-结束

    private String goodAtMajoy;// 擅长专业

    private Integer shelfState;// 上架状态(1上架2下架)

    private String schoolNameByCN;// 学科-中文-学校

    private Integer recommendBool;// 服务推荐

    private Integer resourceID;// 资源类别编号

    private String majoyNameByROK;// 学科-韩文-专业

    private String serviceFuTitle;// 服务副标题

    private Float weight;// 重量

    private String hospitalName;// 医院名称

    private String uploadDataUrl;// 上传资料

    private Integer serviceHour;// 小时/天

    private Date serviceStartDate;// 可预定日期-起始

    private String serviceTitle;// 服务标题

    private Integer servicePrice;// 金币价格

    private String downloadTitle;// 下载标题

    private String serviceImgUrlFour;// 细节图4

    private String serviceImgUrlOne;// 细节图1

    private String schoolRegion;// 学校地区

    private Integer auditStatus;// 审核状态(1待审核2审核成功3未通过)

    private String schoolNameByROK;// 学科-韩文-学校

    private String serviceCostInclude;// 服务费用包含

    private Integer trusteeship;// 托管状态 0:未托管，1：托管

    private String reason;// 管理员理由

    private Integer stateboolean;// 用户状态(可禁用用户1正常0禁用)

    private String registerIP;// 注册IP地址

    private Integer mailboxVerification;// 邮箱验证/邮箱激活(0激活1未激活)

    private String userPhone;// 联系电话

    private Float userMoney;// 用户金币

    private Integer merchantExp;// 商家经验值，用来提升星级

    private Integer experience;// 免费体验月数

    private String identityPositiveImg;// 证件正面图片路径

    private Date userRegistrationTime;// 用户注册时间

    private String constellation;// 星座

    private Integer provincialID;// 外键，省级地址编号

    private Integer authenticationer;// 二号服务平台认证(0认证1未认证)

    private String majorNameText;// 擅长专业

    private Float height;// 身高

    private String qq;// QQ

    private String profession;// 职业

    private Integer userSex;// 用户性别，1：男，2：女

    private Integer userIntegral;// 用户积分

    private Float firstServiceMoney;// 第一个服务交易额

    private Integer creditScore;// 信誉积分(默认60/满分100 20为1颗星)

    private String merchantEmail;// 商家联系邮箱

    private Date recentEntry;// 用户最后登入时间

    private Integer cityID;// 外键，市级地址编号

    private Date trusteeshipStartTime;// 托管开始时间

    private Integer guaranteeMoney;// 店铺保证金

    private String merchantPhone;// 商家联系电话

    private Date auditTime;// 审核时间

    private Integer countyID;// 外键，县/区级地址编号

    private String adDetail;// 地址详情

    private String signature;// 店铺签名

    private String userRealName;// 用户真实姓名

    private String shopName;// 店铺名称

    private Float secondServiceMoney;// 第二个服务交易额

    private String identityNegativeImg;// 证件反面图片路径

    private Integer liveCityID;// 所在城市编号

    private Integer identityType;// 证件类型，海外用户为空，大陆商家用户：1：身份证号码，2：护照号码

    private Integer businessState;// 营业状态(1营业2暂停3关闭)

    private String shopImg;// 商家店铺图片路径

    private Integer firstServiceID;// 第一个服务类别编号，外键，引用服务类型表

    private String identityNumder;// 证件号码

    private Integer trusteeshipMonth;// 托管月数

    private Integer merchantType;// 商家类别，0：不是商家，1：大陆商家用户，2：海外商家用户

    private Date merchantRegistrationTime;// 商家注册时间

    private Integer authentication;// 一号服务平台认证(0认证1未认证)

    private Float merchantLevel;// 商家星级

    private Integer collectCount;// 商家被收藏数

    private Integer orderCount;// 商家被订单数

    private String contactMailbox;// 邮箱

    private String identityHandImg;// 证件手持图片路径

    private String selfIntroduction;// 自我介绍

    private Integer secondServiceID;// 第二个服务类别编号，外键，引用服务类型表

    private String userName;// 用户名(第三方注册成功后复制过来)

    private String identityRealName;// 海外证件真实姓名，大陆商家用户为空

    private String lastEntry;// 最后登入IP地址

    private String languageNameText;// 服务语言

    private String weChat;// 微信

    private Integer experienceStatus;// 免费体验状态(0开启1关闭)

    private String userImgPath;// 用户头像地址(第三方注册成功后复制过来)

    private Integer age;// 年龄

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public Integer getSerColleID() {
        return serColleID;
    }

    public void setSerColleID(Integer serColleID) {
        this.serColleID = serColleID;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public String getServiceCoverImg() {
        return serviceCoverImg;
    }

    public void setServiceCoverImg(String serviceCoverImg) {
        this.serviceCoverImg = serviceCoverImg;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public Integer getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(Integer browseNumber) {
        this.browseNumber = browseNumber;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getServiceIntro() {
        return serviceIntro;
    }

    public void setServiceIntro(String serviceIntro) {
        this.serviceIntro = serviceIntro;
    }

    public String getMajoyNameByCN() {
        return majoyNameByCN;
    }

    public void setMajoyNameByCN(String majoyNameByCN) {
        this.majoyNameByCN = majoyNameByCN;
    }

    public String getAdminOpinion() {
        return adminOpinion;
    }

    public void setAdminOpinion(String adminOpinion) {
        this.adminOpinion = adminOpinion;
    }

    public String getServiceImgUrlThree() {
        return serviceImgUrlThree;
    }

    public void setServiceImgUrlThree(String serviceImgUrlThree) {
        this.serviceImgUrlThree = serviceImgUrlThree;
    }

    public String getServiceImgUrlTwo() {
        return serviceImgUrlTwo;
    }

    public void setServiceImgUrlTwo(String serviceImgUrlTwo) {
        this.serviceImgUrlTwo = serviceImgUrlTwo;
    }

    public String getServiceCostTypeID() {
        return serviceCostTypeID;
    }

    public void setServiceCostTypeID(String serviceCostTypeID) {
        this.serviceCostTypeID = serviceCostTypeID;
    }

    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public String getGoodAtMajoy() {
        return goodAtMajoy;
    }

    public void setGoodAtMajoy(String goodAtMajoy) {
        this.goodAtMajoy = goodAtMajoy;
    }

    public Integer getShelfState() {
        return shelfState;
    }

    public void setShelfState(Integer shelfState) {
        this.shelfState = shelfState;
    }

    public String getSchoolNameByCN() {
        return schoolNameByCN;
    }

    public void setSchoolNameByCN(String schoolNameByCN) {
        this.schoolNameByCN = schoolNameByCN;
    }

    public Integer getRecommendBool() {
        return recommendBool;
    }

    public void setRecommendBool(Integer recommendBool) {
        this.recommendBool = recommendBool;
    }

    public Integer getResourceID() {
        return resourceID;
    }

    public void setResourceID(Integer resourceID) {
        this.resourceID = resourceID;
    }

    public String getMajoyNameByROK() {
        return majoyNameByROK;
    }

    public void setMajoyNameByROK(String majoyNameByROK) {
        this.majoyNameByROK = majoyNameByROK;
    }

    public String getServiceFuTitle() {
        return serviceFuTitle;
    }

    public void setServiceFuTitle(String serviceFuTitle) {
        this.serviceFuTitle = serviceFuTitle;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getUploadDataUrl() {
        return uploadDataUrl;
    }

    public void setUploadDataUrl(String uploadDataUrl) {
        this.uploadDataUrl = uploadDataUrl;
    }

    public Integer getServiceHour() {
        return serviceHour;
    }

    public void setServiceHour(Integer serviceHour) {
        this.serviceHour = serviceHour;
    }

    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getDownloadTitle() {
        return downloadTitle;
    }

    public void setDownloadTitle(String downloadTitle) {
        this.downloadTitle = downloadTitle;
    }

    public String getServiceImgUrlFour() {
        return serviceImgUrlFour;
    }

    public void setServiceImgUrlFour(String serviceImgUrlFour) {
        this.serviceImgUrlFour = serviceImgUrlFour;
    }

    public String getServiceImgUrlOne() {
        return serviceImgUrlOne;
    }

    public void setServiceImgUrlOne(String serviceImgUrlOne) {
        this.serviceImgUrlOne = serviceImgUrlOne;
    }

    public String getSchoolRegion() {
        return schoolRegion;
    }

    public void setSchoolRegion(String schoolRegion) {
        this.schoolRegion = schoolRegion;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getSchoolNameByROK() {
        return schoolNameByROK;
    }

    public void setSchoolNameByROK(String schoolNameByROK) {
        this.schoolNameByROK = schoolNameByROK;
    }

    public String getServiceCostInclude() {
        return serviceCostInclude;
    }

    public void setServiceCostInclude(String serviceCostInclude) {
        this.serviceCostInclude = serviceCostInclude;
    }

    public Integer getTrusteeship() {
        return trusteeship;
    }

    public void setTrusteeship(Integer trusteeship) {
        this.trusteeship = trusteeship;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStateboolean() {
        return stateboolean;
    }

    public void setStateboolean(Integer stateboolean) {
        this.stateboolean = stateboolean;
    }

    public String getRegisterIP() {
        return registerIP;
    }

    public void setRegisterIP(String registerIP) {
        this.registerIP = registerIP;
    }

    public Integer getMailboxVerification() {
        return mailboxVerification;
    }

    public void setMailboxVerification(Integer mailboxVerification) {
        this.mailboxVerification = mailboxVerification;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Float getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Float userMoney) {
        this.userMoney = userMoney;
    }

    public Integer getMerchantExp() {
        return merchantExp;
    }

    public void setMerchantExp(Integer merchantExp) {
        this.merchantExp = merchantExp;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getIdentityPositiveImg() {
        return identityPositiveImg;
    }

    public void setIdentityPositiveImg(String identityPositiveImg) {
        this.identityPositiveImg = identityPositiveImg;
    }

    public Date getUserRegistrationTime() {
        return userRegistrationTime;
    }

    public void setUserRegistrationTime(Date userRegistrationTime) {
        this.userRegistrationTime = userRegistrationTime;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public Integer getProvincialID() {
        return provincialID;
    }

    public void setProvincialID(Integer provincialID) {
        this.provincialID = provincialID;
    }

    public Integer getAuthenticationer() {
        return authenticationer;
    }

    public void setAuthenticationer(Integer authenticationer) {
        this.authenticationer = authenticationer;
    }

    public String getMajorNameText() {
        return majorNameText;
    }

    public void setMajorNameText(String majorNameText) {
        this.majorNameText = majorNameText;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public Float getFirstServiceMoney() {
        return firstServiceMoney;
    }

    public void setFirstServiceMoney(Float firstServiceMoney) {
        this.firstServiceMoney = firstServiceMoney;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public Date getRecentEntry() {
        return recentEntry;
    }

    public void setRecentEntry(Date recentEntry) {
        this.recentEntry = recentEntry;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Date getTrusteeshipStartTime() {
        return trusteeshipStartTime;
    }

    public void setTrusteeshipStartTime(Date trusteeshipStartTime) {
        this.trusteeshipStartTime = trusteeshipStartTime;
    }

    public Integer getGuaranteeMoney() {
        return guaranteeMoney;
    }

    public void setGuaranteeMoney(Integer guaranteeMoney) {
        this.guaranteeMoney = guaranteeMoney;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getCountyID() {
        return countyID;
    }

    public void setCountyID(Integer countyID) {
        this.countyID = countyID;
    }

    public String getAdDetail() {
        return adDetail;
    }

    public void setAdDetail(String adDetail) {
        this.adDetail = adDetail;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Float getSecondServiceMoney() {
        return secondServiceMoney;
    }

    public void setSecondServiceMoney(Float secondServiceMoney) {
        this.secondServiceMoney = secondServiceMoney;
    }

    public String getIdentityNegativeImg() {
        return identityNegativeImg;
    }

    public void setIdentityNegativeImg(String identityNegativeImg) {
        this.identityNegativeImg = identityNegativeImg;
    }

    public Integer getLiveCityID() {
        return liveCityID;
    }

    public void setLiveCityID(Integer liveCityID) {
        this.liveCityID = liveCityID;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public Integer getBusinessState() {
        return businessState;
    }

    public void setBusinessState(Integer businessState) {
        this.businessState = businessState;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public Integer getFirstServiceID() {
        return firstServiceID;
    }

    public void setFirstServiceID(Integer firstServiceID) {
        this.firstServiceID = firstServiceID;
    }

    public String getIdentityNumder() {
        return identityNumder;
    }

    public void setIdentityNumder(String identityNumder) {
        this.identityNumder = identityNumder;
    }

    public Integer getTrusteeshipMonth() {
        return trusteeshipMonth;
    }

    public void setTrusteeshipMonth(Integer trusteeshipMonth) {
        this.trusteeshipMonth = trusteeshipMonth;
    }

    public Integer getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(Integer merchantType) {
        this.merchantType = merchantType;
    }

    public Date getMerchantRegistrationTime() {
        return merchantRegistrationTime;
    }

    public void setMerchantRegistrationTime(Date merchantRegistrationTime) {
        this.merchantRegistrationTime = merchantRegistrationTime;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public Float getMerchantLevel() {
        return merchantLevel;
    }

    public void setMerchantLevel(Float merchantLevel) {
        this.merchantLevel = merchantLevel;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getContactMailbox() {
        return contactMailbox;
    }

    public void setContactMailbox(String contactMailbox) {
        this.contactMailbox = contactMailbox;
    }

    public String getIdentityHandImg() {
        return identityHandImg;
    }

    public void setIdentityHandImg(String identityHandImg) {
        this.identityHandImg = identityHandImg;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public Integer getSecondServiceID() {
        return secondServiceID;
    }

    public void setSecondServiceID(Integer secondServiceID) {
        this.secondServiceID = secondServiceID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentityRealName() {
        return identityRealName;
    }

    public void setIdentityRealName(String identityRealName) {
        this.identityRealName = identityRealName;
    }

    public String getLastEntry() {
        return lastEntry;
    }

    public void setLastEntry(String lastEntry) {
        this.lastEntry = lastEntry;
    }

    public String getLanguageNameText() {
        return languageNameText;
    }

    public void setLanguageNameText(String languageNameText) {
        this.languageNameText = languageNameText;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public Integer getExperienceStatus() {
        return experienceStatus;
    }

    public void setExperienceStatus(Integer experienceStatus) {
        this.experienceStatus = experienceStatus;
    }

    public String getUserImgPath() {
        return userImgPath;
    }

    public void setUserImgPath(String userImgPath) {
        this.userImgPath = userImgPath;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}