package com.testscripts.demoblazeweb;

import org.testng.annotations.Test;

import com.genericlib.demoblazeweb.Base;

public class Demo extends Base{
	
	@Test
	
	public void demoTest() {
		test=extent.createTest("Demo");
		test.pass("Executed demo");//to adding the pass statements
		test.skip("skip");
		test.warning("warning");
		test.fail("fail");//test case will be marked as fail
		test.info("information");//to displayed as a information text 
		// above all are the statements that we see in the extent report
	}

}
