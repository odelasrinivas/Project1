package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.MemberloginBean;
import com.training.dao.ELearningDAO;
import com.training.dao.MemberloginDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders_CYTC067 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<MemberloginBean> list = new MemberloginDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(MemberloginBean temp : list){
			Object[]  obj = new Object[3]; 
			obj[0] = temp.getusername(); 
			obj[1] = temp.getnewgrouplist();
			obj[2] =temp.getcommenttextbox();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
/*	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName = "C:/Srinivas odela/Selenium/Testdata1.xlsx"; 
		String SheetName="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName = "C:/Srinivas odela/Selenium/Testdata1.xlsx"; 
		String SheetName="Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs3")
	public Object[][] getExcelData3(){
		String fileName = "C:/Srinivas odela/Selenium/Testdata1.xlsx"; 
		String SheetName="Sheet3";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); */
//	}
}
