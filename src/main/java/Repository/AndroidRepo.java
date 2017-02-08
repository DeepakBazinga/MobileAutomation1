package Repository;

import com.core.FunctionLbrary;

import io.appium.java_client.MobileElement;

public class AndroidRepo extends FunctionLbrary{
	public MobileElement nextButton = (MobileElement) driverA.findElementById("com.officedepot.mobile.ui:id/useronboard_next_action");
}
