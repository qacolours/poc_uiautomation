package uiautomation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class utility_functions {
	
	Properties oprop = new Properties();
	
	public String getProperty(String property_name) throws Exception {
		//Properties oprop = new Properties();
		InputStream inputstrm = new FileInputStream(System.getProperty("user.dir") + "/resources/configuration/config.properties");
		oprop.load(inputstrm);
		
		String property_value = oprop.getProperty(property_name);
		inputstrm.close();
		
		return property_value;
	}
	
	public void setProperty(String property_name,String property_value) throws Exception {
		//Properties oprop = new Properties();
		OutputStream outputstrm = new FileOutputStream(System.getProperty("user.dir") + "/resources/configuration/config.properties");
		
		oprop.setProperty(property_name,property_value);
		oprop.store(outputstrm, "");
		outputstrm.close();
	}

}
