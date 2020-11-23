package com.home.ndtv.NDTVAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import com.home.msite.base.BaseTest;
import com.home.msite.exception.ApplicationException;
import com.home.msite.pages.HomePage;
import com.home.msite.pages.WeatherPage;

public class GetWeatherDetailsFromUI extends BaseTest
{
	

	@Test
	public void launchBrowser() throws InterruptedException, ApplicationException, IOException
	{
		
		HomePage hp=new HomePage(driver);
		Object weatherPage = hp.clickOnHamburgerIcon(); 
		if(weatherPage instanceof WeatherPage)
		{
			((WeatherPage) weatherPage).sendStringToTextfield();
			((WeatherPage) weatherPage).getCityDetails();
		}
		else
		{
			
			reportFailure("The weather deatils doesn not exist on UI");
		}
	}
}
