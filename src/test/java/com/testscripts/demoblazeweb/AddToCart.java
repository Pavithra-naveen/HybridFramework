package com.testscripts.demoblazeweb;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblazeweb.Base;
import com.listeners.demoblazeweb.EventList;
import com.objectrepo.demoblazeweb.Homepage;
//if you add the below line it should be takes the screenshot automaticall whenever the test case gets failed
@Listeners(EventList.class)// add the @Listeners just above the class becouse to provide the instruction
//By adding the @Listeners annotation, you ensure that the listener(s) are automatically applied to all tests in the class
public class AddToCart extends Base {
	
@Test
public void addToCartTest() {
	test=extent.createTest("Add product to the cart");// this "test" will be available in the base class
	//adding the above statement again and again for in the each and every test cases, you can avoid this, how? Go to event list class ,right click go to source override/implement methods select and click on ok	
	Homepage hp=PageFactory.initElements(driver, Homepage.class);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	cu.clickOnProduct("Nokia lumia 1520", driver);//to click on the product
	test.pass("Clicked on the product");//to add the pass statement (after successful verification to add the pass statement)
	//to adding the statements this we can see it in the extent report
	try {
		//driver.findElement(By.xpath("//h2[text()='Samsung galaxy s6']/following-sibling::div/descendant::a"));
		//istead of writing this above entire line you can write like below line
		cu.addToCartButton("Nokia lumia 1520", driver);//navigate to add to cart button i.e, product details page
		System.out.println("Test Script passed");
		
	}
	catch(NoSuchElementException e) {
		e.printStackTrace();
		System.out.println("Test Script Failled");
		test.fail("Test Script Failled");//to add the fail statement
	}
	cu.addToCartButton("Nokia lumia 1520", driver).click();//click on add to cart button
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alt=driver.switchTo().alert();
	alt.accept();
	test.pass("Handeled alert");
	test.pass("Added to cart");
	//Assert.fail();//if exception is trown on test failure method will be exceuted then screenshot will be taken then abd attach to theExtent report
	//cu.captureScreenshot(driver);//to take screenshot
	hp.getCartLinktext().click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Assert.assertTrue(false);//intentionally to failling the test case.
}
}
