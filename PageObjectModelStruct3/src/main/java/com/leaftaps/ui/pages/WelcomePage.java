package com.leaftaps.ui.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods{
	
	public WelcomePage(RemoteWebDriver receivedDriver) {
		this.driver=receivedDriver; 
		
	}
	public HomePage clickCRMSFA() {
		WebElement elementLink = driver.findElement(By.linkText(prop2.getProperty("welcomepage.crmsfa")));
		elementLink.click();
		return new HomePage(driver);
	}
	public LoginPage clickLogout() {
		 driver.findElement(By.className(prop2.getProperty("loginpage.login"))).click();
		 return new LoginPage(driver);
	}

}
