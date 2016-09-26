package threading;

import java.util.List;

public class FacebookPerson {

	private FacebookPerson sourceFirend;
	private List<FacebookPerson> friends = null;
	private String id;
	private String name;
	
	
	public FacebookPerson(String id){
		this.id = id;
	}
	
	public void setFriendsIds(List<FacebookPerson> friends){
		this.friends = friends;
	}

	public List<FacebookPerson> getFriendsList() {
		return friends;
	}
	
}
