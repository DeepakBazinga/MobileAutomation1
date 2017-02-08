package com.core;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class FunctionLbrary {
	public WebDriver driver;
	public AndroidDriver<WebElement> driverA;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
	Properties prop = new Properties();
	String propFileName = System.getProperty("user.dir")+"/resources/config.properties";
	InputStream inputStream ;
	void startServeriOS(String platform, String platformVersion, String appPath, String deviceName, String UDID, String reset) throws MalformedURLException, IOException
	{
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
		DesiredCapabilities cap = new DesiredCapabilities();
	    File f = new File(appPath);
	    cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.3");
	    cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
	    cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
	    cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
	    cap.setCapability(MobileCapabilityType.UDID, UDID);
	    cap.setCapability(MobileCapabilityType.APP,f.getAbsolutePath());
	    cap.setCapability("noReset", reset);
	    try {
	        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);   
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void stopServeriOS() {
		System.out.println("Stop driver");
		driver.quit();
		System.out.println("Stop appium service");
		appiumService.stop();
	}
	
	public void startServerAndroid(String appPath, String reset, String deviceName, String OSVersion, String platform,String appID) throws MalformedURLException
	{
		
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
        File app = new File(appPath);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("no",true);
        capabilities.setCapability("noReset", reset);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, OSVersion);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appID);
        driverA = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driverA.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	public void stopAndroidServer()
	{
		
			System.out.println("Stop driver");
			driverA.quit();
			System.out.println("Stop appium service");
			appiumService.stop();
	}

	public void startApplication() throws MalformedURLException , IOException
	{
		inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);
		inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);
		String reset=prop.getProperty("noReset");
		String platform=prop.getProperty("platform");
		String appPath=prop.getProperty("appPath");
		String OSVersion=prop.getProperty("OSVersion");
		String deviceName=prop.getProperty("deviceName");
		String appID=prop.getProperty("AppDeviceID");
		if(platform.equalsIgnoreCase("iOS"))
		{
			startServeriOS(platform,OSVersion,appPath,deviceName, appID, reset);
		}
		else if(platform.equalsIgnoreCase("Android"))
		{
			startServerAndroid(appPath,reset,deviceName,OSVersion,platform,appID);
		}
		else
		{
				
		}
		
	}
	public void stopApplication(String platform)
	{
		if(platform.equalsIgnoreCase("iOS"))
		{
			stopServeriOS();
		}
		else if(platform.equalsIgnoreCase("Android"))
		{
			stopAndroidServer();
		}
		else
		{
				
		}
	}
	
}
