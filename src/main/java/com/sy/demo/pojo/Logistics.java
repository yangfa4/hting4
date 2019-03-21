package com.sy.demo.pojo;import org.springframework.format.annotation.DateTimeFormat;import java.util.Date;@SuppressWarnings("all")public class Logistics {    private String userPhone;// 发货人电话    private String logisticsSingleNumber;// 用户发货物流单号    private String userAddr;// 发货人地址    private String number1;// 已发国际EMS单号1    private String collectGoodsPhone;// 收货人电话    private String number2;// 已发国际EMS单号2    private String title;// 物品标题    private Integer userID;// 外键，用户编号    private Date orderTime;// 下单时间    private Integer price;// 金币(根据重量计算)    private String logisticsCompany;// 用户发货物流公司    private Integer kg;// 重量    private String img4;// 物品图片4    private String img3;// 物品图片3    private Integer delivery;// 发货方式(貌似固定1.上门提货/大于30kg2.自发)    private Date numberTime1;// 发国际EMS单号时间1    private Integer logisticsID;// 物流id，主键    private String img5;// 物品图片5    private String orderID;// 服务单号    private String collectGoodsAddr;// 收货地址    private Date numberTime2;// 发国际EMS单号时间2    private String collectGoods;// 收货人姓名    private Date confirmationTime;// 用户确认完成时间    private String userName;// 发货人姓名    private Date submitTime;// 单号提交时间    private Date auditTime;// 审核通过时间    private Integer auditStatus;// 审核状态(1待审核2审核成功3未通过)    private String describe;// 物品描述    private String img2;// 物品图片2    private String img1;// 物品图片1    public Logistics() {        super();    }    /**     * @param userPhone             发货人电话     * @param logisticsSingleNumber 用户发货物流单号     * @param userAddr              发货人地址     * @param number1               已发国际EMS单号1     * @param collectGoodsPhone     收货人电话     * @param number2               已发国际EMS单号2     * @param title                 物品标题     * @param userID                外键，用户编号     * @param orderTime             下单时间     * @param price                 金币(根据重量计算)     * @param logisticsCompany      用户发货物流公司     * @param kg                    重量     * @param img4                  物品图片4     * @param img3                  物品图片3     * @param delivery              发货方式(貌似固定1.上门提货/大于30kg2.自发)     * @param numberTime1           发国际EMS单号时间1     * @param logisticsID           物流id     * @param img5                  物品图片5     * @param orderID               服务单号     * @param collectGoodsAddr      收货地址     * @param numberTime2           发国际EMS单号时间2     * @param collectGoods          收货人姓名     * @param confirmationTime      用户确认完成时间     * @param userName              发货人姓名     * @param submitTime            单号提交时间     * @param auditTime             审核通过时间     * @param auditStatus           审核状态(1待审核2审核成功3未通过)     * @param describe              物品描述     * @param img2                  物品图片2     * @param img1                  物品图片1     * @description: 含主键的构造函数     */    public Logistics(String userPhone, String logisticsSingleNumber, String userAddr, String number1, String collectGoodsPhone, String number2, String title, Integer userID, Date orderTime, Integer price, String logisticsCompany, Integer kg, String img4, String img3, Integer delivery, Date numberTime1, Integer logisticsID, String img5, String orderID, String collectGoodsAddr, Date numberTime2, String collectGoods, Date confirmationTime, String userName, Date submitTime, Date auditTime, Integer auditStatus, String describe, String img2, String img1) {        super();        this.userPhone = userPhone;        this.logisticsSingleNumber = logisticsSingleNumber;        this.userAddr = userAddr;        this.number1 = number1;        this.collectGoodsPhone = collectGoodsPhone;        this.number2 = number2;        this.title = title;        this.userID = userID;        this.orderTime = orderTime;        this.price = price;        this.logisticsCompany = logisticsCompany;        this.kg = kg;        this.img4 = img4;        this.img3 = img3;        this.delivery = delivery;        this.numberTime1 = numberTime1;        this.logisticsID = logisticsID;        this.img5 = img5;        this.orderID = orderID;        this.collectGoodsAddr = collectGoodsAddr;        this.numberTime2 = numberTime2;        this.collectGoods = collectGoods;        this.confirmationTime = confirmationTime;        this.userName = userName;        this.submitTime = submitTime;        this.auditTime = auditTime;        this.auditStatus = auditStatus;        this.describe = describe;        this.img2 = img2;        this.img1 = img1;    }    public String getUserPhone() {        return this.userPhone;    }    public void setUserPhone(String userPhone) {        this.userPhone = userPhone;    }    public String getLogisticsSingleNumber() {        return this.logisticsSingleNumber;    }    public void setLogisticsSingleNumber(String logisticsSingleNumber) {        this.logisticsSingleNumber = logisticsSingleNumber;    }    public String getUserAddr() {        return this.userAddr;    }    public void setUserAddr(String userAddr) {        this.userAddr = userAddr;    }    public String getNumber1() {        return this.number1;    }    public void setNumber1(String number1) {        this.number1 = number1;    }    public String getCollectGoodsPhone() {        return this.collectGoodsPhone;    }    public void setCollectGoodsPhone(String collectGoodsPhone) {        this.collectGoodsPhone = collectGoodsPhone;    }    public String getNumber2() {        return this.number2;    }    public void setNumber2(String number2) {        this.number2 = number2;    }    public String getTitle() {        return this.title;    }    public void setTitle(String title) {        this.title = title;    }    public Integer getUserID() {        return this.userID;    }    public void setUserID(Integer userID) {        this.userID = userID;    }    public Date getOrderTime() {        return this.orderTime;    }    public void setOrderTime(Date orderTime) {        this.orderTime = orderTime;    }    public Integer getPrice() {        return this.price;    }    public void setPrice(Integer price) {        this.price = price;    }    public String getLogisticsCompany() {        return this.logisticsCompany;    }    public void setLogisticsCompany(String logisticsCompany) {        this.logisticsCompany = logisticsCompany;    }    public Integer getKg() {        return this.kg;    }    public void setKg(Integer kg) {        this.kg = kg;    }    public String getImg4() {        return this.img4;    }    public void setImg4(String img4) {        this.img4 = img4;    }    public String getImg3() {        return this.img3;    }    public void setImg3(String img3) {        this.img3 = img3;    }    public Integer getDelivery() {        return this.delivery;    }    public void setDelivery(Integer delivery) {        this.delivery = delivery;    }    public Date getNumberTime1() {        return this.numberTime1;    }    public void setNumberTime1(Date numberTime1) {        this.numberTime1 = numberTime1;    }    public Integer getLogisticsID() {        return this.logisticsID;    }    public void setLogisticsID(Integer logisticsID) {        this.logisticsID = logisticsID;    }    public String getImg5() {        return this.img5;    }    public void setImg5(String img5) {        this.img5 = img5;    }    public String getOrderID() {        return this.orderID;    }    public void setOrderID(String orderID) {        this.orderID = orderID;    }    public String getCollectGoodsAddr() {        return this.collectGoodsAddr;    }    public void setCollectGoodsAddr(String collectGoodsAddr) {        this.collectGoodsAddr = collectGoodsAddr;    }    public Date getNumberTime2() {        return this.numberTime2;    }    public void setNumberTime2(Date numberTime2) {        this.numberTime2 = numberTime2;    }    public String getCollectGoods() {        return this.collectGoods;    }    public void setCollectGoods(String collectGoods) {        this.collectGoods = collectGoods;    }    public Date getConfirmationTime() {        return this.confirmationTime;    }    public void setConfirmationTime(Date confirmationTime) {        this.confirmationTime = confirmationTime;    }    public String getUserName() {        return this.userName;    }    public void setUserName(String userName) {        this.userName = userName;    }    public Date getSubmitTime() {        return this.submitTime;    }    public void setSubmitTime(Date submitTime) {        this.submitTime = submitTime;    }    public Date getAuditTime() {        return this.auditTime;    }    public void setAuditTime(Date auditTime) {        this.auditTime = auditTime;    }    public Integer getAuditStatus() {        return this.auditStatus;    }    public void setAuditStatus(Integer auditStatus) {        this.auditStatus = auditStatus;    }    public String getDescribe() {        return this.describe;    }    public void setDescribe(String describe) {        this.describe = describe;    }    public String getImg2() {        return this.img2;    }    public void setImg2(String img2) {        this.img2 = img2;    }    public String getImg1() {        return this.img1;    }    public void setImg1(String img1) {        this.img1 = img1;    }}	