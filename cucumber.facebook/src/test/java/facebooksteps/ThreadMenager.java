package facebooksteps;

import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanParameterInfo;

import org.junit.internal.runners.statements.Fail;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import threading.FacebookPerson;
import threading.SearchThread;

import static org.junit.Assert.fail;


public class ThreadMenager {

	private final int MAX_THREAD_COUNT = 3;
	List<FacebookPerson> friendsChain = new ArrayList<>();
	private static FacebookPerson me = new FacebookPerson("Rednaskel"); //Start person
	
	@Then("^I get friends list$")
	public void createNewThread(){
		
		List<Thread> threadList = new ArrayList<>();
		threadList.add(new Thread(new SearchThread(me)));
		threadList.get(0).start();
		try {
			threadList.get(0).join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Given("^I have my friends list$")
	public void friendListNotEmpty(){
		if(me.getFriendsList() == null){
			fail("Friends list empty");
		}
	}
}
