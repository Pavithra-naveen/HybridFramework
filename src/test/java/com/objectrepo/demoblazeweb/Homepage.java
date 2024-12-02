package com.objectrepo.demoblazeweb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Homepage {
	@FindBy(id="cartur")//this id that i have copied from the webpage then in next line we should give the type where in basically going to use this perticular locator
	WebElement cartLinkText;
//we hv fond the element with the help of the findBY not with the driver.find element
	//so like this we hv to find the element and storing into the object repository
	
	@FindBys({@FindBy(xpath= "//a[text()='About us']"),@FindBy(linkText = "About us")})
	private WebElement aboutUsLinktext;
	
	//getters (provide the getters for the above perticular webelements)
	
	public WebElement getCartLinktext() { //public (in order to access outside the clases or outside the packeage)
		return cartLinkText;} //here return the perticular webelement
		//if any one in the team wants to use of this element they can simply call this perticular getter i,e, getCartLinktext() it will only give u the web element for the usage but not for the access for changing this perticular element
	// for providing modification for this method you can provide the setters
		// for providing access for only usage this method you can provide the getters
		public WebElement getAboutUsLinktext() {
			return aboutUsLinktext;
		}

}
