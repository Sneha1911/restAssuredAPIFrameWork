package testPack;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePack.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC12_Delete_Employee_Record extends TestBase {
	
	@BeforeClass
	public void createEmp() throws InterruptedException {
		logger.info("*********** Start of TC12_Delete_Employee_Record ***************");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		response = httpRequest.request(Method.GET,"/employees");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String empID = jsonPathEvaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE,"/delete/" +empID);
		
		Thread.sleep(3000);
	}
	
	@Test
	public void resValidation() {
		logger.info(" ************ Response Validation **********");
		String resBody = response.getBody().asString();
		logger.info("Response Body is : " +resBody);
		Assert.assertEquals(resBody.contains("successfully! deleted record"), true);
	}
	
}
