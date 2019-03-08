package com.training.bean;

public class AdvertisementBean {
	
	private String name;
	private String memberlogin;
	private String title;
	private String category;
	private String price;
	private String description;
	private String loginname;
	private String password;
	
	public AdvertisementBean() {
	}

	public AdvertisementBean(String name, String memberlogin, String title, String category, String price, String description, String loginname, String password) {
		super();
		
		this.name = name;
		this.memberlogin = memberlogin;
		this.title=title;
		this.category=category;
		this.price=price;
		this.description=description;
		this.loginname=loginname;
		this.password=password;
				
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
		
	}

	public String getmemberlogin() {
		return memberlogin;
	}

	public void setmemberlogin(String memberlogin) {
		this.memberlogin = memberlogin;
	}
	
	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}
	
	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}
	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}
	
	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String getloginname() {
		return loginname;
	}

	public void setloginname(String loginname) {
		this.loginname = loginname;
	}
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		
		//return "AdvertisementBean [username=" + username + ", newgrouplist=" + newgrouplist + ", commenttextbox="+ commenttextbox +"]";
		
		//return "AdvertisementBean[username="+username+", newgrouplist="+newgrouplist+", commenttextbox="+commenttextbox+"]";

return "AdvertisementBean[name="+name+", memberlogin="+memberlogin+", title="+title+",category="+category+",price="+price+",description="+description+",loginname="+loginname+",password="+loginname+"]";
	
	}

}
