package utilPack;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String empName() {
		String randomName = RandomStringUtils.randomAlphabetic(2);
		return("Sneha"+randomName);
	}

	public static String empSalary() {
		String randomSal = RandomStringUtils.randomNumeric(5);
		return(randomSal);
	}
	
	public static String empAge() {
		String randomAge = RandomStringUtils.randomNumeric(2);
		return(randomAge);
	}
}
