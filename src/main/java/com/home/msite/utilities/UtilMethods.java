package com.home.msite.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.home.msite.exception.ApplicationException;



public class UtilMethods 
{
	public static void webElementClick(WebDriver driver, WebElement element)
	{
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	
	}
	
	public static void sendStringTotextField(WebDriver driver, WebElement element, String valueToSend)

	{	
//		element.clear();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		element.sendKeys(valueToSend);
		element.click();
		element.sendKeys(Keys.ENTER);
		
	}
	
	@SuppressWarnings("unchecked")
	public static void writer(String fileName,List<String> data) throws IOException
	{
		System.out.println(data);
		JSONArray jsonObj = new JSONArray();
		jsonObj.add(data);
		
		FileWriter file = new FileWriter(System.getProperty("user.dir")+"//Resources//"+fileName) ;
		
		@SuppressWarnings("resource")
		BufferedWriter bufferedWriter = new BufferedWriter(file);
		bufferedWriter.write(data.toString());
		
		bufferedWriter.flush();
	}
	
	public static String convertStringToJson(HashMap<String, String> maps)
	{
		Gson prettyJson = new GsonBuilder().setPrettyPrinting().create();
        String pretty = prettyJson.toJson(maps);
        
        return pretty;
		
	}
	
	public static String extractInt(String str) 
    { 
       
        str = str.replaceAll("[^\\d]", " "); 
        str = str.trim(); 
        str = str.replaceAll(" +", " "); 
        if (str.equals("")) 
            return "-1"; 
        return str; 
    } 
	
	
	
	

}
