package week3Day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;

public class BaseClassJIRA {
	
	public static List<String> issueId = new ArrayList<String>();
	
	@BeforeSuite
	public void setUpJiraValues() {
RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
		
		RestAssured.authentication = RestAssured
				.preemptive()
				.basic("hari.radhakrishnan@testleaf.com", "IF1rulHIZB9XTf71pepS26C1");

	}
	
	@DataProvider(name="jiraissues")
	public File[] invokeFile() {
		
		File [] file = new File[2];
		file[0] = new File("./data/CreateIssueInJira.json");
		file[1] = new File("./data/CreateIssueInJira2.json");
		
		return file;

	}

}
