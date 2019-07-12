package com.cafe24.shoppingmall.vo;

public class CartVo {
	private Long memberNo;
	private Long productNo;
	private int num;
	private int price;
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "CartVo [memberNo=" + memberNo + ", productNo=" + productNo + ", num=" + num + ", price=" + price + "]";
	}
}
