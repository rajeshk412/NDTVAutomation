package com.home.msite.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.home.msite.base.BasePage;
import com.home.msite.utilities.Constants;
import com.home.msite.utilities.UtilMethods;

public class WeatherPage extends BasePage
{

	public WeatherPage(WebDriver driver)
	{
		super(driver);
	}
	public static HashMap<String, String> maps=new HashMap<String, String>();
	
	@FindBy(id=Constants.WEATHERPAGE_SEARCHTEXTFIELD_ID)
	private WebElement searchtextField;
	
	@FindBy(xpath=Constants.WEATHERPAGE_CITYNAMES_XPATH)
	private List<WebElement> cityNames;
	
	@FindBy(xpath=Constants.WEATHERPAGE_CITYDETAILS_XPATH)
	private WebElement cityDetails;
	
	@FindBy(xpath=Constants.WEATHERPAGE_CITYNAME_XPATH)
	private WebElement cityName;
	
	@FindBy(xpath=Constants.WEATHERPAGE_CITYCONDITION_XPATH)
	private WebElement cityCondition;
	
	@FindBy(xpath=Constants.WEATHERPAGE_WINDDETAILS_XPATH)
	private WebElement windDetails;
	
	@FindBy(xpath=Constants.WEATHERPAGE_HUMIDDETAILS_XPATH)
	private WebElement humidDetails;
	
	@FindBy(xpath=Constants.WEATHERPAGE_TEMPINDEGRESSDETAILS_XPATH)
	private WebElement tempInDegrees;
	
	@FindBy(xpath=Constants.WEATHERPAGE_TEMPINFAHRENHEITDETAILS_XPATH)
	private WebElement tempInFarhenheit;
	
	
	public boolean sendStringToTextfield()
	{
		UtilMethods.sendStringTotextField(driver, searchtextField, Constants.PINCODE);
		for(int i=0;i<cityNames.size();i++)
		{
			if(cityNames.get(i).getText().equalsIgnoreCase(Constants.PINCODE))
			{
				UtilMethods.webElementClick(driver, cityNames.get(i));
				return true;
			}
		}
		return false;
	}
	
	public void getCityDetails() throws IOException, InterruptedException
	{
		
		List<String> lists=new ArrayList<String>();
		Thread.sleep(2000);
//		System.out.println("city name is"+cityName.getText());
		maps.put("cityName", cityName.getText());
		maps.put("cityCondition", cityCondition.getText());
		maps.put("windDetails", windDetails.getText());
		maps.put("humidDetails", humidDetails.getText());
		maps.put("tempInDegrees", UtilMethods.extractInt(tempInDegrees.getText()));
		maps.put("tempInFarhenheit", tempInFarhenheit.getText());
		lists.add(UtilMethods.convertStringToJson(maps));

		for(int i=0;i<lists.size();i++)
		{
			UtilMethods.writer("WeatherDetails.json",lists);
		}
	}
	
}
