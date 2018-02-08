package com.conv.member.domain;

public class Member {
private String id;
private String pass;
private String passhint;
private String email;
//private String accessTime;
//public String getAccessTime() {
//	return accessTime;
//}
//public void setAccessTime(String accessTime) {
//	this.accessTime = accessTime;
//}
public String getId() {
	return id;
}
public void setId(Object object) {
	this.id = (String) object;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getPasshint() {
	return passhint;
}
public void setPasshint(String passhint) {
	this.passhint = passhint;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}