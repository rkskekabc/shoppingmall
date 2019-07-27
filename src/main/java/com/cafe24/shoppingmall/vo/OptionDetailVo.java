package com.cafe24.shoppingmall.vo;

public class OptionDetailVo {
	private Long no;
	private Long productNo;
	private Long categoryNo;
	private Long optionChildNo1;
	private Long optionChildNo2;
	private Integer stock;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public Long getOptionChildNo1() {
		return optionChildNo1;
	}
	public void setOptionChildNo1(Long optionChildNo1) {
		this.optionChildNo1 = optionChildNo1;
	}
	public Long getOptionChildNo2() {
		return optionChildNo2;
	}
	public void setOptionChildNo2(Long optionChildNo2) {
		this.optionChildNo2 = optionChildNo2;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "OptionDetailVo [no=" + no + ", productNo=" + productNo + ", categoryNo=" + categoryNo
				+ ", optionChildNo1=" + optionChildNo1 + ", optionChildNo2=" + optionChildNo2 + ", stock=" + stock
				+ "]";
	}
	
}
