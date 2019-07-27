package com.cafe24.shoppingmall.vo;

public class CartVo {
	private Long memberNo;
	private Long optionDetailNo;
	private int num;
	private int price;
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getOptionDetailNo() {
		return optionDetailNo;
	}
	public void setOptionDetailNo(Long optionDetailNo) {
		this.optionDetailNo = optionDetailNo;
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
		return "CartVo [memberNo=" + memberNo + ", optionDetailNo=" + optionDetailNo + ", num=" + num + ", price="
				+ price + "]";
	}
}
