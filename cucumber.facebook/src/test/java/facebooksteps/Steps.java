package facebooksteps;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import cucumber.api.java.en.Given;


public class Steps {
	
		
	@Given("^I got credentials form file \"(.*)\"$")
	public void getCredentialsFromFile(String filePathInResources) throws IOException{
		final String filepath = "src/test/resources/credentials/" +filePathInResources;
		List<String> fileContent = Files.readAllLines(Paths.get(filepath));
		for (String line : fileContent) {
			String parameter = null;
			try {
				parameter = line.substring(0, line.indexOf("="));
			} catch (Exception e) {
				System.err.println("Credential file has some additional lines");
			}
			
			switch (parameter) {
			case "username":
				DriverSteps.setFacebookUser(line.substring(line.indexOf("=") +1));
				break;
			case "password":
				DriverSteps.setFacebookPassword(line.substring(line.indexOf("=") +1));
			default:
				break;
			}
		}
	}

	
}
