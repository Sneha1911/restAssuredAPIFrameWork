package testPack;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC7_DataProvider_TestNG {

	@Test(dataProvider = "EmpDataProvider")
	public void createNewRecord(String eName, String eSalary, String eAge) {
		// create base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// create request
		RequestSpecification httpRequest = RestAssured.given();

		// create json object
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", eName);
		requestParams.put("salary", eSalary);
		requestParams.put("age", eAge);

		// add a header stating the request body is JSON
		httpRequest.header("Content-Type", "application/json");

		// add jsn to the body of the request
		httpRequest.body(requestParams.toJSONString());

		// send request object
		Response response = httpRequest.request(Method.POST, "/create");

		// capture response body to perform validation
		String responseBody = response.getBody().asString();
		System.out.println("Employee Response body contains " + responseBody);

		Assert.assertEquals(responseBody.contains(eName), true);
		Assert.assertEquals(responseBody.contains(eAge), true);
		Assert.assertEquals(responseBody.contains(eSalary), true);

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@DataProvider(name = "EmpDataProvider")
	public String[][] getEmpData() {
		String empData[][] = { { "Sunil", "100000", "35" }, { "Sneha", "80000", "30" }, { "Jyothi", "60000", "55" } };
		return (empData);
	}
}
