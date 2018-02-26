package com.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;

public class CoreAndroidMethods  extends FunctionLbrary implements LoggingMethods 
{
	public void tapAndroid(MobileBy locator,int finger)
	{
		log(true,"tapAndroid : "+locator);
		AndroidElement element= (AndroidElement) driverA.findElement(locator);
		log(true,"tapAndroid : "+element);
		element.tap(finger, 2000);
	}
	public void sendKeysAndroid(MobileBy locator, String text)
	{
		log(true,"sendKeysAndroid "+text+"to : "+locator);
		AndroidElement element= (AndroidElement) driverA.findElement(locator);
		log(true,"sendKeysAndroid : "+element);
		element.sendKeys(text);
	}
	public void waitforElement(MobileBy locator) throws InterruptedException
	{
		log(true,"waitforElement : "+locator);
		Thread.sleep(10000);
		AndroidElement element= (AndroidElement) driverA.findElement(locator);
		log(true,"waitforElement : "+element);
		if(!element.isDisplayed())
		{			
			log(false,"Element not found");
			
		}
		else
		{
			log(true,"Element found");
		}
		
	}
	public String getTextOnLocator(MobileBy locator)
	{
		log(true,"getTextOnLocator : "+locator);
		AndroidElement element= (AndroidElement) driverA.findElement(locator);
		log(true,"getTextOnLocator : "+element);
		return element.getText();
		
	}
	public void AndroidDriverTimeOut(int seconds)
	{
		log(true,"AndroidDriverTimeOut");
		driverA.manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
		
	}
	public void verifyElementContainsText(MobileBy locator, String text)
	{
		AndroidElement element= (AndroidElement) driverA.findElement(locator);
		log(true,"verifyElementContainsText");
		if(element.getText().contains(text))
		{
			log(true,"Text : "+text+" found on element !");
		}
		else
		{
			log(false,"Text : "+text+"not found element !");
		}
		
	}
	public void swipeFromElement(MobileBy locator,SwipeElementDirection direction, int duration)
	{
		log(true,"Swiping "+direction.toString());
		AndroidElement element= (AndroidElement) driverA.findElement(locator);
		element.swipe(direction, duration);
	}
	public void swipeFromTopToBottom(int duration)
	{
		  log(true,"swipeFromTopToBottom");
		  Dimension dimensions = driverA.manage().window().getSize();
	      int screenWidth = dimensions.getWidth();
	      int screenHeight = dimensions.getHeight();
	      driverA.swipe(screenWidth/2, 0, screenWidth/2, screenHeight,duration);
		
	}

	public void swipeFromBottomToTop(int duration)
	{
		  log(true,"swipeFromBottomToTop");
		  Dimension dimensions = driverA.manage().window().getSize();
	      int screenWidth = dimensions.getWidth();
	      int screenHeight = dimensions.getHeight();
	      driverA.swipe(screenWidth/2, screenHeight, screenWidth/2, 0,duration);
		
	}
	
	public void swipeFromLeftToRight(int duration)
	{
		  log(true,"swipeFromLeftToRight");
		  Dimension dimensions = driverA.manage().window().getSize();
	      int screenWidth = dimensions.getWidth();
	      int screenHeight = dimensions.getHeight();
	      driverA.swipe(0, screenHeight/2, screenWidth, screenHeight/2,duration);
	}
	
	public void swipeFromRightToLeft(int duration)
	{
		  log(true,"swipeFromRightToLeft");
		  Dimension dimensions = driverA.manage().window().getSize();
	      int screenWidth = dimensions.getWidth();
	      int screenHeight = dimensions.getHeight();
	      driverA.swipe(screenWidth, screenHeight/2, 0, screenHeight/2,duration);
	}
	public void swipeToBottomOfPage()
	{
		 log(true,"swipeToBottomOfPage");
		  Dimension dimensions = driverA.manage().window().getSize();
	      int screenWidth = dimensions.getWidth();
	      int screenHeight = dimensions.getHeight();
	      driverA.swipe(screenWidth/2,screenHeight/2,screenWidth,0,10);
	}
	public void swipeToTopOfPage()
	{
	      log(true,"swipeToTopOfPage");
		  Dimension dimensions = driverA.manage().window().getSize();
	      int screenWidth = dimensions.getWidth();
	      int screenHeight = dimensions.getHeight();
	      driverA.swipe(screenWidth/2,screenHeight/2,screenWidth,screenHeight,10);
	}
	public void longPressAndroid(MobileBy locator, int duration)
	{
		log(true,"longPressiOS : "+locator);
		AndroidElement element= (AndroidElement) driverA.findElement(locator);
		log(true,"longPressiOS : "+element);
		element.tap(1, duration);
	}
}


