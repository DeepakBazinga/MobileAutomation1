package MobileAuto.Automation;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.core.FunctionLbrary;

import Repository.AndroidRepo;
import io.appium.java_client.MobileElement;

public class Test1 extends FunctionLbrary{
	
@Test
public void StartServerTest() throws MalformedURLException, IOException, InterruptedException
{
	startApplication();
	Thread.sleep(10000);
	
	
	//stopApplication("Android");
}
//@Test
//public void firstTap()
//{
//	nextButton.tap(1, 3000);
//}
}
