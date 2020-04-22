package basePack;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="24";
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("EmployeeRestAPI");  //added logger
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
}
