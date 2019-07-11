package com.cafe24.shoppingmall.vo;

public class DestinationVo {
	private Long no;
	private Long memberNo;
	private String destinationInfo;
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
	public String getDestinationInfo() {
		return destinationInfo;
	}
	public void setDestinationInfo(String destinationInfo) {
		this.destinationInfo = destinationInfo;
	}
	@Override
	public String toString() {
		return "DestinationVo [no=" + no + ", memberNo=" + memberNo + ", destinationInfo=" + destinationInfo + "]";
	}
}
