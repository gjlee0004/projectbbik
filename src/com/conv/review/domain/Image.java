package com.conv.review.domain;

import java.util.Date;

public class Image {
	private int tNo;
	private int no;
	private String sName;
	private String orgName;
	private String path;
	private String filesize;
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
}
