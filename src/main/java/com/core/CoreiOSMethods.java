package com.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class CoreiOSMethods extends FunctionLbrary 
{
		public void tapiOS(By locator,int finger)
		{
			MobileElement element= (MobileElement) driver.findElement(locator);
			element.tap(finger, 3000);
		}
		public void sendKeysiOS(By locator, String text)
		{
			MobileElement element= (MobileElement) driver.findElement(locator);
			element.sendKeys(text);
		}
		public void waitforElement(By locator) throws InterruptedException
		{
			Thread.sleep(5000);
			MobileElement element= (MobileElement) driver.findElement(locator);
			while(!element.getCenter().toString().isEmpty())
			{
				System.out.println(element.getCenter().toString().isEmpty());
				wait(20000);
			}
			notifyAll();
		}
		public String getTextOnLocator(By locator)
		{
			MobileElement element= (MobileElement) driver.findElement(locator);
			return element.getText();
			
		}
		public void iosDriverTimeOut(int seconds)
		{
			driver.manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
		}
}
