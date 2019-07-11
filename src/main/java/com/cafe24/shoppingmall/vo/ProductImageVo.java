package com.cafe24.shoppingmall.vo;

public class ProductImageVo {
	private Long no;
	private Long productNo;
	private String type;
	private String url;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "ProductImageVo [no=" + no + ", productNo=" + productNo + ", type=" + type + ", url=" + url + "]";
	}
}
