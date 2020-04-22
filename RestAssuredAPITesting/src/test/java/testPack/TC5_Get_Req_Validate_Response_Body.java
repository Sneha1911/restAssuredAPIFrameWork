package testPack;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC5_Get_Req_Validate_Response_Body {

	@Test
	void googleWeatherTest() {

		// Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET,"/Bangalore");

		//validating response body
		JsonPath path = response.jsonPath();		
		
		//System.out.println(path.get("City"));
		//System.out.println(path.get("Temperature"));
		//System.out.println(path.get("WindSpeed"));
		//System.out.println(path.get("Humidity"));
		
		Assert.assertEquals(path.get("City"), "Bengaluru");
		Assert.assertEquals(path.get("Temperature"), "33.65");
	}

}