package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {
	public String getDataFromPropetiesFile(String key) throws Throwable
	{
		FileInputStream fis = new  FileInputStream("C:\\Users\\Raja\\Desktop\\selenium\\ComcastCRMGUIFramework\\configAppData\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);

	return data;
	}
	

}
