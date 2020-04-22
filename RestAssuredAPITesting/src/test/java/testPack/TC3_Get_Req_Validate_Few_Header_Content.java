package testPack;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC3_Get_Req_Validate_Few_Header_Content {

	@Test
	void googleMapTest() {

		// Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET,"/Bangalore");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// validating headers
		String contentType = response.header("Content-Type");// capture details of Content-Type header
		System.out.println("Content Type is:" + contentType);
		Assert.assertEquals(contentType, "application/json");

		String contentEncoding = response.header("Content-Encoding");// capture details of Content-Encoding header
		System.out.println("Content Encoding is:" + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");

	}

}