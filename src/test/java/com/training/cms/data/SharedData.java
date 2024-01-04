package com.training.cms.data;

import org.testng.annotations.DataProvider;

public class SharedData {
	@DataProvider(indices = {0,2})
	public String[] nameTestData() {
	
			String []data = new String[]
					{
							"Ramesh",
							"Sachin",
							"Mohan"
					};
			
			return data;
	}
	
	@DataProvider(indices = {0,2})
	public String[][] loginData() {
	
			String [][]data = new String[2][2];
			
			data[0][0] = "admin";
			data[0][1] = "admin123";
			
			return data;
	}
	
}
