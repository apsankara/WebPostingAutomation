package com.xeroxDriverPosting.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	//Create the constructor to initialize the value and get from properties file

	public ReadConfig()
	{
		File file=new File("./Configuration/config.properties");

		try
		{
			FileInputStream readfile=new FileInputStream(file);
			properties=new Properties();
			properties.load(readfile);

		}catch(Exception ex)
		{
			System.out.println("Exception is " + ex.getMessage());
		}
	}


	//creating the different method for available variable in the properties file
	public String getApplicationURL() {

		String url=properties.getProperty("baseURL");
		return url;
	}

	public String getChromePath()
	{
		String chromepath=properties.getProperty("chromPath");
		return chromepath;

	}

	public String getFireFoxPath()
	{
		String firefoxpath=properties.getProperty("fireFoxPath");
		return firefoxpath;
	}
	public String getMicroSoftEdgePath()
	{
		String msedgepath=properties.getProperty("MSEdgePath");
		return msedgepath;
	}
}
