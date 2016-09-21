package threading;

import driverwrapper.DriverWrapper;
import driverwrapper.constants.SelectedDriver;

public class SearchThread implements Runnable{

	private FacebookPerson startPerson;
	
	public SearchThread(FacebookPerson startPerson) {
		this.startPerson = startPerson;
	}

	@Override
	public void run() {
		DriverWrapper driver = new DriverWrapper(SelectedDriver.value);
		driver.goToFriendsPage();
		startPerson.setFriendsIds(driver.getAllFriendsIds());
		driver.close();
	}

}
