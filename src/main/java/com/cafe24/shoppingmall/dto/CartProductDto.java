package com.cafe24.shoppingmall.dto;

public class CartProductDto {
	private String optionInfo;
	private Integer price;
	private Integer stock;
	private String categoryName;
	private String type;
	private String name;
	private String explanation;
	private String regDate;
	private Integer num;
	private Integer priceSum;
	public String getOptionInfo() {
		return optionInfo;
	}
	public void setOptionInfo(String optionInfo) {
		this.optionInfo = optionInfo;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getPriceSum() {
		return priceSum;
	}
	public void setPriceSum(Integer priceSum) {
		this.priceSum = priceSum;
	}
	@Override
	public String toString() {
		return "CartProductDto [optionInfo=" + optionInfo + ", price=" + price + ", stock=" + stock + ", categoryName="
				+ categoryName + ", type=" + type + ", name=" + name + ", explanation=" + explanation + ", regDate="
				+ regDate + ", num=" + num + ", priceSum=" + priceSum + "]";
	}
}
