package testPack;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC4_Get_Req_Fetching_All_Header_Contents {

	@Test
	void googleWeatherTest() {

		// Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET,"/Bangalore");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		//getting all the header details
		Headers headers = response.headers();
		
		for(Header header : headers) {
			System.out.println(header.getName() + "                   "  + header.getValue());
		}
	}

}