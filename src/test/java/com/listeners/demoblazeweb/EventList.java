package com.listeners.demoblazeweb;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.genericlib.demoblazeweb.Base;

public class EventList implements ITestListener	 {
//basically in order to take a screenshot automatially u need one class which is nothing but "EventList"

	public void onTestFailure(ITestResult result) {//if test case getting failed this will be called
		TakesScreenshot ss=(TakesScreenshot)Base.driver;//syntax to take screenshots
   File src = ss.getScreenshotAs(OutputType.FILE);//get the file from RAM space to the local file which is nothing but to the physical file what we created here the screenshot folder
//store this with the name src(source)
   //need a unique name in each time screenshot would be taken in order to do that let me provide the below line
    long time=System.currentTimeMillis();
 // reference image saved to disk
   File dest=new File("Screenshots/+time+.png"); //Destination file to provide the path of  screenshot
	//dest is the screenshot path i,e, physical copy available in your local drive.
   //add that perticular time which we have created and that should be end with .png
  //FileUtils.copyFile(src, dest); after the above line write this line then add the try catch block here
   String path=dest.getAbsolutePath();//to get the path of above code
   //this give u the absolute path of that particular file(screenshot)
   try {
	FileUtils.copyFile(src, dest);
} catch (IOException e) {
	e.printStackTrace();
}
   //attach the screenshot to this particular method, how to add that?
   Base.test.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());//to take the screenshot
   //pass the path of the screenshot 
     //don't forget to add the build(),otherwise screenshot will not be added to the extent report
   
	}

	@Override
	public void onTestStart(ITestResult result) {
	//in order to create the object	of "test" you can make use of this
		Base.test=Base.extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//after each @test  method this will be executed
		Base.test.pass("Test passes");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	//if any test cases getting skipped you can add the statements here	
		Base.test.fail("skipped");//add the fail statements here if any test cases getting skipped.so this particular statements will be added as a failure statements
	}

	@Override
	public void onStart(ITestContext context) {
		//before executing  all the test methods if you want to add any statements you van add it here
	}

	@Override
	public void onFinish(ITestContext context) {
	Base.extent.flush();//execute this line after executing all the test cases
	}
	//above all are the overridden methods

}
