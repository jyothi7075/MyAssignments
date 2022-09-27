package com.leaftaps.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods{
	
	public WelcomePage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver; 
		
	}
	public HomePage clickCRMSFA() {
		WebElement elementLink = driver.findElement(By.linkText("CRM/SFA"));
		elementLink.click();
		return new HomePage(driver);
	}
	public LoginPage clickLogout() {
		 driver.findElement(By.className("decorativeSubmit")).click();
		 return new LoginPage(driver);
	}

}
