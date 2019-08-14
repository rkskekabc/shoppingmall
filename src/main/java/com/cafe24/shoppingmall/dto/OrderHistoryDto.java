package com.cafe24.shoppingmall.dto;

public class OrderHistoryDto {
	private Long no;
	private Long memberNo;
	private String memberName;
	private String status;
	private String destination;
	private String phone;
	private String orderDate;
	private String cardCompany;
	private String cardNum;
	private String aesKey;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getCardCompany() {
		return cardCompany;
	}
	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getAesKey() {
		return aesKey;
	}
	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}
	@Override
	public String toString() {
		return "OrderHistoryDto [no=" + no + ", memberNo=" + memberNo + ", memberName=" + memberName + ", status="
				+ status + ", destination=" + destination + ", phone=" + phone + ", orderDate=" + orderDate
				+ ", cardCompany=" + cardCompany + ", cardNum=" + cardNum + ", aesKey=" + aesKey + "]";
	}
	
}
