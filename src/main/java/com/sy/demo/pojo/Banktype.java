package com.sy.demo.pojo;@SuppressWarnings("all")public class Banktype {    private Integer bankID;// 银行类别，主键    private Integer show;// 是否显示    private String bankName;// 银行名称    private Integer sort;// 排序    public Banktype() {        super();    }    /**     * @param bankID   银行类别     * @param show     是否显示     * @param bankName 银行名称     * @param sort     排序     * @description: 含主键的构造函数     */    public Banktype(Integer bankID, Integer show, String bankName, Integer sort) {        super();        this.bankID = bankID;        this.show = show;        this.bankName = bankName;        this.sort = sort;    }    public Integer getBankID() {        return this.bankID;    }    public void setBankID(Integer bankID) {        this.bankID = bankID;    }    public Integer getShow() {        return this.show;    }    public void setShow(Integer show) {        this.show = show;    }    public String getBankName() {        return this.bankName;    }    public void setBankName(String bankName) {        this.bankName = bankName;    }    public Integer getSort() {        return this.sort;    }    public void setSort(Integer sort) {        this.sort = sort;    }}	