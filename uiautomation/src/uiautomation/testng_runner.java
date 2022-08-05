package uiautomation;

import org.testng.TestNG;

public class testng_runner {
	
	//import the testNG package
	static TestNG testNg;

	public static void main(String[] args) {
		
		//instantiate the TestNG object
		testNg = new TestNG();
		
		//Set the test class we need to execute
		testNg.setTestClasses(new Class[] {testcase_initiator.class});
		
		//Run the testNG class
		testNg.run();
	}

}
