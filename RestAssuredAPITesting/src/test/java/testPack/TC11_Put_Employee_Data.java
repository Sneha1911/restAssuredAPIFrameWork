package testPack;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePack.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import junit.framework.Assert;
import utilPack.RestUtils;

public class TC11_Put_Employee_Data extends TestBase{

	String eName = RestUtils.empName();
	String eSal = RestUtils.empSalary();
	String eAge = RestUtils.empAge();
	
	@BeforeClass
	public void createEmp() throws InterruptedException {
		logger.info("*********** Start of TC11_Put_Employee_Data ***************");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", eName);
		requestParams.put("salary",eSal);
		requestParams.put("age", eAge);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.PUT,"/update/" +empID);
		
		Thread.sleep(3000);
	}
	
	@Test
	public void resValidation() {
		logger.info(" ************ Response Validation **********");
		String resBody = response.getBody().asString();
		logger.info("Response Body is : " +resBody);
		//Assert.assertEquals(resBody.contains(eName), true);
		//Assert.assertEquals(resBody.contains(eSal), true);
		//Assert.assertEquals(resBody.contains(eAge), true);
	}
	
	@Test
	public void statusCodeValidation() {
		logger.info("Status code is : " + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void statusLineValidation() {
		logger.info("Status Line is : " + response.getStatusLine());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	}
	
	@AfterClass
	public void teardown() {
		logger.info("********** End of TC11_Put_Employee_Data ************");
	}
}