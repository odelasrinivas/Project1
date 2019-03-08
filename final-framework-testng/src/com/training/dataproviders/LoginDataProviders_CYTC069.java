package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.AdvertisementBean;
import com.training.dao.AdvertisementDAO;

public class LoginDataProviders_CYTC069 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<AdvertisementBean> list = new AdvertisementDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(AdvertisementBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getname(); 
			obj[1] = temp.getmemberlogin();
			obj[2] =temp.gettitle();
			obj[3]=temp.getcategory();
			obj[4]=temp.getprice();
			obj[5]=temp.getdescription();
			obj[6]=temp.getloginname();
			obj[7]=temp.getpassword();
			
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
