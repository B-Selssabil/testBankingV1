package com.testBanking.Utilities;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

	FileWriter fr;
	FileReader frea;
	Properties  p;
	Properties pro;
	String urlFile = System.getProperty("user.dir")+"\\src\\test\\java\\com\\testBanking\\testData\\DataFile.properties";
			
	public PropertiesUtils() throws IOException {
		
		
		fr = new FileWriter(urlFile, true);
        p = new Properties(); 
        frea = new FileReader(urlFile);
        pro = new Properties();
        pro.load(frea);
     
	
        
	}
	
	public void writeNewData(String k, String v) throws IOException {
		
		   p.setProperty(k, v);
	       p.store(fr, "Sample Comment");
	       System.out.print("done");
		
	}
	
	public String readData(String key) throws IOException {
		
		
		   String value = pro.getProperty(key);
	       System.out.print("done");
	       return value ;
		
	}
	
	
	

}
