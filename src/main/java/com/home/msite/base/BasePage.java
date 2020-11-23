package com.home.msite.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.home.msite.exception.ApplicationException;



public class BasePage 
{
	
	public  WebDriver driver;

	public BasePage()
	{
		
	}
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isElementPresentById(String element)throws ApplicationException
	{
		
		try {
			
			int s = driver.findElements(By.id(element)).size();
			
			if(s==0){
				
				return false;
			}
			else{
				
				return true;
			}
		} catch (Exception e) {
			throw new ApplicationException("Element not found", "Element not found exception");
		}
		
	}
	
	
}
