package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class FunctionLbrary implements  LoggingMethods {
	public IOSDriver<IOSElement> driver;
	public AndroidDriver<AndroidElement> driverA;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
	Properties prop = new Properties();
	String propFileName = System.getProperty("user.dir")+"/resources/config.properties";
	InputStream inputStream ;
	public IOSDriver<IOSElement> getDriveriOS()
	{
		log(true,"getDriveriOS");
		return driver;
	}
	public AndroidDriver<AndroidElement> gertDriverAndroid()
	{
		log(true,"gertDriverAndroid");
		return driverA;
	}
	public void startServeriOS(String platform, String platformVersion, String appPath, String deviceName, String UDID, Boolean noReset) throws MalformedURLException, IOException
	{
		log(true,"startServeriOS : Appium Version-1.6.3"+" Device Name-"+deviceName+" iOS Version-"+platformVersion+" UDID-"+UDID+" Application Path-"+appPath);
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
		DesiredCapabilities cap = new DesiredCapabilities();
	    File f = new File(appPath);
	    cap.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole/");
	    cap.setCapability("xcodeConfigfile", "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/xcodeConfigFile");
	    cap.setCapability("automationName", "XCUITest");
	    cap.setCapability(IOSMobileCapabilityType.APP_NAME, "1.6.3");
	    cap.setCapability(IOSMobileCapabilityType.APP_NAME, f.getAbsolutePath());
	    cap.setCapability(IOSMobileCapabilityType.PLATFORM, platform);
	    cap.setCapability(IOSMobileCapabilityType.VERSION, platformVersion);
	    cap.setCapability("udid", UDID);
	    cap.setCapability("deviceName",deviceName);
	    cap.setCapability("fullReset",false);
	    cap.setCapability("noReset",noReset);
	    //cap.setCapability("fullReset", true);
	    cap.setCapability(MobileCapabilityType.APP,f.getAbsolutePath());
	    //cap.setCapability("noReset", false);
	    try {
	        driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);   
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void stopServeriOS() {
		log(true,"stopServeriOS");
		driver.quit();
		log(true,"Stop appium service");
		appiumService.stop();
	}
	
	public void startServerAndroid(String appPath, Boolean reset, String deviceName, String OSVersion, String platform,String appID) throws MalformedURLException
	{
		log(true,"startServeriOS : Appium Version-1.6.3"+" Device Name-"+deviceName+" Android Version-"+OSVersion+" Package Name-"+appID+" Application Path-"+appPath);
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
        File app = new File(appPath);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("no",true);
        capabilities.setCapability("noReset", reset);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", OSVersion);
        //capabilities.setCapability(CapabilityType.VERSION, OSVersion);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("package", appID);
        driverA = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driverA.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	public void stopAndroidServer()
	{
			log(true,"stopAndroidServer");
			driverA.quit();
			log(true,"Stop appium service");
			appiumService.stop();
	}

	public void startApplication() throws MalformedURLException , IOException
	{
		log(true,"startApplication");
		inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);
		inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);
		Boolean reset=Boolean.valueOf(prop.getProperty("noReset"));
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
		log(true,"stopApplication");
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
