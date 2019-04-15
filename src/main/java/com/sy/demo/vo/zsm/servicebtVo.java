package com.sy.demo.vo.zsm;

public class servicebtVo {

	private String stName;
	private Integer sl;
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public Integer getSl() {
		return sl;
	}
	public servicebtVo(String stName, Integer sl) {
		super();
		this.stName = stName;
		this.sl = sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	public servicebtVo() {
		super();
	}
	@Override
	public String toString() {
		return "servicebtVo [stName=" + stName + ", sl=" + sl + "]";
	}
}
