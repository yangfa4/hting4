package com.sy.demo.pojo;import org.springframework.format.annotation.DateTimeFormat;import java.util.Date;@SuppressWarnings("all")public class Appraisalapply {    private String country;// 国，在韩住址    private String strength;// 实力展示    private Integer documentType;// 证件类型(1身份证2护照)    private String officialNetworkURL;// 留学中介官网网址    private String officeCountry;// 国，办公室所在地    private Integer stid;// 外键，服务编号    private Integer office;// 是否有办公室（1：无，2有）    private String experience;// 经验时长(直接填字符串)    private Integer userID;// 外键，用户编号    private String hospitalPhone;// 医院联系电话    private String studyMajor;// 所学专业    private String translate;// 资质文件    private Integer vehicle;// 是否有车 (1:没有，2有）    private String adminOpinion;// 审批备注    private String constellation;// 星座    private String officeProvince;// 省，办公室所在地    private Integer guideCard;// 是否有导游证(1:没有，2有）    private String provincialID;// 省，在韩住址    private String cooperativeHospital;// 合作医院名字    private String email;// 邮箱地址    private Integer height;// 身高    private String translateWebsite;// 网址    private String officeCity;// 市，办公室所在地    private Integer sex;// 性别(1男2女)    private String cooperativeHospitalURL;// 合作医院官网网址    private String cityID;// 市，在韩住址    private String hospitalLicense;// 整形医院营业执照    private String visaType;// 签证类型(直接填字符串)    private String koreaLicense;// 韩国营业执照    private Integer applyID;// 鉴定记录id，主键    private Date submitTime;// 提交时间    private String certificates;// 证件号    private String phone;// 联系电话    private String detailed;// 详细，在韩住址    private Date auditTime;// 审核时间    private String officeDetailed;// 详细，办公室所在地    private String name;// 姓名    private Integer auditStatus;// 审核状态(1待审核2审核成功3未通过)    private Integer translateType;// 翻译资质(上传资质文件类型：1证书 2语言成绩)    private String inKorea;// 在韩时长    private String schoolReport;// 成绩单(上传文件)    private Integer age;// 年龄    public Appraisalapply() {        super();    }    /**     * @param country                国，在韩住址     * @param strength               实力展示     * @param documentType           证件类型(1身份证2护照)     * @param officialNetworkURL     留学中介官网网址     * @param officeCountry          国，办公室所在地     * @param stid                   外键，服务编号     * @param office                 是否有办公室（1：无，2有）     * @param experience             经验时长(直接填字符串)     * @param userID                 外键，用户编号     * @param hospitalPhone          医院联系电话     * @param studyMajor             所学专业     * @param translate              资质文件     * @param vehicle                是否有车 (1:没有，2有）     * @param adminOpinion           审批备注     * @param constellation          星座     * @param officeProvince         省，办公室所在地     * @param guideCard              是否有导游证(1:没有，2有）     * @param provincialID           省，在韩住址     * @param cooperativeHospital    合作医院名字     * @param email                  邮箱地址     * @param height                 身高     * @param translateWebsite       网址     * @param officeCity             市，办公室所在地     * @param sex                    性别(1男2女)     * @param cooperativeHospitalURL 合作医院官网网址     * @param cityID                 市，在韩住址     * @param hospitalLicense        整形医院营业执照     * @param visaType               签证类型(直接填字符串)     * @param koreaLicense           韩国营业执照     * @param applyID                鉴定记录id     * @param submitTime             提交时间     * @param certificates           证件号     * @param phone                  联系电话     * @param detailed               详细，在韩住址     * @param auditTime              审核时间     * @param officeDetailed         详细，办公室所在地     * @param name                   姓名     * @param auditStatus            审核状态(1待审核2审核成功3未通过)     * @param translateType          翻译资质(上传资质文件类型：1证书 2语言成绩)     * @param inKorea                在韩时长     * @param schoolReport           成绩单(上传文件)     * @param age                    年龄     * @description: 含主键的构造函数     */    public Appraisalapply(String country, String strength, Integer documentType, String officialNetworkURL,                          String officeCountry, Integer stid, Integer office, String experience, Integer userID, String hospitalPhone,                          String studyMajor, String translate, Integer vehicle, String adminOpinion, String constellation,                          String officeProvince, Integer guideCard, String provincialID, String cooperativeHospital, String email,                          Integer height, String translateWebsite, String officeCity, Integer sex, String cooperativeHospitalURL,                          String cityID, String hospitalLicense, String visaType, String koreaLicense, Integer applyID,                          Date submitTime, String certificates, String phone, String detailed, Date auditTime, String officeDetailed,                          String name, Integer auditStatus, Integer translateType, String inKorea, String schoolReport, Integer age) {        super();        this.country = country;        this.strength = strength;        this.documentType = documentType;        this.officialNetworkURL = officialNetworkURL;        this.officeCountry = officeCountry;        this.stid = stid;        this.office = office;        this.experience = experience;        this.userID = userID;        this.hospitalPhone = hospitalPhone;        this.studyMajor = studyMajor;        this.translate = translate;        this.vehicle = vehicle;        this.adminOpinion = adminOpinion;        this.constellation = constellation;        this.officeProvince = officeProvince;        this.guideCard = guideCard;        this.provincialID = provincialID;        this.cooperativeHospital = cooperativeHospital;        this.email = email;        this.height = height;        this.translateWebsite = translateWebsite;        this.officeCity = officeCity;        this.sex = sex;        this.cooperativeHospitalURL = cooperativeHospitalURL;        this.cityID = cityID;        this.hospitalLicense = hospitalLicense;        this.visaType = visaType;        this.koreaLicense = koreaLicense;        this.applyID = applyID;        this.submitTime = submitTime;        this.certificates = certificates;        this.phone = phone;        this.detailed = detailed;        this.auditTime = auditTime;        this.officeDetailed = officeDetailed;        this.name = name;        this.auditStatus = auditStatus;        this.translateType = translateType;        this.inKorea = inKorea;        this.schoolReport = schoolReport;        this.age = age;    }    public String getCountry() {        return this.country;    }    public void setCountry(String country) {        this.country = country;    }    public String getStrength() {        return this.strength;    }    public void setStrength(String strength) {        this.strength = strength;    }    public Integer getDocumentType() {        return this.documentType;    }    public void setDocumentType(Integer documentType) {        this.documentType = documentType;    }    public String getOfficialNetworkURL() {        return this.officialNetworkURL;    }    public void setOfficialNetworkURL(String officialNetworkURL) {        this.officialNetworkURL = officialNetworkURL;    }    public String getOfficeCountry() {        return this.officeCountry;    }    public void setOfficeCountry(String officeCountry) {        this.officeCountry = officeCountry;    }    public Integer getStid() {        return this.stid;    }    public void setStid(Integer stid) {        this.stid = stid;    }    public Integer getOffice() {        return this.office;    }    public void setOffice(Integer office) {        this.office = office;    }    public String getExperience() {        return this.experience;    }    public void setExperience(String experience) {        this.experience = experience;    }    public Integer getUserID() {        return this.userID;    }    public void setUserID(Integer userID) {        this.userID = userID;    }    public String getHospitalPhone() {        return this.hospitalPhone;    }    public void setHospitalPhone(String hospitalPhone) {        this.hospitalPhone = hospitalPhone;    }    public String getStudyMajor() {        return this.studyMajor;    }    public void setStudyMajor(String studyMajor) {        this.studyMajor = studyMajor;    }    public String getTranslate() {        return this.translate;    }    public void setTranslate(String translate) {        this.translate = translate;    }    public Integer getVehicle() {        return this.vehicle;    }    public void setVehicle(Integer vehicle) {        this.vehicle = vehicle;    }    public String getAdminOpinion() {        return this.adminOpinion;    }    public void setAdminOpinion(String adminOpinion) {        this.adminOpinion = adminOpinion;    }    public String getConstellation() {        return this.constellation;    }    public void setConstellation(String constellation) {        this.constellation = constellation;    }    public String getOfficeProvince() {        return this.officeProvince;    }    public void setOfficeProvince(String officeProvince) {        this.officeProvince = officeProvince;    }    public Integer getGuideCard() {        return this.guideCard;    }    public void setGuideCard(Integer guideCard) {        this.guideCard = guideCard;    }    public String getProvincialID() {        return this.provincialID;    }    public void setProvincialID(String provincialID) {        this.provincialID = provincialID;    }    public String getCooperativeHospital() {        return this.cooperativeHospital;    }    public void setCooperativeHospital(String cooperativeHospital) {        this.cooperativeHospital = cooperativeHospital;    }    public String getEmail() {        return this.email;    }    public void setEmail(String email) {        this.email = email;    }    public Integer getHeight() {        return this.height;    }    public void setHeight(Integer height) {        this.height = height;    }    public String getTranslateWebsite() {        return this.translateWebsite;    }    public void setTranslateWebsite(String translateWebsite) {        this.translateWebsite = translateWebsite;    }    public String getOfficeCity() {        return this.officeCity;    }    public void setOfficeCity(String officeCity) {        this.officeCity = officeCity;    }    public Integer getSex() {        return this.sex;    }    public void setSex(Integer sex) {        this.sex = sex;    }    public String getCooperativeHospitalURL() {        return this.cooperativeHospitalURL;    }    public void setCooperativeHospitalURL(String cooperativeHospitalURL) {        this.cooperativeHospitalURL = cooperativeHospitalURL;    }    public String getCityID() {        return this.cityID;    }    public void setCityID(String cityID) {        this.cityID = cityID;    }    public String getHospitalLicense() {        return this.hospitalLicense;    }    public void setHospitalLicense(String hospitalLicense) {        this.hospitalLicense = hospitalLicense;    }    public String getVisaType() {        return this.visaType;    }    public void setVisaType(String visaType) {        this.visaType = visaType;    }    public String getKoreaLicense() {        return this.koreaLicense;    }    public void setKoreaLicense(String koreaLicense) {        this.koreaLicense = koreaLicense;    }    public Integer getApplyID() {        return this.applyID;    }    public void setApplyID(Integer applyID) {        this.applyID = applyID;    }    public Date getSubmitTime() {        return this.submitTime;    }    public void setSubmitTime(Date submitTime) {        this.submitTime = submitTime;    }    public String getCertificates() {        return this.certificates;    }    public void setCertificates(String certificates) {        this.certificates = certificates;    }    public String getPhone() {        return this.phone;    }    public void setPhone(String phone) {        this.phone = phone;    }    public String getDetailed() {        return this.detailed;    }    public void setDetailed(String detailed) {        this.detailed = detailed;    }    public Date getAuditTime() {        return this.auditTime;    }    public void setAuditTime(Date auditTime) {        this.auditTime = auditTime;    }    public String getOfficeDetailed() {        return this.officeDetailed;    }    public void setOfficeDetailed(String officeDetailed) {        this.officeDetailed = officeDetailed;    }    public String getName() {        return this.name;    }    public void setName(String name) {        this.name = name;    }    public Integer getAuditStatus() {        return this.auditStatus;    }    public void setAuditStatus(Integer auditStatus) {        this.auditStatus = auditStatus;    }    public Integer getTranslateType() {        return this.translateType;    }    public void setTranslateType(Integer translateType) {        this.translateType = translateType;    }    public String getInKorea() {        return this.inKorea;    }    public void setInKorea(String inKorea) {        this.inKorea = inKorea;    }    public String getSchoolReport() {        return this.schoolReport;    }    public void setSchoolReport(String schoolReport) {        this.schoolReport = schoolReport;    }    public Integer getAge() {        return this.age;    }    public void setAge(Integer age) {        this.age = age;    }	@Override	public String toString() {		return "Appraisalapply [country=" + country + ", strength=" + strength + ", documentType=" + documentType				+ ", officialNetworkURL=" + officialNetworkURL + ", officeCountry=" + officeCountry + ", stid=" + stid				+ ", office=" + office + ", experience=" + experience + ", userID=" + userID + ", hospitalPhone="				+ hospitalPhone + ", studyMajor=" + studyMajor + ", translate=" + translate + ", vehicle=" + vehicle				+ ", adminOpinion=" + adminOpinion + ", constellation=" + constellation + ", officeProvince="				+ officeProvince + ", guideCard=" + guideCard + ", provincialID=" + provincialID				+ ", cooperativeHospital=" + cooperativeHospital + ", email=" + email + ", height=" + height				+ ", translateWebsite=" + translateWebsite + ", officeCity=" + officeCity + ", sex=" + sex				+ ", cooperativeHospitalURL=" + cooperativeHospitalURL + ", cityID=" + cityID + ", hospitalLicense="				+ hospitalLicense + ", visaType=" + visaType + ", koreaLicense=" + koreaLicense + ", applyID=" + applyID				+ ", submitTime=" + submitTime + ", certificates=" + certificates + ", phone=" + phone + ", detailed="				+ detailed + ", auditTime=" + auditTime + ", officeDetailed=" + officeDetailed + ", name=" + name				+ ", auditStatus=" + auditStatus + ", translateType=" + translateType + ", inKorea=" + inKorea				+ ", schoolReport=" + schoolReport + ", age=" + age + "]";	}}