package com.cafe24.shoppingmall.dto;

public class OptionDetailInfoDto {
	private Long no;
	private Long productNo;
	private String productName;
	private Long categoryNo;
	private String categoryName;
	private Long optionChildNo1;
	private String optionChildName1;
	private String optionParentNo1;
	private String optionParentName1;
	private Long optionChildNo2;
	private String optionChildName2;
	private String optionParentNo2;
	private String optionParentName2;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getOptionChildNo1() {
		return optionChildNo1;
	}
	public void setOptionChildNo1(Long optionChildNo1) {
		this.optionChildNo1 = optionChildNo1;
	}
	public String getOptionChildName1() {
		return optionChildName1;
	}
	public void setOptionChildName1(String optionChildName1) {
		this.optionChildName1 = optionChildName1;
	}
	public String getOptionParentNo1() {
		return optionParentNo1;
	}
	public void setOptionParentNo1(String optionParentNo1) {
		this.optionParentNo1 = optionParentNo1;
	}
	public String getOptionParentName1() {
		return optionParentName1;
	}
	public void setOptionParentName1(String optionParentName1) {
		this.optionParentName1 = optionParentName1;
	}
	public Long getOptionChildNo2() {
		return optionChildNo2;
	}
	public void setOptionChildNo2(Long optionChildNo2) {
		this.optionChildNo2 = optionChildNo2;
	}
	public String getOptionChildName2() {
		return optionChildName2;
	}
	public void setOptionChildName2(String optionChildName2) {
		this.optionChildName2 = optionChildName2;
	}
	public String getOptionParentNo2() {
		return optionParentNo2;
	}
	public void setOptionParentNo2(String optionParentNo2) {
		this.optionParentNo2 = optionParentNo2;
	}
	public String getOptionParentName2() {
		return optionParentName2;
	}
	public void setOptionParentName2(String optionParentName2) {
		this.optionParentName2 = optionParentName2;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "OptionDetailInfoDto [no=" + no + ", productNo=" + productNo + ", productName=" + productName
				+ ", categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", optionChildNo1=" + optionChildNo1
				+ ", optionChildName1=" + optionChildName1 + ", optionParentNo1=" + optionParentNo1
				+ ", optionParentName1=" + optionParentName1 + ", optionChildNo2=" + optionChildNo2
				+ ", optionChildName2=" + optionChildName2 + ", optionParentNo2=" + optionParentNo2
				+ ", optionParentName2=" + optionParentName2 + ", stock=" + stock + "]";
	}
}
