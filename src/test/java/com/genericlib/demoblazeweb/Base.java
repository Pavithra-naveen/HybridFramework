package com.genericlib.demoblazeweb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
public static WebDriver driver;
public FileLib f1 = new FileLib();
public CommonUtils cu=new CommonUtils();
public String propPath="src\\test\\resources\\LoginData.properties";
public static ExtentReports extent=new ExtentReports();//create the object of any perticular class/member
//ExtentSparkReporter spark=new ExtentSparkReporter("Extent.html");//extent.html file will be created in the demoblaze route folder itself
//or 
ExtentSparkReporter spark=new ExtentSparkReporter("test-output/Extent.html");//keep this as nonstatics
//extent.html file will be created under test-output/Extent.html folder 
public static ExtentTest test;

@BeforeTest // on which perticular annotation type we launch the browser?@BeforeTest annotation type
public void configBT() {
	extent.attachReporter(spark);//we have created the extent spark reported in the above here we just need to attach that.
	//above syntax indicated -->spark reporter as been attached or spark reporter type as been choosen.
	System.out.println("from Before Test");
     driver = new ChromeDriver();  // Launch the browser   
     driver.manage().window().maximize();  // Maximize the window
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     String url = f1.getDataFromProperties(propPath, "URL");
     driver.get(url);  // Navigate to the website
 }


 @BeforeMethod
 public void configBM() {
 WebDriverWait	Wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     System.out.println("from Before Method");
        driver.findElement(By.id("login2")).click();
         try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         Wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("loginusername"))));
         driver.findElement(By.id("loginusername")).sendKeys(f1.getDataFromProperties(propPath, "username"));
         driver.findElement(By.id("loginpassword")).sendKeys(f1.getDataFromProperties(propPath, "password"));
         driver.findElement(By.xpath("//button[text()='Log in']")).click();
         
        WebElement loggedInUser = driver.findElement(By.id("nameofuser"));
        String un= loggedInUser.getText();
         System.out.println(un);
        //Assert.assertTrue(un.contains(f1.getDataFromProperties(propPath, "username")));
  
     try {
         Thread.sleep(4000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }
 
 @AfterMethod
 public void configAM() {
     System.out.println("from After Method");
     driver.findElement(By.id("logout2")).click();
     try {
     	driver.findElement(By.id("logout2"));
     	}catch (NoSuchElementException e) {
     		e.printStackTrace();
     		System.out.println("Not logged out");
     	}
 }

 @AfterClass
 public void configAC() {
     System.out.println("from After Class");
   
 }

 @AfterTest
 public void configAT() {
     System.out.println("from After Test");
     driver.quit();
     extent.flush();//after execution of all the configuration methods and the test cases we should add this extent.flush() method this is mondatory to get the extent report otherwise you will not get the extent report
 }

 @AfterSuite
 public void configAS() {
     System.out.println("from After Suite");
 }
}