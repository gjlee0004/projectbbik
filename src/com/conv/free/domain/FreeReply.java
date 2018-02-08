package com.conv.free.domain;

import java.util.Date;

public class FreeReply {
	private int tNo;
	private int no;
	private String content;
	private String writer;
	private Date regDate;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
