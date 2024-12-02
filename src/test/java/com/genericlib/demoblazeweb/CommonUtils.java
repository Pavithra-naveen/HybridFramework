package com.genericlib.demoblazeweb;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {
	
	public void clickOnProduct(String productName,WebDriver driver) {
		for (int i = 0; i < 5; i++) {
			try {
				driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
				break;
			}
			catch(StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
		//product Name should be concatinate in the xpath,
		//ie.if i provide the productname this will take care of clicking on that, i.e, if i have to click on any other product name i dont hv to find the webElemnt or i dont hv to write the xpath of the locator for that, i can simply make use of this perticular method
}
	public WebElement addToCartButton(String productName,WebDriver driver) {
		return driver.findElement(By.xpath("//h2[text()='"+productName+"']/following-sibling::div/descendant::a"));
	}
	
	public void captureScreenshot(WebDriver driver) {
		TakesScreenshot ss=(TakesScreenshot)driver;//we hv down casted the driver object reference variable to the takesScreenshot(i,e this is the parent)
		// above we created the reference variable i,e ss
		//to store screenshots in file 
			File src=ss.getScreenshotAs(OutputType.FILE);// to taken screenshort and that will availanle in the RAM space of your system
			//File dest=new File("ScreenShots/image.png"); //old screenshot is replaced with the new screenshot because we gave the same images name for the screenshot
			//dest i,e destination folder and create the new folder in the same project itself then give that folder path
			//saved the screen shot inside this screenshots folder directly in my project folder itself and then store it an image.png
			//create another file object reference variable
			//file will be copied from src to the destination i,e to copy the image from our system to our project
			long currentTime=System.currentTimeMillis();//to get the screenshot in currentTime in milles sec
			 //if u not write the above line old screenshot is replaced with the new screenshot so to overcome this we should use the above line
			File dest=new File("ScreenShots/"+currentTime+".png");//everytime if screenshot is taken, file will be created and that will not be duplicate for the next screenshort
			 // replacing will never happend in the above code
			 try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
	
	


