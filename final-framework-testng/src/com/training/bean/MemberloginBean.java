package com.training.bean;

public class MemberloginBean {
	private String username;
	private String newgrouplist;
	private String commenttextbox;
	
	public MemberloginBean() {
	}

	public MemberloginBean(String username, String newgrouplist, String commenttextbox) {
		super();
		this.username = username;
		this.newgrouplist = newgrouplist;
		this.commenttextbox=commenttextbox;
		
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getnewgrouplist() {
		return newgrouplist;
	}

	public void setnewgrouplist(String newgrouplist) {
		this.newgrouplist = newgrouplist;
	}
	
	public String getcommenttextbox() {
		return commenttextbox;
	}

	public void setcommenttextbox(String commenttextbox) {
		this.commenttextbox = commenttextbox;
	}
	

	@Override
	public String toString() {
		
		//return "MemberloginBean [username=" + username + ", newgrouplist=" + newgrouplist + ", commenttextbox="+ commenttextbox +"]";
		
		return "MemberloginBean[username="+username+", newgrouplist="+newgrouplist+", commenttextbox="+commenttextbox+"]";
		
	}

}

