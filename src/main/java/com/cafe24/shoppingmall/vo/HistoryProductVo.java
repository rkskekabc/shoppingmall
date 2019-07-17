package com.cafe24.shoppingmall.vo;

public class HistoryProductVo {
	private Long no;
	private Long productNum;
	private Integer num;
	private Integer price;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
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
		return "HistoryProductVo [no=" + no + ", productNum=" + productNum + ", num=" + num + ", price=" + price + "]";
	}
	
}
