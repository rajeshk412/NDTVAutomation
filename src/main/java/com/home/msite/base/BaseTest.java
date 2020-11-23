package com.home.msite.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.home.msite.utilities.Constants;

public class BaseTest {
	
	DesiredCapabilities capabilities;
	public WebDriver driver;

	String deviceName;

	@BeforeTest
	public void preCondition() throws IOException, InterruptedException {

		Constants.loadConfigProp("Settings.properties");
		Object userAgent = null;
		Object width = "";
		Object height = "";
		Object pixelRatio = "";
		deviceName = Constants.DEVICE_NAME;
		if (deviceName.equalsIgnoreCase("Moto G4")) {
			userAgent = "Mozilla/5.0 (Linux; Android 7.0; Moto G (4) Build/NPJ25.93-14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
			width = 360;
			height = 640;
			pixelRatio = 3.0;
		} else if (deviceName.equalsIgnoreCase("Nexus 5")) {
			userAgent = "Mozilla/5.0 (Linux; Android 6.0.1; Nexus 5X Build/MMB29P) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.96 Mobile Safari/537.36";
			width = 411;
			height = 730;
			pixelRatio = 2.62;
		} else if (deviceName.equalsIgnoreCase("iphone 6S plus")) {
			userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_2_1 like Mac OS X) AppleWebKit/602.4.6 (KHTML, like Gecko) Version/10.0 Mobile/14D27 Safari/602.1";
			width = 375;
			height = 667;
			pixelRatio = 3.0;
		} else if (deviceName.equalsIgnoreCase("Micromax")) {
			userAgent = "Mozilla/5.0 (Linux; Android 6.0.1; SM-G935F Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.124 Mobile Safari/537.36";
			width = 360;
			height = 640;
			pixelRatio = 2.0;
		} else if (deviceName.equalsIgnoreCase("LYF")) {
			userAgent = "Mozilla/5.0 (Linux; Android 5.1; LS-4005 Build/LMY47D; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/46.0.2490.76 Mobile Safari/537.36";
			width = 320;
			height = 533;
			pixelRatio = 1.60;
		}
		String osDetails = System.getProperty("os.name").toLowerCase();
		
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width", width);
		deviceMetrics.put("height", height);
		deviceMetrics.put("pixelRatio", pixelRatio);
		Map<String, Object> mobileEmulation = new HashMap<String, Object>();

		mobileEmulation.put("deviceMetrics", deviceMetrics);
		mobileEmulation.put("userAgent", userAgent);

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName("chrome");
		if (osDetails.equalsIgnoreCase("mac os x")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//ChromeDriver//chromedriver");
			capabilities.setPlatform(Platform.MAC);
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//ChromeDriver//chromedriver.exe");
			capabilities.setPlatform(Platform.WINDOWS);
		}
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(Constants.WEBURL);
	}

	@AfterTest(alwaysRun=true)
	public void quit(){
		if(driver!=null)
			driver.close();
		
	}
	
	public void reportFailure(String failureMessage){
		
		Assert.fail(failureMessage);
	}
	
	

}
