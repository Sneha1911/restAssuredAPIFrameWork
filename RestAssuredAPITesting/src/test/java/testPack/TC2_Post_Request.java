package testPack;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_Post_Request {

	@Test
	public void postRegistrationSuccess() {
		
		//Specify URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response payload sending along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Sneha");
		requestParams.put("LastName", "GB");
	    requestParams.put("UserName", "Snehagb");
	    requestParams.put("Password", "12334");
	    requestParams.put("Email","sneha123@gmail.com");
		
		httpRequest.header("Content-Type" , "application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/register");
		
		//print response on console window
		String res = response.getBody().asString();
		System.out.println("Response of the resquest is " + res);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code of Response is " + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//success code verification
		String successCode = response.jsonPath().get("SuccesssCode");
		System.out.println("Success Code of Response is " + successCode);
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
}
