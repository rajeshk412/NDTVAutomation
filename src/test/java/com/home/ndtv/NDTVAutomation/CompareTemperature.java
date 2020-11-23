package com.home.ndtv.NDTVAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.home.msite.pages.GetWeatherDetails;
import com.home.msite.pages.WeatherPage;
import com.home.msite.utilities.Constants;

public class CompareTemperature 
{
	@Test
	public void compareWeatherData()
	{
		
		 float tempFromUI = Float.parseFloat(WeatherPage.maps.get("tempInDegrees"));
		float tempFromApi = Float.parseFloat(GetWeatherDetails.apiMaps.get("tempFromApi"));
		System.out.println("ui"+tempFromUI+"api"+tempFromApi);
		float magnitude=Float.parseFloat(Constants.MAGNITITUDE);
		if((tempFromApi-tempFromUI)<=magnitude)
		{
			
			Assert.assertTrue((tempFromApi-tempFromUI)<=magnitude,"The difference between api and ui is less than or equal to magnitude mentioned");
		}
		else
		{
			Assert.fail("The difference between api and ui is more than magnitude mentioned");
		}
	}

}
