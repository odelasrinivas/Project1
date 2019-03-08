package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.AdvertisementBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class AdvertisementDAO {
	
	Properties properties; 
	
	public AdvertisementDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AdvertisementBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<AdvertisementBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			
			list = new ArrayList<AdvertisementBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				AdvertisementBean temp = new AdvertisementBean(); 
				temp.setname(gc.rs1.getString(1));
				temp.setmemberlogin(gc.rs1.getString(2));
				temp.settitle(gc.rs1.getString(3));
				temp.setcategory(gc.rs1.getString(4));
				temp.setprice(gc.rs1.getString(5));
				temp.setdescription(gc.rs1.getString(6));
				temp.setloginname(gc.rs1.getString(7));
				temp.setpassword(gc.rs1.getString(8));
				
				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new AdvertisementDAO().getLogins().forEach(System.out :: println);
	}
	
	
}
