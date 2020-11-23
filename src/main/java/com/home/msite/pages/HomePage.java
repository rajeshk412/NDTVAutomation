package com.home.msite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.home.msite.base.BasePage;
import com.home.msite.exception.ApplicationException;
import com.home.msite.utilities.Constants;
import com.home.msite.utilities.UtilMethods;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath=Constants.HOMEPAGE_HAMBRUGERICON_XPATH)
	private WebElement hamburgerIcon;
	
	@FindBy(xpath=Constants.HAMBURGER_WEATHERICON_XPATH)
	private WebElement weatherIcon;
	
	public Object clickOnHamburgerIcon() throws InterruptedException, ApplicationException
	{
		
		UtilMethods.webElementClick(driver, hamburgerIcon);
		Thread.sleep(2000);
		UtilMethods.webElementClick(driver, weatherIcon);
		if(isElementPresentById(Constants.WEATHERPAGE_SEARCHTEXTFIELD_ID))
		{
			WeatherPage wp=new WeatherPage(driver);
			return wp;
		}
		return this;
	}
	

}
