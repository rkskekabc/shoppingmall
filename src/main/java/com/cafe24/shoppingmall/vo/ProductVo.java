package com.cafe24.shoppingmall.vo;

public class ProductVo {
	private Long no;
	private Long optionNo;
	private String type;
	private String name;
	private String explanation;
	private String regDate;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Long optionNo) {
		this.optionNo = optionNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", optionNo=" + optionNo + ", type=" + type + ", name=" + name + ", explanation="
				+ explanation + ", regDate=" + regDate + "]";
	}
}
