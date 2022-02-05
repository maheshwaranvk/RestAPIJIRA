package week3Day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssue extends BaseClassJIRA{

	
	@Test(dependsOnMethods = {"week3Day2.UpdateIssue.updateJiraIssue"})
	public void deleteIssueInJira() {

		for (String issueId : issueId) {
			Response delete = RestAssured
					.given()
					
					.delete(issueId)
					.then()
					.assertThat()
					.statusCode(204)
					.extract()
					.response();
		}

	}
}
