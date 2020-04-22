package testPack;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePack.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC9_Get_Single_Employee_Data extends TestBase {

	@BeforeClass
	public void getAllEmployeeData() throws InterruptedException{
		logger.info("************** Started  TC9_Get_Single_Employee_Data ****************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employee/"+empID);
		
		Thread.sleep(1000);
	}
	
	@Test
	public void checkResponseBody() {
		logger.info("***************** Checking Response Body *****************");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body =====> " + responseBody);
		Assert.assertEquals(responseBody.contains(empID),true);
	}
	
	@Test
	public void checkStatusCode() {
		logger.info("**************** Checking Status Code ****************");
		
		int code = response.getStatusCode();
		logger.info("Status Code is : " + code);
		Assert.assertEquals(code,200);
	}
	
	@Test
	public void checkResponseTime() {
		logger.info("*********** Checking response time *************");
		
		long responseTime = response.getTime();
		logger.info("Response time is : " + responseTime);
		if(responseTime > 2000) {
			logger.warn("Response time is longer than 2000");
		}
		Assert.assertTrue(responseTime<2000);
	}
	
	@Test
	public void checkStatusLIne() {
		logger.info("********* Checking Status Line of the response **********");
		
		String statusLine = response.getStatusLine();
		logger.info("Status line of the response is : " + statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}
	
	@Test
	public void checkContentType() {
		logger.info("************** Checking Content Type **************");
		
		String contentType = response.contentType();
		logger.info("Content type is : " + contentType);
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
	}
	
	@Test
	public void checkServerType() {
		logger.info("************** Checking Server type **************");
		
		String serverType = response.header("Server");
		logger.info("Server type is : " + serverType);
		Assert.assertEquals(serverType, "nginx/1.16.0");
	}
	
	@Test
	public void contentEncoding() {
		 logger.info("*************** Checking Content encoding ************");
		 
		 String contentEncoding = response.header("Content-Encoding");
		 logger.info("Content Encoding is : " + contentEncoding);
		 Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@Test
	public void checkContentLength() {
		 logger.info("*************** Checking Content Length ************");
		 
		 String contentLength = response.header("Content-Length");
		 logger.info("Content Length is : " + contentLength);
		 
		 if(Integer.parseInt (contentLength) < 1500) {
			 logger.warn("Content is less than 1500");
		 }
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("************** END OF TC9_Get_Single_Employee_Data **************** " );
	}
	
}
