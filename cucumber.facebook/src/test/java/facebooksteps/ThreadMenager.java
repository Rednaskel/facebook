package facebooksteps;

import cucumber.api.java.en.Then;
import threading.SearchThread;


public class ThreadMenager {

	private final int MAX_THREAD_COUNT = 3;
	
	
	@Then("^create new life$")
	public void createNewThread(){
		new Thread(new SearchThread()).start();
	}
}
