package com.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import com.core.LoggingMethods;
import io.appium.java_client.MobileBy;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSElement;
import com.core.FunctionLbrary;

public class CoreiOSMethods extends FunctionLbrary implements LoggingMethods 
{
	
		public void tapiOS(MobileBy locator,int finger)
		{
			log(true,"tapiOS : "+locator);
			IOSElement element= (IOSElement) driver.findElement(locator);
			log(true,"tapiOS : "+element);
			element.tap(finger, 2000);
		}
		public void sendKeysiOS(MobileBy locator, String text)
		{
			log(true,"sendKeysiOS "+text+"to : "+locator);
			IOSElement element= (IOSElement) driver.findElement(locator);
			log(true,"sendKeysiOS : "+element);
			element.sendKeys(text);
		}
		public void getKeyBoardAndSendKeysiOS(String text)
		{
			driver.getKeyboard().sendKeys(text);
		}
		public void waitforElement(MobileBy locator) throws InterruptedException
		{
			log(true,"waitforElement : "+locator);
			Thread.sleep(10000);
			IOSElement element= (IOSElement) driver.findElement(locator);
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
//		public void waitForVisible(MobileBy locator, int waitTime) throws InterruptedException 
//		{
//			WebDriverWait wait = new WebDriverWait(driver,waitTime);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//			
//		}
		public String getTextOnLocator(MobileBy locator)
		{
			log(true,"getTextOnLocator : "+locator);
			IOSElement element= (IOSElement) driver.findElement(locator);
			log(true,"getTextOnLocator : "+element);
			return element.getText();
			
		}
		public void iosDriverTimeOut(int seconds)
		{
			log(true,"iosDriverTimeOut");
			driver.manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
			
		}
		public void verifyElementContainsText(MobileBy locator, String text)
		{
			IOSElement element= (IOSElement) driver.findElement(locator);
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
			IOSElement element= (IOSElement) driver.findElement(locator);
			element.swipe(direction, duration);
		}
		public void swipeFromTopToBottomiPhone()
		{
			  log(true,"swipeFromTopToBottomiPhone");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth/2, 0, screenWidth/2, screenHeight,5);
		}
		public void swipeFromTopToBottomiPad()
		{
			  log(true,"swipeFromTopToBottomiPad");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth/2, 0, screenWidth/2, screenHeight,10);
		}
		public void swipeFromTopToBottom(int duration)
		{
			  log(true,"swipeFromTopToBottom");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth/2, 0, screenWidth/2, screenHeight,duration);
			
		}
		public void swipeFromBottomToTopiPhone()
		{
			  log(true,"swipeFromBottomToTopiPhone");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth/2, screenHeight, screenWidth/2, 0,5);
		}
		public void swipeFromBottomToTopiPad()
		{
			  log(true,"swipeFromBottomToTopiPad");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth/2, screenHeight, screenWidth/2, 0,10);
		}
		public void swipeFromBottomToTop(int duration)
		{
			  log(true,"swipeFromBottomToTop");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth/2, screenHeight, screenWidth/2, 0,duration);
			
		}
		public void swipeFromLeftToRightiPhone()
		{
			  log(true,"swipeFromLeftToRightiPhone");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(0, screenHeight/2, screenWidth, screenHeight/2,5);
		}
		public void swipeFromLeftToRightiPad()
		{
			  log(true,"swipeFromLeftToRightiPad");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(0, screenHeight/2, screenWidth, screenHeight/2,10);
		}
		public void swipeFromLeftToRight(int duration)
		{
			  log(true,"swipeFromLeftToRight");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(0, screenHeight/2, screenWidth, screenHeight/2,duration);
		}
		public void swipeFromRightToLeftiPhone()
		{
			  log(true,"swipeFromRightToLeftiPhone");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth, screenHeight/2, 0, screenHeight/2,5);
		}
		public void swipeFromRightToLeftiPad()
		{
			  log(true,"swipeFromRightToLeftiPad");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth, screenHeight/2, 0, screenHeight/2,10);
		}
		public void swipeFromRightToLeft(int duration)
		{
			  log(true,"swipeFromRightToLeft");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth, screenHeight/2, 0, screenHeight/2,duration);
		}
		public void swipeToBottomOfPage()
		{
			 log(true,"swipeToBottomOfPage");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth/2,screenHeight/2,screenWidth,0,10);
		}
		public void swipeToTopOfPage()
		{
		      log(true,"swipeToTopOfPage");
			  Dimension dimensions = driver.manage().window().getSize();
		      int screenWidth = dimensions.getWidth();
		      int screenHeight = dimensions.getHeight();
		      driver.swipe(screenWidth/2,screenHeight/2,screenWidth,screenHeight,10);
		}
		public void longPressiOS(MobileBy locator, int duration)
		{
			log(true,"longPressiOS : "+locator);
			IOSElement element= (IOSElement) driver.findElement(locator);
			log(true,"longPressiOS : "+element);
			element.tap(1, duration);
		}
}
