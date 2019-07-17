package com.cafe24.shoppingmall.dto;

public class ProductOrderDto {
	private Long memberNo;
	private Long productNo;
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
	
	@Override
	public String toString() {
		return "ProductOrderDto [memberNo=" + memberNo + ", productNo=" + productNo + "]";
	}
}
