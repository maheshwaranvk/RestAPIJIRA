package week3Day2;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIssue extends BaseClassJIRA {
	
	@Test(dataProvider = "jiraissues")
	public void createJIRAIssue(File file) {
		
		//sRestAssured.baseURI
		
	
		
		//File file = new File("./data/CreateIssueInJira.json");
		
	Response post = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(file)
		.post()
		.then()
		.assertThat()
		.statusCode(201)
		.extract()
		.response();
	//	.prettyPrint();
		
		JsonPath jsonPath = post.jsonPath();
		
	issueId.add(String.valueOf(jsonPath.get("id")));
	
	for (String string : issueId) {
		System.out.println(string);
	}
		
	}

}
