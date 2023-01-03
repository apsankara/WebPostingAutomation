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
	
	public String getBrowserName()
	{
		String browsername=properties.getProperty("browser");
		return browsername;
	}
	
	
	public String getModelName()
	{
		String modelname=properties.getProperty("Model");
		return modelname;
	}
	
	public String clickModelNameLink()
	{
		String modelLink=properties.getProperty("ModelLink");
		return modelLink;
	}
	
	public String getdriverVersion()
	{
		String driverversion=properties.getProperty("DriverVersion");
		return driverversion;
	}
	
	public String getreleasedDate()
	{
		String releasedDate=properties.getProperty("ReleasedDate");
		return releasedDate;
	}
	
	public String getFileNamePS_x64()
	{
		String fileNamePS_x64=properties.getProperty("FileNamePS_x64");
		return fileNamePS_x64;
	}
	
	public String getFileNamePS_x86()
	{
		String fileNamePS_x86=properties.getProperty("FileNamePS_x86");
		return fileNamePS_x86;
	}
	
	public String getFileNamePCL_x64()
	{
		String fileNamePCL_x64=properties.getProperty("FileNamePCL_x64");
		return fileNamePCL_x64;
	}
	
	public String getFileNamePCL_x86()
	{
		String fileNamePCL_x86=properties.getProperty("FileNamePCL_x86");
		return fileNamePCL_x86;
	}
	
	public String getSize_PS_x64()
	{
		String size_PS_x64=properties.getProperty("Size_PS_x64");
		return size_PS_x64;
	}
	
	public String getSize_PS_x86()
	{
		String Size_PS_x86=properties.getProperty("Size_PS_x86");
		return Size_PS_x86;
	}
	
	public String getSize_PCL6_x64()
	{
		String size_PCL6_x64=properties.getProperty("Size_PCL6_x64");
		return size_PCL6_x64;
	}
	
	public String getSize_PCL6_x86()
	{
		String size_PCL6_x86=properties.getProperty("Size_PCL6_x86");
		return size_PCL6_x86;
	}
	
	public String getLanguage()
	{
		String language=properties.getProperty("Language");
		return language;
	}
	
	public String getTagGPD()
	{
		String tagGPD=properties.getProperty("TagGPD");
		return tagGPD;
	}
	
	public String getTagPS()
	{
		String tagPS=properties.getProperty("TagPS");
		return tagPS;
	}
	public String getTagPCL()
	{
		String tagPCL=properties.getProperty("TagPCL");
		return tagPCL;
	}
	
	public String getPSName()
	{
		String Psname=properties.getProperty("PSName");
		return Psname;
	}
	
	public String getPCLName()
	{
		String PCLname=properties.getProperty("PCLName");
		return PCLname;
	}
	
	public String getTagsPSName()
	{
		String TagsPSName=properties.getProperty("TagsPSName");
		return TagsPSName;
	}
	
	public String getTagsPCLName()
	{
		String TagsPCLName=properties.getProperty("TagsPCLName");
		return TagsPCLName;
	}
	
	public String getTgsGPDName()
	{
		String TagsGPDName=properties.getProperty("TagsGPDName");
		return TagsGPDName;
	}
	
	

	
	
}


