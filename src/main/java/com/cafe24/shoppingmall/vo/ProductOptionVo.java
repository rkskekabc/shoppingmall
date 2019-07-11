package com.cafe24.shoppingmall.vo;

public class ProductOptionVo {
	private Long no;
	private String info;
	private int price;
	private int stock;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "ProductOptionVo [no=" + no + ", info=" + info + ", price=" + price + ", stock=" + stock + "]";
	}
	
}
