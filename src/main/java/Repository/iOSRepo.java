package Repository;

import org.openqa.selenium.By;

import com.core.FunctionLbrary;

import io.appium.java_client.MobileElement;

public class iOSRepo extends FunctionLbrary {
	public MobileElement searchField = (MobileElement) driver.findElement(By.name("Search Products"));
}
