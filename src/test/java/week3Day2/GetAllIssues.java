package week3Day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllIssues extends BaseClassJIRA{
	
	
	@Test(dependsOnMethods = {"week3Day2.CreateIssue.createJIRAIssue"})
	public void getIssues() {
		
		
		
		
		for (String issueType : issueId) {
			
			RestAssured
			.given()
			.accept(ContentType.JSON)
			.log().all()
			//.queryParam("JQL", "project=”RS”")
			//.queryParam("maxResults", 1)
			.get(issueType)
			.then()
			.assertThat()
			.statusCode(200)
			.extract()
			.response()
			.prettyPrint();
		}
		
		
		//System.out.println(response.statusCode());
	}

}
