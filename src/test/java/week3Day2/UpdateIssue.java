package week3Day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateIssue extends BaseClassJIRA{
	
	@Test(dependsOnMethods = {"week3Day2.GetAllIssues.getIssues"})
	public void updateJiraIssue() {
		
		/*
		 * for (String string : issueId) { System.out.println(string);
		 * System.out.println("Mahesh"); }
		 */
		
		for (String issueId : issueId) {
			
			RestAssured
			.given()
			.log().all()
			.contentType(ContentType.JSON)
			.body(new File("./data/UpdateJiraIssue.json"))
			.pathParam("issueId", issueId)
			.put("{issueId}")
			.then()
			.assertThat()
			.statusCode(204)
			.extract()
			.response()
			.prettyPrint();
			System.out.println(issueId);
			
		}

	}

}
