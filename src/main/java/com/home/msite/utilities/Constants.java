package com.home.msite.utilities;




import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class Constants 
{
	

	

	private static Properties prop = new Properties();
	public static int EXPLICIT_WAIT_TIME;
	public static int IMPLICIT_WAIT_TIME;
	public static int DEFAULT_WAIT_TIME;
	public static String APPLICATION_NAME;	
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String NEW_COMMAND_TIMEOUT;
	public static String PLATFORM_VERSION;
	public static String DEVICE_READY_TIMEOUT;
	public static String DEVICE_NAME;
	public static String WEBURL;
	public static String PINCODE;
	public static String APIKEY;
	public static String UNITSINTEMP;
	public static String APIENDPOINT;
	public static String MAGNITITUDE;
	public static String REPORTS_PATH=System.getProperty("user.dir")+"//Reports";
	private static DesiredCapabilities capabilities = new DesiredCapabilities();

	public static WebDriver driver;
	
	public static void loadConfigProp(String propertyFileName) throws IOException
			 {
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//Resources//"+propertyFileName);
		 prop.load(fis);

		EXPLICIT_WAIT_TIME = Integer
				.parseInt(prop.getProperty("explicit.wait"));
		IMPLICIT_WAIT_TIME = Integer
				.parseInt(prop.getProperty("implicit.wait"));
		DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
	
		DEVICE_NAME=prop.getProperty("device.name");
		WEBURL=prop.getProperty("web.url");	
		PINCODE=prop.getProperty("pincode");
		APIKEY=prop.getProperty("apiKey");
		UNITSINTEMP=prop.getProperty("unitsInTemp");
		APIENDPOINT=prop.getProperty("apiendpoint");
		MAGNITITUDE=prop.getProperty("magnititude");
		
	}
	
	public static WebDriver getDriver() throws MalformedURLException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		return driver;
	}
	
	
	
	//Homepage locators
	public static final String HOMEPAGE_HAMBRUGERICON_XPATH="//a[@class='sidenav-icn side-nav-trigger']";
	
	public static final String HAMBURGER_WEATHERICON_XPATH="//li[@class='snv_cn-li']/a[contains(text(),'Weather')]";	
	
	
	//Weatherpage locators
	
	public static final String WEATHERPAGE_SEARCHTEXTFIELD_ID="searchBox";
	public static final String WEATHERPAGE_CITYNAMES_XPATH="//div[@class='cityText']";
	public static final String WEATHERPAGE_CITYDETAILS_XPATH="//div[@class='leaflet-popup-content']";
	public static final String WEATHERPAGE_CITYNAME_XPATH="//*[@id=\"map_canvas\"]/div[1]/div[6]/div/div[1]/div/div/div/span[2]";
	public static final String WEATHERPAGE_CITYCONDITION_XPATH="//div[@class='leaflet-popup-content']//div[1]/span[1]";
	public static final String WEATHERPAGE_WINDDETAILS_XPATH="//div[@class='leaflet-popup-content']//div[1]/span[2]";
	public static final String WEATHERPAGE_HUMIDDETAILS_XPATH="//div[@class='leaflet-popup-content']//div[1]/span[3]";
	public static final String WEATHERPAGE_TEMPINDEGRESSDETAILS_XPATH="//div[@class='leaflet-popup-content']//div[1]/span[4]";
	public static final String WEATHERPAGE_TEMPINFAHRENHEITDETAILS_XPATH="//div[@class='leaflet-popup-content']//div[1]/span[5]";
	
	

}
