package com.cafe24.shoppingmall.vo;

public class HistoryProductVo {
	private Long historyNo;
	private Long optionDetailNo;
	private Integer num;
	private Integer price;
	public Long getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(Long historyNo) {
		this.historyNo = historyNo;
	}
	public Long getOptionDetailNo() {
		return optionDetailNo;
	}
	public void setOptionDetailNo(Long optionDetailNo) {
		this.optionDetailNo = optionDetailNo;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "HistoryProductVo [historyNo=" + historyNo + ", optionDetailNo=" + optionDetailNo + ", num=" + num
				+ ", price=" + price + "]";
	}
	
	
}
