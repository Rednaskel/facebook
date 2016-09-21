package threading;

import driverwrapper.DriverWrapper;
import driverwrapper.constants.DriverType;

public class SearchThread implements Runnable{

	private FacebookPerson startPerson;
	
	public SearchThread(FacebookPerson startPerson) {
		this.startPerson = startPerson;
	}

	@Override
	public void run() {
		DriverWrapper driver = new DriverWrapper(DriverType.CHROME);
		driver.goToFriendsPage();
		startPerson.setFriendsIds(driver.getAllFriendsIds());
		driver.close();
	}

}
