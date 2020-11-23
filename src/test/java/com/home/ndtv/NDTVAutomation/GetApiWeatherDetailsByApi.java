package com.home.ndtv.NDTVAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import com.home.msite.pages.GetWeatherDetails;

public class GetApiWeatherDetailsByApi
{
	@Test
	public void getWeatherDetailsByApi() throws IOException {
		
		GetWeatherDetails gp = new GetWeatherDetails();
		gp.getWeatherDetails();
		
	}

}
