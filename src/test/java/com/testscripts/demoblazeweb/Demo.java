package com.testscripts.demoblazeweb;

import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.genericlib.demoblazeweb.Base;

public class Demo extends Base{
	
	 private static final Logger logger = LoggerFactory.getLogger(Demo.class);
	
	@Test
	
	public void demoTest() {
		test=extent.createTest("Demo");
		test.pass("Executed demo");//to adding the pass statements
		test.skip("skip");
		test.warning("warning");
		test.fail("fail");//test case will be marked as fail
		test.info("information");//to displayed as a information text 
		// above all are the statements that we see in the extent report
		logger.info("Starting the test...");
        logger.debug("Debugging some details here...");
        logger.error("An error occurred during the test.");
	}

}
