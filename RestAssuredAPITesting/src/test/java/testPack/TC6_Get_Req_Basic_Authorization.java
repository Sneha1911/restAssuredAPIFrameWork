package testPack;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC6_Get_Req_Basic_Authorization {

	@Test
	void getWeatherDetails() {
		//specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		
		RestAssured.authentication = authScheme;
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Response Object
		Response response = httpRequest.request(Method.GET,"/");
		
		//print response on console window
		String res = response.getBody().asString();
		System.out.println("Response of the resquest is "  + res);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code of Response is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status Line od Response is " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	
}
