package com.home.msite.pages;

import java.io.IOException;
import java.util.HashMap;

import com.home.msite.utilities.API;
import com.home.msite.utilities.Constants;
import com.home.msite.utilities.Executor;
import com.home.msite.utilities.Method;

import io.restassured.response.Response;

public class GetWeatherDetails 
{
	public static HashMap<String, String> apiMaps=new HashMap<String, String>();
	public  void getWeatherDetails() throws IOException
	{
		Constants.loadConfigProp("Settings.properties");
		HashMap<String, String> params = new HashMap<String,String>();
		params.put("q", Constants.PINCODE);
		params.put("appid", Constants.APIKEY);
		params.put("units", Constants.UNITSINTEMP);
		API api = new API(Method.GET, null, params, Constants.APIENDPOINT,null);
		Response res = Executor.run(api);
		String tempFromApi = res.getBody().jsonPath().getString("main.temp");
		apiMaps.put("tempFromApi", tempFromApi);
	}

}
