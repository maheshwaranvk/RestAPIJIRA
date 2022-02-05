package week3Day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class AddAttachment {
	
	@Test
	public void addAttachmenttoanIssue() {
		
RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/23632/attachments";
		
		RestAssured.authentication = RestAssured
				.preemptive()
				.basic("hari.radhakrishnan@testleaf.com", "IF1rulHIZB9XTf71pepS26C1");
		
		Response post = RestAssured
		.given()
		.log().all()
		.contentType(ContentType.JSON)
		.header(new Header("Content-Type", "multipart/form-data"))
		.header(new Header("X-Atlassian-Token", "no-check"))
		.multiPart(new File("./data/DC 5.docx"))
		.post();
		
		System.out.println(post.statusCode());
		post.prettyPrint();

	}

}
