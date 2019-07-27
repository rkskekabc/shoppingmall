package com.cafe24.shoppingmall.vo;

public class OptionChildVo {
	private Long no;
	private Long optionParentNo;
	private String name;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getOptionParentNo() {
		return optionParentNo;
	}
	public void setOptionParentNo(Long optionParentNo) {
		this.optionParentNo = optionParentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "OptionChildVo [no=" + no + ", optionParentNo=" + optionParentNo + ", name=" + name + "]";
	}
	
}
