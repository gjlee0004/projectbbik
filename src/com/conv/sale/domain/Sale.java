package com.conv.sale.domain;

public class Sale {
	private String productName;
	private String imageURL;
	private String price;
	private String event;
	private String convName;
	
	
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getConvName() {
		return convName;
	}
	public void setConvName(String convName) {
		this.convName = convName;
	}
	
}
