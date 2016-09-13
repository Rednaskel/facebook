package threading;

import driverwrapper.DriverWrapper;
import driverwrapper.constants.DriverType;

public class SearchThread implements Runnable{

	@Override
	public void run() {
		DriverWrapper driver = new DriverWrapper(DriverType.CHROME);
		driver.goToFriendsPage();
		
	}

}
