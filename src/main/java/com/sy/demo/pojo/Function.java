package com.sy.demo.pojo;@SuppressWarnings("all")public class Function {    private Integer fID;// 权限id，主键    private String fName;// 权限名称    private Integer pid;// 父编号，0默认    private String url;// 连接路径    public Function() {        super();    }    /**     * @param fID   权限id     * @param fName 权限名称     * @param pid   父编号，0默认     * @param url   连接路径     * @description: 含主键的构造函数     */    public Function(Integer fID, String fName, Integer pid, String url) {        super();        this.fID = fID;        this.fName = fName;        this.pid = pid;        this.url = url;    }    public Integer getFID() {        return this.fID;    }    public void setFID(Integer fID) {        this.fID = fID;    }    public String getFName() {        return this.fName;    }    public void setFName(String fName) {        this.fName = fName;    }    public Integer getPid() {        return this.pid;    }    public void setPid(Integer pid) {        this.pid = pid;    }    public String getUrl() {        return this.url;    }    public void setUrl(String url) {        this.url = url;    }}	