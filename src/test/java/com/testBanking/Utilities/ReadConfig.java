package com.testBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		try {
			
			FileInputStream fis = new FileInputStream(src); 
			pro = new Properties();
			pro.load(fis);
			System.out.println("done");
			
		}catch(Exception e) {
			
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	
public String getApplicationURL() {
		
		String url = pro.getProperty("baseUrl");
		return url;
		
	}
	
    public String getUserName() {
		
		String url = pro.getProperty("username");
		return url;
		
	}
    
    public String getPassword() {
		
		String url = pro.getProperty("password");
		return url;
		
	}
    
    public String getChromePath() {
		
		String url = pro.getProperty("chromepath");
		return url;
		
	}
    
	public String getFireFoxPath() {
			
			String url = pro.getProperty("firefox");
			return url;
			
		}
    
	

	
	
}
